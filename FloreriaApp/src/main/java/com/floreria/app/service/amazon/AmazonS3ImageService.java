package com.floreria.app.service.amazon;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.floreria.app.model.imagen.Imagen;
import com.floreria.app.util.*;

@Log4j2
@Service
public class AmazonS3ImageService {
	
	Logger logger = LoggerFactory.getLogger(AmazonS3ImageService.class); 
	 
	/**
	 * Determina si la imagen a cargar corresponde a un insumo, esto pasa saber a que carpeta del buncket se va
	 */
	public Boolean imgIsInsumo = false;
    
    public void insertImagen(MultipartFile imagen) {
        uploadImageToAmazon(imagen);
    }

    // Upload image to AWS S3.
    public void uploadImageToAmazon(MultipartFile multipartFile) {

        // Valid extensions array, like jpeg/jpg and png.
        List<String> validExtensions = Arrays.asList("jpeg", "jpg", "png");

        // Get extension of MultipartFile
        String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        if (!validExtensions.contains(extension)) {
            // If file have a invalid extension, call an Exception.
            //log.warn(MessageUtil.getMessage("invalid.image.extesion"));
        	logger.error("invalid.image.extesion");
            throw new InvalidImageExtensionException(validExtensions);
        } else {

            // Upload file to Amazon.
            uploadMultipartFile(multipartFile);
        }

    }

    public void removeImageFromAmazon(Imagen amazonImage) {
        //String fileName = amazonImage.getImageUrl().substring(amazonImage.getImageUrl().lastIndexOf("/") + 1);
        //getClient().deleteObject(new DeleteObjectRequest(getBucketName(), fileName));
        //amazonImageRepository.delete(amazonImage);
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
            throw new FileConversionException();
        }
        
    }

    // Send image to AmazonS3, if have any problems here, the image fragments are removed from amazon.
    // Font: https://docs.aws.amazon.com/AWSJavaSDK/latest/javadoc/com/amazonaws/services/s3/AmazonS3Client.html#putObject%28com.amazonaws.services.s3.model.PutObjectRequest%29
    private void uploadPublicFile(String fileName, File file) {
    	
    	AmazonS3 amazonS3;
        String buncketName = Const.S3_BUNCKET_NAME;
        
    	
        if (imgIsInsumo) {
        	buncketName = buncketName + "/insumos";
        } else {
        	buncketName = buncketName + "/productos";
        }
        
    	 // Init your AmazonS3 credentials using BasicAWSCredentials.
        BasicAWSCredentials credentials = new BasicAWSCredentials(Const.S3_ACCESS_KEY, Const.S3_SECRET_KEY);        
        
        // Start the client using AmazonS3ClientBuilder, here we goes to make a standard cliente, in the
        // region SA_EAST_1, and the basic credentials.
        amazonS3 = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.US_EAST_2)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    	
        amazonS3.putObject(new PutObjectRequest(buncketName, fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
    	
        /*
    	getClient().putObject(new PutObjectRequest(getBucketName(), fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
        */
    }

}
