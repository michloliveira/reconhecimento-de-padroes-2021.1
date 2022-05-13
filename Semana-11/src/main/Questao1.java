/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import imagemDigital.ImagemDigital;

/**
 *
 * @author michel
 */
public class Questao1 {
    
    static int[] calcularHistograma(int[][] img ,int[] histograma){
        //calcular histograma
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                histograma[img[i][j]] += 1;
            }
        }
        return histograma;
    }
    
    static int[] calcularHistogramaAcumulado(int[] histograma, int[] histAcumulado){
        histAcumulado[0] = histograma[0];
        for(int i = 1; i < 256; i++){
            histAcumulado[i] = histograma[i] + histAcumulado[i-1];
        }
        return histAcumulado;
    }
    static float menor(int[] histograma){
        for(int i = 0; i < histograma.length; i++){
            if(histograma[i] != 0){
                return histograma[i];
            }
        }
        return 0;
    }
    
    static int[] calcularMapaCores(int[] mapaCores, int[] histAcumulado, int[][] img){
        //calcular mapa de cores
        int pixels = img.length * img[0].length;
        float menor = menor(histAcumulado);
        
        for(int i = 0; i < 256; i++){
            mapaCores[i] = (int) Math.round(((histAcumulado[i] - menor) / (pixels - menor)) * 255);
        }
        return histAcumulado;
    }
    
    static int[][] atualizarCores(int[] mapaCores, int[][] img, int[][] out){
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                out[i][j] = mapaCores[img[i][j]];
            }
        }
        return out;
    }
    
    public static void main(String[] args) {
        
        for(int i = 0; i< 7; i++){
            //int i = 6;
            int[][] img = ImagemDigital.carregarImagem("./imagens/"+ i + ".png");
            int[][] out = new int[img.length][img[0].length];


            int histograma[] = new int[256];
            int histAcumulado[] = new int[256];
            int mapaCores[] = new int[256];

            calcularHistograma(img, histograma);
            calcularHistogramaAcumulado(histograma, histAcumulado);
            calcularMapaCores(mapaCores, histAcumulado, img);
            atualizarCores(mapaCores, img, out);
            ImagemDigital.plotarImagem(img, "original " + i);
            ImagemDigital.plotarImagem(out, "saida " + i);
            new Histograma(histograma,"Antes " + i);
            new Histograma(mapaCores,"Depois " + i);
              
        }
        

   
        
    }
    
    
}
