/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Muestreo;
///Frio valor al azul y quitar el rojo
///Caliente valor al rojo y quitar al azul

import io.ImageManager;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

//Nota verde no se toca
/**
 *
 * @author CESAR IVAN MTZ
 */
public class Temperatura {
    
          public static Image generarImagenCaliente(Image original, int c){
        BufferedImage bi = ImageManager.toBufferedImage(original);
        
        for(int i=0;i<bi.getWidth();i++)
            for(int j=0;j<bi.getHeight();j++){
                
                Color color = new Color(bi.getRGB(i, j));
                
               // int gris = (color.getRed()+color.getGreen()+color.getBlue())/3;
               int r=color.getRed()+c;
               int b=color.getBlue()-c;
               
               if(r<0){
                   r=0;
               }
                  
                 if(b<0){
                   b=0;
               }
                 
                 if(r>255){
                   r=255;
               }
                
                 if(b>255){
                   b=255;
               }
                 
                 
               color = new Color(r,color.getGreen(),b);
               
               bi.setRGB(i, j, color.getRGB());
            }
        
        return ImageManager.toImage(bi);
    }
          
       
       public static Image generarImagenFria(Image original, int c){
        BufferedImage bi = ImageManager.toBufferedImage(original);
        
        for(int i=0;i<bi.getWidth();i++)
            for(int j=0;j<bi.getHeight();j++){
                
                Color color = new Color(bi.getRGB(i, j));
                
               // int gris = (color.getRed()+color.getGreen()+color.getBlue())/3;
               int r=color.getRed()-c;
               int b=color.getBlue()+c;
               
               if(r<0){
                   r=0;
               }
                  
                 if(b<0){
                   b=0;
               }
                 
                 if(r>255){
                   r=255;
               }
                
                 if(b>255){
                   b=255;
               }
                 
                 
               color = new Color(r,color.getGreen(),b);
               
               bi.setRGB(i, j, color.getRGB());
            }
        
        return ImageManager.toImage(bi);
    }      
}

    

