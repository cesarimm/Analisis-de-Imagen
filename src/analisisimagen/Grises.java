/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisimagen;

import GUI.JFrameDeslizable;
import GUI.JFrameImagen;
import Muestreo.EscalaGrises;
import Muestreo.HistogramaFrecuencias;
import Muestreo.Negativo;
import Muestreo.Umbralizacion;
import io.ImageManager;
import java.awt.Image;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class Grises {
    
    public static void main(String args[]){
         Image imagen = ImageManager.openImage();  
         JFrameImagen frame1 = new JFrameImagen( Negativo.generarImagenEnNegativo(imagen));
//         HistogramaFrecuencias hF = new HistogramaFrecuencias(imagen);
//         
//         JFrameImagen frame1 = new JFrameImagen(imagen);
//         Image grises = EscalaGrises.generarImagenEnGrises(imagen);
//         Image umbralizada = Umbralizacion.Umbralizacion(Umbralizacion.ObtenerUmbralAutomatico(hF.getHistogramaR()), grises);
//         JFrameImagen frame2 = new JFrameImagen(umbralizada);
//      // JFrameImagen frame3 = new JFrameImagen(umbralizada);
//     // JFrameDeslizable frame = new JFrameDeslizable(imagen, imagen);
        System.out.println("");
  }
    
}
