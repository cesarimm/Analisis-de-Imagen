/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frecuencias;

import frecuencias.HerramientasColor.CanalColor;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import Muestreo.Convolucion;
import Muestreo.Expansion;
import java.awt.Color;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Gestor {
    // imagen original
    private BufferedImage imagenOriginal;
    public Map<HerramientasColor.CanalColor, NumeroComplejo[][]> representacionEspacial;
    Map<HerramientasColor.CanalColor, NumeroComplejo[][]> representacionFrecuencias;

    public Gestor(BufferedImage imagenOriginal) {
        this.imagenOriginal = imagenOriginal;
        this.representacionEspacial = new HashMap<HerramientasColor.CanalColor, NumeroComplejo[][]>();
        this.representacionFrecuencias = new HashMap<HerramientasColor.CanalColor, NumeroComplejo[][]>();
        // obtener la informacion de los pixeles y crear los mapeos correspondientes
        for(HerramientasColor.CanalColor color: HerramientasColor.CanalColor.values()){
        
            this.representacionEspacial.put(color,obtenerDatosPorCanal(color,this.imagenOriginal));
        
        }
    }

    private NumeroComplejo[][] obtenerDatosPorCanal(HerramientasColor.CanalColor color, BufferedImage imagenOriginal) {
       NumeroComplejo[][] aux = new NumeroComplejo[this.imagenOriginal.getWidth()][this.imagenOriginal.getHeight()];
       //  recorremos en un ciclo el buffered para crear los diferentes numeros complejos
       for(int x=0;x<this.imagenOriginal.getWidth();x++){
           for(int y=0;y<this.imagenOriginal.getHeight();y++){
               aux[x][y] = new NumeroComplejo(HerramientasColor.obtenerValorPorCanal(imagenOriginal.getRGB(x, y), color),0);
           }
       }
       return aux;
    }
    
    //Agregando los otros metodos
    
     public void aplicarFiltro(NumeroComplejo[][] filtro) {

        // recorrer el filtro 
        for (int x = 0; x < this.imagenOriginal.getWidth(); x++) {
            for (int y = 0; y < this.imagenOriginal.getHeight();y++) {
                // obtener el color el RGB de la parte de frecuencias
                if (filtro[x][y].getReal()<1){
                int rgb = obtenerPixelDominioFrecuencias(x,y,true);
                Color aux = new Color(rgb);
                int r = (int) (aux.getRed() * filtro[x][y].getReal());
                int g = (int) (aux.getGreen()* filtro[x][y].getReal());
                int b = (int) (aux.getBlue() * filtro[x][y].getReal());
                aux = new Color(r, g, b);
                setPixelDominioFrecuencias(x,y,true,aux.getRGB());}
            }
        }

    }
        
    
public BufferedImage obtenerImagenFrecuencias(boolean reAjustarCuadrante) {
        /// obtenemos las dimensiones
        int anchoImagen = this.imagenOriginal.getWidth();
        int altoImagen = this.imagenOriginal.getHeight();
        BufferedImage aux = new BufferedImage(anchoImagen, altoImagen, BufferedImage.TYPE_INT_ARGB);

        FFTCalculo fft = new FFTCalculo();
        // construir el mapeo de representacion en frecuencias utilizando FFT

        for (CanalColor canal : HerramientasColor.CanalColor.values()) {
            NumeroComplejo[][] datos = this.representacionEspacial.get(canal);
            NumeroComplejo[][] transformada = fft.calculateFT(datos, false);
            representacionFrecuencias.put(canal, transformada);
            // crear la imagen del espectro 
            for (int y = 0; y < aux.getHeight(); y++) {
                for (int x = 0; x < aux.getWidth(); x++) {
                    // modificamos la posicion de los cuadrantes 
                    int ejeX = reAjustarCuadrante ? (x + (anchoImagen / 2)) % anchoImagen : x;
                    int ejeY = reAjustarCuadrante ? (y + (altoImagen / 2)) % altoImagen : y;
                    // setear la info a la imagen 
                    // el que se ecuentre en la imagen 
                    int color1 = aux.getRGB(x, y);
                    int color2 = obtenerColorRealDeFrecuencia(ejeX, ejeY, transformada, canal);
                    int rgb = HerramientasColor.acumularColor(color1, color2);
                    aux.setRGB(x, y, rgb);

                }
            }
        }
        return aux;
    }

  private int obtenerColorRealDeFrecuencia(int ejeX, int ejeY, NumeroComplejo[][] transformada, CanalColor canal) {
        int color = (int) Math.abs(transformada[ejeX][ejeY].getReal());
        color = (int)Expansion.validarRango(color);
        color = HerramientasColor.obtenerRGBporCanal(color, canal);
        return color;
    }
  
  
  //El otro método
   public BufferedImage obtenerImagenEspacial() {
        /// obtenemos las dimensiones
        int anchoImagen = this.imagenOriginal.getWidth();
        int altoImagen = this.imagenOriginal.getHeight();
        BufferedImage aux = new BufferedImage(anchoImagen, altoImagen, BufferedImage.TYPE_INT_ARGB);

        FFTCalculo fft = new FFTCalculo();
        // construir el mapeo de representacion en frecuencias utilizando FFT

        for (CanalColor canal : HerramientasColor.CanalColor.values()) {
            NumeroComplejo[][] datos = this.representacionFrecuencias.get(canal);
            NumeroComplejo[][] transformadaInv = fft.calculateFT(datos, true);
            representacionEspacial.put(canal, transformadaInv);
            // crear la imagen del espectro 
            for (int y = 0; y < aux.getHeight(); y++) {
                for (int x = 0; x < aux.getWidth(); x++) {

                    int color = (int) Math.abs(transformadaInv[x][y].getReal());
                    color = (int)Expansion.validarRango(color);
                    color = HerramientasColor.obtenerRGBporCanal(color, canal);

                    int rgb = HerramientasColor.acumularColor(aux.getRGB(x, y), color);
                    aux.setRGB(x, y, rgb);
                }
            }
        }
        return aux;

    }
   
   
    
   
    private int obtenerPixelDominioFrecuencias(int x, int y, boolean encuadre) {
        /// obtenemos las dimensiones
        int anchoImagen = this.imagenOriginal.getWidth();
        int altoImagen = this.imagenOriginal.getHeight();
        // modificamos la posicion de los cuadrantes 
        int ejeX = encuadre ? (x + (anchoImagen / 2)) % anchoImagen : x;
        int ejeY = encuadre ? (y + (altoImagen / 2)) % altoImagen : y;
        
        // acumulamos 
        int valorColor = 0;
        for (CanalColor canal: CanalColor.values()){
        NumeroComplejo[][] aux = representacionFrecuencias.get(canal);
        valorColor += obtenerColorRealDeFrecuencia(ejeX, ejeY,aux, canal);
        }
        
        return valorColor;
    }

    private void setPixelDominioFrecuencias(int x, int y, boolean encuadre, int color) {
         /// obtenemos las dimensiones
        int anchoImagen = this.imagenOriginal.getWidth();
        int altoImagen = this.imagenOriginal.getHeight();
        // modificamos la posicion de los cuadrantes 
        int ejeX = encuadre ? (x + (anchoImagen / 2)) % anchoImagen : x;
        int ejeY = encuadre ? (y + (altoImagen / 2)) % altoImagen : y;
        
        // recorrer por canal de color 
        for (CanalColor canal: CanalColor.values()){
        NumeroComplejo[][] datos = representacionFrecuencias.get(canal);
        int nuevo =  HerramientasColor.obtenerValorPorCanal(color, canal);
        
        datos[ejeX][ejeY] = new NumeroComplejo(nuevo,nuevo);
        
        }
        
    }
   
//   public void aplicarFiltro(NumeroComplejo[][] matrizFiltro){
//    for (CanalColor canal : HerramientasColor.CanalColor.values()) {
//             
//            for (int y = 0; y < matrizFiltro.length; y++) {
//                for (int x = 0; x < matrizFiltro[0].length; x++) {
//                this.representacionFrecuencias.get(canal)[y][x].producto(matrizFiltro[x][y].getReal());
//                // this.representacionEspacial.get(canal)[y][x]=this.representacionEspacial.get(canal)[y][x].producto(matrizFiltro[x][y].getReal());  
//                }
//            }
//        }   
//   }
    
}
