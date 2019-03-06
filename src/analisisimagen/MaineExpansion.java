/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisimagen;

import GUI.JFrameImagen;
import Muestreo.EscalaGrises;
import Muestreo.Expansion;
import Muestreo.HistogramaFrecuencias;
import io.ImageManager;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author CESAR IVAN MTZ
 */
public class MaineExpansion {
       public static void main(String[] args) throws IOException {
           File outputfile;
           BufferedImage bi;
           String name = "";
           int i=3;
           Image imagen = ImageManager.openImage();
           // JFrameImagen frame1 = new JFrameImagen(imagen);
           Image grises = EscalaGrises.generarImagenEnGrises(imagen);
           JFrameImagen frame2 = new JFrameImagen(grises);
           HistogramaFrecuencias histo = new HistogramaFrecuencias(grises);
           histo.graficarHistogramasRGB();
           
                name=i+"original.png";
                outputfile = new File("../resultados/"+name);
                bi = ImageManager.toBufferedImage(grises);
                ImageIO.write(bi, "png", outputfile);
Image lineal =  Expansion.expansionLineal(60, 200, grises);
                name=i+"lineal.png";
                outputfile = new File("../resultados/"+name);
                bi = ImageManager.toBufferedImage(lineal);
                ImageIO.write(bi, "png", outputfile);
Image logaritmica = Expansion.expansionLogaritmica(78,grises);
                name=i+"logaritmica.png";
                outputfile = new File("../resultados/"+name);
                bi = ImageManager.toBufferedImage(logaritmica);
                ImageIO.write(bi, "png", outputfile);
Image exponencial = Expansion.expansionExponencial(.79,grises);
                name=i+"exponencial.png";
                outputfile = new File("../resultados/"+name);
                bi = ImageManager.toBufferedImage(exponencial);
                ImageIO.write(bi, "png", outputfile);
Image mine = Expansion.expansionMine(1.67,grises);
                name=i+"mine.png";
                outputfile = new File("../resultados/"+name);
                bi = ImageManager.toBufferedImage(mine);
                ImageIO.write(bi, "png", outputfile);
 //JFrameImagen frame3 = new JFrameImagen(contraste);

HistogramaFrecuencias histo2 = new HistogramaFrecuencias(lineal);
histo2.graficarHistogramasRGB();
HistogramaFrecuencias histo3 = new HistogramaFrecuencias(logaritmica);
histo3.graficarHistogramasRGB();
HistogramaFrecuencias histo4 = new HistogramaFrecuencias(exponencial);
histo4.graficarHistogramasRGB();
HistogramaFrecuencias histo5 = new HistogramaFrecuencias(mine);
histo5.graficarHistogramasRGB();
System.out.println();
            
    }
}
