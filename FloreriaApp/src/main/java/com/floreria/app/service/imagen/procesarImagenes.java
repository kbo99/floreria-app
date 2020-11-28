package com.floreria.app.service.imagen;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.floreria.app.dao.producto.IProductoDao;
import com.floreria.app.model.imagen.Imagen;
import com.floreria.app.model.producto.Producto;
import com.floreria.app.util.FileUtils;

@Service
public class procesarImagenes {
	
	Logger logger = LoggerFactory.getLogger(procesarImagenes.class);
	
	/*
	@Autowired
	IProductoDao productoDao;
	
	@Autowired
	IIMagen imagenService;
	*/
	
	private Boolean imgIsInsumo = false;
	private String accessKey = "AKIA4STLWL2GRDBUH3FU";
	private String secretKey = "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";
	private String buncketName = "gyft.flowers.produccion";
	
	private AmazonS3 amazonS3;
	
	public void procesaImagenesMasiva(IProductoDao productoDao, IIMagen imagenService) {
		
		try {
			
			conectarAmazonS3();
			
			List<Producto>  lstProducto = productoDao.findAll();
			lstProducto.forEach(item -> {
				try {
					
					if (!item.getProdEstatus().equals("SU")) {
						
						item.setLstImg(imagenService.getLstImagByProd(item.getProdId()));
						
						imgIsInsumo = item.isProdEsInsumo();
						
						if(item.getLstImg() != null && item.getLstImg().size() > 0) {
							
							Integer contImg = 1;
							for (Imagen imgProd : item.getLstImg()) {
								
								String extension = imgProd.getImgUrl().split(";")[0];
								extension = extension.split("/")[1];
								
								String name = Integer.toString(item.getProdId()) + "_" + contImg + "." + extension;
								String originalFileName = name;
								String contentType = "image/" + extension;
								byte[] content = Base64.getDecoder().decode(imgProd.getImgUrl().split(",")[1]);
								
								content = ImageResizer.redimencionarImagen(content,extension);
								
								MultipartFile imagen = new MockMultipartFile(name,
					                    originalFileName, contentType, content);
								
								uploadMultipartFile(imagen);
								
								if(imgIsInsumo) {
									imgProd.setImgUrl("insumos/" + name);
								} else {
									imgProd.setImgUrl("productos/" + name);
								}
								
								imagenService.update(imgProd);
								
								contImg += 1;
							}
						}
						
					}
				} catch (Exception e) {
					logger.error("Error al ejecutar 'procesaImagenes'  \n" + e.getMessage() + e.getCause(), e);
					e.printStackTrace();
				}
			});
		} catch (Exception e) {
			logger.error("Error al ejecutar 'procesaImagenes'  \n" + e.getMessage() + e.getCause(), e);
		}
	}
	
	// Make upload to Amazon.
    private void uploadMultipartFile(MultipartFile multipartFile) {
        try {
            // Get the file from MultipartFile.
            File file = FileUtils.convertMultipartToFile(multipartFile);

            // Extract the file name.
            String fileName = FileUtils.generateFileName(multipartFile);

            // Upload file.
            uploadPublicFile(fileName, file);
            
        } catch (IOException e) {

            // If IOException on conversion or any file manipulation, call exception.
            //log.warn(MessageUtil.getMessage("multipart.to.file.convert.except"), e);
        	logger.error("multipart.to.file.convert.except");
            //throw new FileConversionException();
        }
        
    }
    
    private void conectarAmazonS3() {
    	 // Init your AmazonS3 credentials using BasicAWSCredentials.
        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);        
        
        // Start the client using AmazonS3ClientBuilder, here we goes to make a standard cliente, in the
        // region SA_EAST_1, and the basic credentials.
        amazonS3 = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.US_EAST_2)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();    	
    }

    // Send image to AmazonS3, if have any problems here, the image fragments are removed from amazon.
    // Font: https://docs.aws.amazon.com/AWSJavaSDK/latest/javadoc/com/amazonaws/services/s3/AmazonS3Client.html#putObject%28com.amazonaws.services.s3.model.PutObjectRequest%29
    private void uploadPublicFile(String fileName, File file) {
    	
    	
    	String buncketNameAux;
    	
        if (imgIsInsumo) {
        	buncketNameAux = buncketName + "/insumos";
        } else {
        	buncketNameAux = buncketName + "/productos";
        }
    	
        amazonS3.putObject(new PutObjectRequest(buncketNameAux, fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
    	
        /*
    	getClient().putObject(new PutObjectRequest(getBucketName(), fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
        */
    }

}
