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
public class questao5 {
    
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
        int[][] img = ImagemDigital.carregarImagem("./ruido/lena1.png");
        ImagemDigital.plotarImagem(img, "Before");
        
        int n =  100;
        for(int k = 1; k <= n; k++){
            int[][] img2 = ImagemDigital.carregarImagem("./ruido/lena" + k + ".png");
            for(int i = 0; i < img.length; i++){
                for(int j = 0; j < img[0].length; j++){
                    img[i][j] = img[i][j] + img2[i][j];
                }
            }
        }

        correcao(img);
        ImagemDigital.plotarImagem(img, "After");
    }
}
