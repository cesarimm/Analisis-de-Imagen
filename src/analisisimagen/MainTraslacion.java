/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisimagen;

import GUI.JFrameFrio;
import GUI.JFrameImagen;
import Muestreo.Traslacion;
import Muestreo.Temperatura;
import io.ImageManager;
import java.awt.Image;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class MainTraslacion {
    
    public static void main(String args[]){
         Image imagen = ImageManager.openImage(); 
         //JFrameImagen frame2 = new JFrameImagen(imagen);
       //  JFrameImagen frame1 = new JFrameImagen( Traslacion.generarImagenEnNegativo(imagen, 69));
          //JFrameImagen frame1 = new JFrameImagen(Temperatura.generarImagenFria(Traslacion.generarImagenBrillo(imagen, 69), 100));
            JFrameFrio ff = new JFrameFrio(imagen);
          
        System.out.println("");
    }
    
}
