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
public class EscalaGrises {
    
    public Image generarImageEnGrises;
    
    public static Image generarImagenEnGrises(Image original){
        BufferedImage bi = ImageManager.toBufferedImage(original);
        
        for(int i=0;i<bi.getWidth();i++)
            for(int j=0;j<bi.getHeight();j++){
                
                Color color = new Color(bi.getRGB(i, j));
                int gris = (color.getRed()+color.getGreen()+color.getBlue())/3;
                
               color = new Color(gris, gris, gris);
               
               bi.setRGB(i, j, color.getRGB());
            }
        
        return ImageManager.toImage(bi);
    }
    
}
