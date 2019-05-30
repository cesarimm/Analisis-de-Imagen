
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisimagen;

import GUI.JFrameImagen;
import frecuencias.FFTCalculo;
import frecuencias.FiltroExponencialPasaBajas;
import frecuencias.FiltroIdealPasaBajas;
import frecuencias.FiltroButterworthPasaBajas;
import frecuencias.FiltroIdealPasaAltas;
import frecuencias.Gestor;
import frecuencias.NumeroComplejo;
import io.ImageManager;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class Transformada {
    public static void main(String args[]){
         Image imagen = ImageManager.openImage();
         BufferedImage bi = ImageManager.toBufferedImage(imagen);  
         Gestor gestor = new Gestor(bi);
         
         BufferedImage imgFre = gestor.obtenerImagenFrecuencias(true);
         JFrameImagen frame2 = new JFrameImagen(ImageManager.toImage(imgFre));
         
         ///Crear el filtro
         //FiltroIdealPasaBajas filtro = new FiltroIdealPasaBajas(512, 512, 35);
         FiltroIdealPasaAltas filtro = new FiltroIdealPasaAltas(512, 512, 40);
        // FiltroButterworthPasaBajas filtro =new FiltroButterworthPasaBajas(512, 512, 45, 4.70);
         //FiltroExponencialPasaBajas filtro =new FiltroExponencialPasaBajas(512, 512, 40, 3.55);
         filtro.generar();
         NumeroComplejo[][] matFiltro= filtro.getMatriz();
    
         gestor.aplicarFiltro(matFiltro);
         BufferedImage imagenEspacial = gestor.obtenerImagenEspacial();
         JFrameImagen frame3 = new JFrameImagen(ImageManager.toImage(imagenEspacial));
    }
}
