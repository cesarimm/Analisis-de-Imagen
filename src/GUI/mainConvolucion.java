/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Muestreo.Convolucion;
import io.ImageManager;
import java.awt.Image;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class mainConvolucion {
    public static void main(String args[]){
//          Image imagen = ImageManager.openImage();
//        JFrameImagen frame1 = new JFrameImagen(imagen);
        double kernel [][] = new double[][]{{1,1,1},{1,1,1},{1,1,1}};
        double kernel2 [][] = new double[][]{{1,1,1,1,1},{1,4,4,4,1},{1,4,12,4,1},{1,4,4,4,1},{1,1,1,1,1}};
      //  Image convo = Convolucion.convolucionar(imagen, kernel2, 1);
        
       // JFrameImagen frame2 = new JFrameImagen(convo);
        
       
        System.out.println((kernel2.length - 1)/2);
    }
}
