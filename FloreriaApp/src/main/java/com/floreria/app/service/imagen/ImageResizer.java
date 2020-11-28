/**
 * 
 */
package com.floreria.app.service.imagen;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
 
public class ImageResizer {
    //Ancho máximo
    public static int MAX_WIDTH=400;
    //Alto máximo
    public static int MAX_HEIGHT=400;
 
    /**
     * Metodo mediante el cual se precesa el redimensionamiento de la imagen
     * @param imagenOriginal imagen en byte[]
     * @param imgExtension extension de la imagen
     * @return imegan redimensionada en byte[]
     * @throws IOException
     */
    public static byte[] redimencionarImagen(byte[] imagenOriginal, String imgExtension) throws IOException {
    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	
    	InputStream is = new ByteArrayInputStream(imagenOriginal);    	
        BufferedImage bimage = ImageIO.read(is);//loadImage(filePath);
        if(bimage.getHeight()>bimage.getWidth()){
            int heigt = (bimage.getHeight() * MAX_WIDTH) / bimage.getWidth();
            bimage = resize(bimage, MAX_WIDTH, heigt);
            int width = (bimage.getWidth() * MAX_HEIGHT) / bimage.getHeight();
            bimage = resize(bimage, width, MAX_HEIGHT);
        }else{
            int width = (bimage.getWidth() * MAX_HEIGHT) / bimage.getHeight();
            bimage = resize(bimage, width, MAX_HEIGHT);
            int heigt = (bimage.getHeight() * MAX_WIDTH) / bimage.getWidth();
            bimage = resize(bimage, MAX_WIDTH, heigt);
        }
        
        //ImageIO.write(bimage, "jpg", baos);
        ImageIO.write(bimage, imgExtension, baos);
        return baos.toByteArray();
    }
     
    /*
    Este método se utiliza para redimensionar la imagen
    */
    public static BufferedImage resize(BufferedImage bufferedImage, int newW, int newH) {
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        BufferedImage bufim = new BufferedImage(newW, newH, bufferedImage.getType());
        Graphics2D g = bufim.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(bufferedImage, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return bufim;
    }
}
