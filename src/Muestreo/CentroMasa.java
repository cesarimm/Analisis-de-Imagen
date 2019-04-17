/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Muestreo;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class CentroMasa {
    
        public static BufferedImage calcularCentro(BufferedImage bi){
        int divisor=0,promedioX=0,promedioY=0;
        Color muestra;
        for (int i = 0; i < bi.getWidth(); i++) {
            for (int j = 0; j < bi.getHeight(); j++) {
                muestra = new Color(bi.getRGB(i, j));
                if(muestra.getRed()==0){
                    promedioX+=i;
                    promedioY+=j;
                    divisor++;
                }       
            }
        }
        
        if(divisor!=0){
            promedioX/=divisor;
            promedioY/=divisor;
            for (int i = promedioX-3; i < promedioX+3; i++) {
                for (int j = promedioY-3; j < promedioY+3; j++){
                    bi.setRGB(i, j, Color.RED.getRGB());
                }
            }
            
        }
        
        return bi;
    }
    
}
