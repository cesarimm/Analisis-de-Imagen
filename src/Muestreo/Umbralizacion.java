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
import java.util.Random;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class Umbralizacion {
    
      
     public static int ObtenerUmbralAutomatico(int histograma[]){
         //Calculamos el umbral inicial
         Random ran = new Random();
         int uR= ran.nextInt(256);
          System.out.println("Umbral: "+uR);
         int uA;
         // hacemos el proceso iterativo de reajuste del umbral inicial
         do{
          uA = uR;    
          uR = reajustarUmbral(uA,histograma);  
             System.out.println("Umbral: "+uR);
         }while(uR!=uA);
          
         return uR;
     }
     
    public static Image Umbralizacion(int u, Image imagen){
     BufferedImage bi = ImageManager.toBufferedImage(imagen); 
     //Recoorer el buffered 
     for(int i=0;i<bi.getWidth();i++){
         for(int j=0;j<bi.getHeight();j++){
             Color color = new Color(bi.getRGB(i, j));
                int prom = (color.getRed()+color.getGreen()+color.getBlue())/3;
                color=(prom<u)?new Color(0, 0, 0):new Color(255, 255, 255);
               // System.out.println(color.getRGB());
                bi.setRGB(i, j, color.getRGB());
         }
     }
     
     return ImageManager.toImage(bi);
    }
    

    private static int reajustarUmbral(int u, int[] histograma) {
     int aFi=0, aPi=0;
     int aFd=0, aPd=0;
     aPi+=histograma[0];
     for(int x=1;x<u;x++){
         aPi+=histograma[x]*x;
         aFi+=histograma[x];
     }
     
     for(int y=1;y<histograma.length;y++){
         aFd+=histograma[y]*y;
         aFd+=histograma[y];
     }
     
     if(aFi==0||aFd==0)return 0;
     
     int uI = aPi/aFi;
     int uD = aPd/aFd;        
     
     return (uI+uD)/2;
    }
    
}
