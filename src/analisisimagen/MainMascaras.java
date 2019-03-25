/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisimagen;

import GUI.JFrameImagen;
import Muestreo.Mascaras;
import io.ImageManager;
import java.awt.Image;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class MainMascaras {
    public static void main(String args[]){
         Image imagen = ImageManager.openImage();
         JFrameImagen frame1 = new JFrameImagen(imagen);
         
         Mascaras k = new Mascaras(imagen);
         JFrameImagen frame2 = new JFrameImagen(k.aplicarMascaras(1, 6));  
       // JFrameImagen frame3 = new JFrameImagen(k.aplicarKirsch(9));  
//        JFrameImagen frame4 = new JFrameImagen(k.aplicarMascaras(1, 3));  
    }
}
