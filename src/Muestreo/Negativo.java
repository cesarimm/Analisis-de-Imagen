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

//Nobuyuki Otsu

/**
 *
 * @author CESAR IVAN MTZ
 */
public class Negativo {
    
    public static Image generarImagenEnNegativo(Image original){
        BufferedImage bi = ImageManager.toBufferedImage(original);
        
        for(int i=0;i<bi.getWidth();i++)
            for(int j=0;j<bi.getHeight();j++){
                
                Color color = new Color(bi.getRGB(i, j));
                
               // int gris = (color.getRed()+color.getGreen()+color.getBlue())/3;
               int r=color.getRed()-255;
               int g=color.getGreen()-255;
               int b=color.getBlue()-255;
               
               if(r<0){
                   r*=-1;
               }
               
                if(g<0){
                   g*=-1;
               }
                
                 if(b<0){
                   b*=-1;
               }
                 
               color = new Color(r,g,b);
               
               bi.setRGB(i, j, color.getRGB());
            }
        
        return ImageManager.toImage(bi);
    }
    
}
