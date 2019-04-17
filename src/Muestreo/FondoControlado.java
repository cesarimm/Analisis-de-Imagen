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
public class FondoControlado {
    
      public static Image expansionLineal(Image imagenFondo, Image imagenObjeto){
        BufferedImage bi = ImageManager.toBufferedImage(imagenFondo);
        BufferedImage bObjeto = ImageManager.toBufferedImage(imagenObjeto);
        Color aux1, aux2;
        for(int i=0;i<bi.getWidth();i++)
            for(int j=0;j<bi.getHeight();j++){
                aux1=new Color(bi.getRGB(i, j));
                aux2=new Color(bObjeto.getRGB(i, j));
               // System.out.println(aux1.getRed()+" "+aux2.getRed());
                if(aux1.getRed()>aux2.getRed()+50||aux1.getRed()-50<aux2.getRed()){
                    bObjeto.setRGB(i, j, new Color(255,0,0).getRGB());
                }
            }
        
        return ImageManager.toImage(bObjeto);
    }
    
}
