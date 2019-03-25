/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisimagen;

import GUI.JFrameImagen;
import Muestreo.Convolucion;
import io.ImageManager;
import java.awt.Image;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class MainConvolucion {
    
       public static void main(String[] args) {
        Image imagen = ImageManager.openImage();
        JFrameImagen frame1 = new JFrameImagen(imagen);
        double kernel [][] = new double[][]{{-2,-1,0},{-1,1,1},{0,1,2}};
        double[][] prewittGx = {{0.0, -1.0, 0.0}, {0.0, 1.0, 0.0}, {0.0, 0.0, 0.0}};
       // double kernel [][] = new double[][]{{0,1,0},{1,-4,1},{0,1,0}};
       //double kernel2 [][] = new double[][]{{1,1,1,1,1},{1,4,4,4,1},{1,4,12,4,1},{1,4,4,4,1},{1,1,1,1,1}};
        Convolucion convo = new Convolucion(imagen);
        Image nueva = convo.aplicar(prewittGx, 1);  
        JFrameImagen frame2 = new JFrameImagen(nueva);          
    }   
}
