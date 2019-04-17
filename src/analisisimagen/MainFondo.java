/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisimagen;

import GUI.JFrameImagen;
import Muestreo.FondoControlado;
import io.ImageManager;
import java.awt.Image;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class MainFondo {
    public static void main(String args[]){     
        Image imagenFondo = ImageManager.openImage();
        Image imagenObjeto = ImageManager.openImage();
        
        Image nueva = FondoControlado.expansionLineal(imagenFondo, imagenObjeto);
        JFrameImagen frame2 = new JFrameImagen(nueva);    
    }
}
