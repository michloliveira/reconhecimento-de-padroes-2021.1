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
public class questao3 {
    static void correcao(int[][] img){
        int max = 0;
        int min = 255;
        
        //calcular máximo e minino
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                max = Math.max(max, img[i][j]);
                min = Math.min(min, img[i][j]);
            }
        }
        //fazendo correcao
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                img[i][j] = (255 * (img[i][j] - min)) / (max - min);    
            }
        }
    }
    
    
    
    public static void main(String[] args) {
        int[][] img = ImagemDigital.carregarImagem("./imagens/Fig0229(a)(tungsten_filament_shaded).png");
        int[][] img2 = ImagemDigital.carregarImagem("./imagens/Fig0229(b)(tungsten_sensor_shading).png");
        
        int[][] imgFinal = new int[754][892];
        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                double aux = 255 * img[i][j];
                aux = aux / img2[i][j];
                imgFinal[i][j] = (int) aux;
            }
        }
        
        //ImagemDigital.plotarImagem(imgFinal, "Antess");
        correcao(imgFinal);
        
        ImagemDigital.plotarImagem(img, "Antes");
        ImagemDigital.plotarImagem(imgFinal, "Rersultado Final");
        
    }
}
