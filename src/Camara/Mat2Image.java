/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Camara;

import Muestreo.Negativo;
import java.awt.image.BufferedImage;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgproc.Imgproc;
import Muestreo.Umbralizacion;
import java.awt.Color;

public class Mat2Image {
    Mat mat = new Mat();
    BufferedImage img;
    byte[] dat;
    
    public Mat2Image() {
    }
    
    public Mat2Image(Mat mat) {
        getSpace(mat);
    }
    public void getSpace(Mat mat) {
        this.mat = mat;
        int w = mat.cols(), h = mat.rows();
        if (dat == null || dat.length != w * h * 3)
            dat = new byte[w * h * 3];
        if (img == null || img.getWidth() != w || img.getHeight() != h
            || img.getType() != BufferedImage.TYPE_3BYTE_BGR)
                img = new BufferedImage(w, h, 
                            BufferedImage.TYPE_3BYTE_BGR);
        //TYPE_3BYTE_BGR
        }
        BufferedImage getImage(Mat mat){
            getSpace(mat);
            mat.get(0, 0, dat);
            img.getRaster().setDataElements(0, 0, 
                               mat.cols(), mat.rows(), dat);
            
//            img = io.ImageManager.toBufferedImage(Negativo.generarImagenEnNegativo(img));
//            img = MassCenter(img);
            
//           img = io.ImageManager.toBufferedImage(Umbralizacion.Umbralizacion(120, img));
//           img = MassCenter(img);
//            
        return img;
    }
    static{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    
    public BufferedImage MassCenter(BufferedImage bi){
        int Divisor=0,promedioX=0,promedioY=0;
        Color muestra;
        for (int i = 0; i < bi.getWidth(); i++) {
            for (int j = 0; j < bi.getHeight(); j++) {
                muestra = new Color(bi.getRGB(i, j));
                if(muestra.getRed()==0){
                    promedioX+=i;
                    promedioY+=j;
                    Divisor++;
                }
                
                
            }
        }
        if(Divisor!=0){
            promedioX/=Divisor;
            promedioY/=Divisor;
            for (int i = promedioX-3; i < promedioX+3; i++) {
                for (int j = promedioY-3; j < promedioY+3; j++){
                    bi.setRGB(i, j, Color.RED.getRGB());
                }
            }
            
        }
        
        return bi;
    }
}