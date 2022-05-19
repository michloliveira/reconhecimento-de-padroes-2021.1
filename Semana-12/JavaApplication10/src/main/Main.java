/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import imagemDigital.ImagemDigital;

/**
 *
 * @author michel
 */
public class Main {

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
       int[][] img = ImagemDigital.carregarImagem("./LUA.png");
       int[][] img1 = new int[img.length][img[0].length];
       int[][] img2 = new int[img.length][img[0].length];
      
       int[][] mask1 = {{0,-1, 0}, 
                       {-1, 4, -1}, 
                       {0, -1, 0}};
       
       int[][] mask2 = {{-1,-1, -1},
                        {-1, 8, -1}, 
                        {-1, -1, -1}};
       
       
       ImagemDigital.plotarImagem(img, "Lua");
       
       for(int i = 1; i < (img.length - 1); i++){
           for(int j = 1; j < (img[0].length - 1); j++){
                int sum1 = 0;
                int sum2 = 0;
                for(int x = -1; x < 2; x++){
                    for(int y = -1; y < 2; y++){
                        sum1 += img[i + x][j + y] * mask1[x + 1][y + 1];
                        sum2 += img[i + x][j + y] * mask2[x + 1][y + 1];
                    }
                }
            img1[i][j] = img[i][j] + sum1;
            img2[i][j] = img[i][j] + sum2;
           }    
       }
       
        correcao(img1);
        ImagemDigital.plotarImagem(img1, "Mascara 1");
        correcao(img2);
        ImagemDigital.plotarImagem(img2, "Mascara 2");
    }
    
}
