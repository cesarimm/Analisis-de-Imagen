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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class MainMascaras {
    public static void main(String args[]) throws IOException{
        //arregloKirch,diferenciaPixeles,diferenciaPixelesSeparados,prewitt,Sobel,roberts,laplace1
        //Kirch es 0 div 9
        //Diferencia de pixeles 1
        //Pixeles Separados 2
        //Prewitt 3 
        //Sobel 4
        //Roberts 5
        //Laplace 6
         File outputfile;
         BufferedImage bi;
         
         Image imagen = ImageManager.openImage();
         JFrameImagen frame1 = new JFrameImagen(imagen);
         Mascaras k = new Mascaras(imagen);
         
         
         
//         String f = "3img.png";
//         String name = "kirch"+f;
        
//         bi = ImageManager.toBufferedImage(k.aplicarMascaras(9, 0));
//         outputfile = new File("../resultados3/"+"4Kirch.png");
//         ImageIO.write(bi, "png", outputfile);
//         
//          for(int i=1;i<7;i++){
//              bi = ImageManager.toBufferedImage(k.aplicarMascaras(1, i));
//              outputfile = new File("../resultados3/"+"4"+i+".png");
//              ImageIO.write(bi, "png", outputfile);
//          }
          
       JFrameImagen frame2 = new JFrameImagen(k.aplicarMascaras(9, 0));  
       JFrameImagen frame3 = new JFrameImagen(k.aplicarMascaras(1, 5));  
       JFrameImagen frame4 = new JFrameImagen(k.aplicarMascaras(1, 4));  
    }
}
