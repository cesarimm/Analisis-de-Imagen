
package Muestreo;

import io.ImageManager;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author CESAR IVAN MTZ
 */
 
public class HistogramaFrecuencias {
    
    private Image imagenOriginal;
    private int histogramaR[];
    private int histogramaG[];
    private int histogramaB[];

    public HistogramaFrecuencias(Image imagenOriginal) {
        this.imagenOriginal = imagenOriginal;
        this.histogramaR = new int[256];
        this.histogramaG = new int[256];
        this.histogramaB = new int[256];
         // calcular los histogramas por cada uno de los colores
        calcularHistogramas();
    }
    public void graficarHistogramasRGB(){
    // graficar los Histogramas
    muestreo.Grafica grafica = new muestreo.Grafica("Histogramas RGB","Color","Frecuencias");
    grafica.agregarSerie("Rojo",this.histogramaR);
    grafica.agregarSerie("Azul",this.histogramaB);
    grafica.agregarSerie("Verde",this.histogramaG);
    grafica.crearGrafica();
    
    }

    private void calcularHistogramas() {
        // recorrido de la imagen y contamos las frecuencias de color
        BufferedImage bi = ImageManager.toBufferedImage(this.imagenOriginal);
        // recorrer el BufferedImage 
        for (int x=0; x < bi.getWidth();x++)
            for(int y=0; y < bi.getHeight();y++){
                Color pixel = new Color(bi.getRGB(x, y));
                this.histogramaR[pixel.getRed()]++;
                this.histogramaG[pixel.getGreen()]++;
                this.histogramaB[pixel.getBlue()]++;
            }
    }

    public int[] getHistogramaR() {
        return histogramaR;
    }

    public int[] getHistogramaG() {
        return histogramaG;
    }

    public int[] getHistogramaB() {
        return histogramaB;
    }
    
}

