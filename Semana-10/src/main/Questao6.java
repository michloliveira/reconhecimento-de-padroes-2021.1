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
public class Questao6 {
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
        int[][] img = ImagemDigital.carregarImagem("./imagens/Fig0310(b)(washed_out_pollen_image).png");
        int[][] img2 = new int[img.length][img[0].length];
        
        ImagemDigital.plotarImagem(img, "Imagem Original");
        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                if(img[i][j] < 64){
                    img2[i][j] = (int) (0.5 * img[i][j]);
                }
                else if(img[i][j] >= 64 && img[i][j] <= 192){
                    img2[i][j] = (int) ((1.5 * img[i][j]) - 65);
                }
                else{
                    img2[i][j] = (int) ((0.5 * img[i][j]) + 128);
                }
            }
        }
        correcao(img2);
        ImagemDigital.plotarImagem(img2, "Img2");
    }
    
}
