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
public class Questao2 {
    
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
        int[][] img = ImagemDigital.carregarImagem("./imagens/Fig0228(a)(angiography_mask_image).png");
        int[][] img2 = new int[img.length][img[0].length];
        
        int[][] firstMinusSecond = new int[420][420];
        int[][] secundMinusFirst = new int[420][420];
        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                firstMinusSecond[i][j] = img[i][j] - img2[i][j];
                secundMinusFirst[i][j] = img2[i][j] - img[i][j];
            }
        }
        
        correcao(firstMinusSecond);
        correcao(secundMinusFirst);
        
        ImagemDigital.plotarImagem(firstMinusSecond, "Primeira - Segunda");
        ImagemDigital.plotarImagem(secundMinusFirst, "Segunda - Primeira");
        
    }
}
