/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Muestreo;

import io.ImageManager;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class Expansion {
      public static Image expansionLineal(double min, double max, Image imagenOriginal){
        BufferedImage bi = ImageManager.toBufferedImage(imagenOriginal);
        // recorremos la imagen 
        for(int x=0; x<bi.getWidth();x++){
            for (int y=0;y<bi.getHeight();y++){
            // extraer los valores por canal
            Color color = new Color(bi.getRGB(x, y));
            int r = (int)validarRango((255/(max-min))*(color.getRed()-min));
            int g = (int)validarRango((255/(max-min))*(color.getGreen()-min));
            int b = (int)validarRango((255/(max-min))*(color.getBlue()-min));
            color = new Color(r, g, b);
            bi.setRGB(x, y, color.getRGB());
            }
        }
        return ImageManager.toImage(bi);
    }
    
    
  
      
    public static Image expansionLogaritmica(int j ,Image imagenOriginal){
        BufferedImage bi = ImageManager.toBufferedImage(imagenOriginal);
        // recorremos la imagen 
        for(int x=0; x<bi.getWidth();x++){
            for (int y=0;y<bi.getHeight();y++){
            // extraer los valores por canal
            Color color = new Color(bi.getRGB(x, y));
            int r = (int)validarRango(255*Math.log(j+color.getRed())/Math.log(256));
            int g = (int)validarRango(255*Math.log(j+color.getGreen())/Math.log(256));
            int b = (int)validarRango(255*Math.log(j+color.getBlue())/Math.log(256));
            color = new Color(r, g, b);
            bi.setRGB(x, y, color.getRGB());
            }
        }
        return ImageManager.toImage(bi);
    }
    
    
    
    public static Image expansionExponencial(double z ,Image imagenOriginal){
        BufferedImage bi = ImageManager.toBufferedImage(imagenOriginal);
        // recorremos la imagen 
        for(int x=0; x<bi.getWidth();x++){
            for (int y=0;y<bi.getHeight();y++){
            // extraer los valores por canal
            Color color = new Color(bi.getRGB(x, y));
            int r = (int)validarRango(Math.pow(1+z,color.getRed())/z);
            int g = (int)validarRango(Math.pow(1+z,color.getGreen())/z);
            int b = (int)validarRango(Math.pow(1+z,color.getBlue())/z);
            color = new Color(r, g, b);
            bi.setRGB(x, y, color.getRGB());
            }
        }
        return ImageManager.toImage(bi);
    }
    
    //////////////////////////////////
     public static Image expansionMine(double z,Image imagenOriginal){
        BufferedImage bi = ImageManager.toBufferedImage(imagenOriginal);
        // recorremos la imagen 
        for(int x=0; x<bi.getWidth();x++){
            for (int y=0;y<bi.getHeight();y++){
            // extraer los valores por canal
            Color color = new Color(bi.getRGB(x, y));
            
                
            int r = (int)validarRango((Math.pow(3, color.getRed())*Math.sin(z))/Math.pow(2, 255));
            int g = (int)validarRango((Math.pow(3, color.getGreen())*Math.sin(z))/Math.pow(2, 255));
            int b = (int)validarRango((Math.pow(3, color.getBlue())*Math.sin(z))/Math.pow(2, 255));
            color = new Color(r, g, b);
            bi.setRGB(x, y, color.getRGB());
            }
        }
        return ImageManager.toImage(bi);
    }
    
    
    public static double validarRango(double valor){
        if(valor>255)return 255;
        if(valor<0)return 0;
        return valor;
    
    }
}
