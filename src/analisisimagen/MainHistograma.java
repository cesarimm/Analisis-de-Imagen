/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisimagen;

import GUI.JFrameImagen;
import Muestreo.HistogramaFrecuencias;
import io.ImageManager;
import java.awt.Image;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class MainHistograma {
    
      public static void main(String[] args) {
        Image imagen = ImageManager.openImage();
        JFrameImagen frame1 = new JFrameImagen(imagen);
        HistogramaFrecuencias hf = new HistogramaFrecuencias(imagen);
        hf.graficarHistogramasRGB();
        
        System.out.println();
            
    }
    
}
