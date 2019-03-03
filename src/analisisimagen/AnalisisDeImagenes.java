/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisimagen;

import GUI.JFrameImagen;
import io.ImageManager;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;

/**
 *
 * @author Roberto Cruz Leija
 */
public class AnalisisDeImagenes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Image imagen = ImageManager.openImage();
        JFrameImagen frame1 = new JFrameImagen(imagen);
        BufferedImage bf = ImageManager.toBufferedImage(imagen);
        ColorModel colorcito;
        int red, green, blue, r, g, b;
        
        colorcito = bf.getColorModel();
//        
//       red = colorcito.getRed(bf.getRGB(346, 145));
//       green = colorcito.getGreen(bf.getRGB(346, 145));
//       blue = colorcito.getBlue(bf.getRGB(346, 145));

         red = 77;
         green = 255;
         blue = 10;
       
       Color verde = new Color(0, 0, 0);
            
        for(int i=0;i<bf.getWidth();i++)
            for(int j=0;j<bf.getHeight();j++){ 
                
                if(colorcito.getRed(bf.getRGB(i, j))<red+25&&colorcito.getRed(bf.getRGB(i, j))>red-25){
                    if(colorcito.getGreen(bf.getRGB(i, j))<green+50&&colorcito.getGreen(bf.getRGB(i, j))>green-15){
                    if(colorcito.getBlue(bf.getRGB(i, j))<blue+65&&colorcito.getBlue(bf.getRGB(i, j))>blue-25){
                    bf.setRGB(i, j, verde.getRGB());
                     bf.setRGB(i, j, verde.getRGB());
                      bf.setRGB(i, j, verde.getRGB());
                       bf.setRGB(i, j, verde.getRGB());
                    }
                  }
                }         
        
       }
        
        System.out.println("");
      
       
//       red = colorcito.getRed(bf.getRGB(346, 145));
//       green = colorcito.getGreen(bf.getRGB(346, 145));
//       blue = colorcito.getBlue(bf.getRGB(346, 145));
//
//        System.out.println("");
//        Color verde = new Color(254, 245, 1);
//        
//        bf.setRGB(345, 144, verde.getRGB());
//        bf.setRGB(346, 144, verde.getRGB());
//        bf.setRGB(345, 145, verde.getRGB());
//        bf.setRGB(346, 145, verde.getRGB());
        
      
        Image nueva = ImageManager.toImage(bf);  
        JFrameImagen frame2 = new JFrameImagen(nueva);    
        System.out.println();
            
    }
    
}
