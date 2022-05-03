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
public class Questao4 {
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
        int[][] img = ImagemDigital.carregarImagem("./imagens/Fig0309(a)(washed_out_aerial_image).png");
        int[][] img1 = new int[img.length][img[0].length];
        int[][] img2 = new int[img.length][img[0].length];
        int[][] img3 = new int[img.length][img[0].length];
        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                img1[i][j] = (int)(Math.pow(254, 1 - 3.0) * (Math.pow(img[i][j], 3.0)));
                img2[i][j] = (int)(Math.pow(254, 1 - 4.0) * (Math.pow(img[i][j], 4.0)));
                img3[i][j] = (int)(Math.pow(254, 1 - 5.0) * (Math.pow(img[i][j], 5.0)));
            } 
        }
        
        correcao(img1);
        correcao(img2);
        correcao(img3);
        
        ImagemDigital.plotarImagem(img, "Imagem Original");
        ImagemDigital.plotarImagem(img1, "y = 3");
        ImagemDigital.plotarImagem(img2, "y = 4");
        ImagemDigital.plotarImagem(img3, "y = 5");
        
    }
    
}
