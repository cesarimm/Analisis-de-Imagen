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
 * @author CESAR IVAN MTZ
 */
public class Chroma {  
    public static void main(String args[]){
        
        Image imagen = ImageManager.openImage();
        Image imagenFondo = ImageManager.openImage();
        
        //JFrameImagen frame1 = new JFrameImagen(imagen);
        BufferedImage bf = ImageManager.toBufferedImage(imagen);
        BufferedImage biFondo = ImageManager.toBufferedImage(imagenFondo);
        ColorModel colorcito;
        int red, green, blue, r, g, b;
        
        colorcito = bf.getColorModel();

         red = 77;
         green = 255;
         blue = 10;
       
       //Color verde = new Color(0, 0, 0);
            
//        for(int i=0;i<bf.getWidth();i++)
//            for(int j=0;j<bf.getHeight();j++){                 
//                if(!(colorcito.getRed(bf.getRGB(i, j))<red+15&&colorcito.getRed(bf.getRGB(i, j))>red-15)){
//                    if(!(colorcito.getGreen(bf.getRGB(i, j))<green+15&&colorcito.getGreen(bf.getRGB(i, j))>green-15)){
//                    if(!(colorcito.getBlue(bf.getRGB(i, j))<blue+15&&colorcito.getBlue(bf.getRGB(i, j))>blue-15)){   
//                     biFondo.setRGB(i, j, bf.getRGB(i, j));
//                    }
//                  }
//                }           
//       }

       for(int i=0;i<bf.getWidth();i++)
            for(int j=0;j<bf.getHeight();j++){       
                if(!(colorcito.getRed(bf.getRGB(i, j))<red+3&&colorcito.getRed(bf.getRGB(i, j))>red-3)){
                    if(!(colorcito.getGreen(bf.getRGB(i, j))<green+3&&colorcito.getGreen(bf.getRGB(i, j))>green-3)){
                    if(!(colorcito.getBlue(bf.getRGB(i, j))<blue+3&&colorcito.getBlue(bf.getRGB(i, j))>blue-3)){   
                     biFondo.setRGB(i, j, bf.getRGB(i, j));
                    }
                  }
                }         
        }        
        
        System.out.println("");
        
      
        Image nueva = ImageManager.toImage(biFondo);  
        JFrameImagen frame2 = new JFrameImagen(nueva);    
        System.out.println();
        
    }   
}
