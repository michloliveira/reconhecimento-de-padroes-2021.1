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
public class Questao5 {
    static void correcao(int[][][] img){
        int maxR = 0;
        int maxG = 0;
        int maxB = 0;
        int minR = 255;
        int minG = 255;
        int minB = 255;
        
        //calcular máximo e minino
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                maxR = Math.max(maxR, img[i][j][0]);
                maxG = Math.max(maxG, img[i][j][1]);
                maxB = Math.max(maxB, img[i][j][2]);
                
                minR = Math.min(minR, img[i][j][0]);
                minG = Math.min(minG, img[i][j][1]);
                minB = Math.min(minB, img[i][j][2]);
            }
        }
        //fazendo correcao
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                img[i][j][0] = (255 * (img[i][j][0] - minR)) / (maxR - minR);    
                img[i][j][1] = (255 * (img[i][j][1] - minG)) / (maxG - minG);    
                img[i][j][2] = (255 * (img[i][j][2] - minB)) / (maxB - minB);    
            }
        }
        
    }
    
    public static void main(String[] args) {
        int[][][] img = ImagemDigital.carregarImagemCor("./imagens/a4d88a27b6e6f33558a8e675b742-1458995.jpg");
        int[][][] img1 = new int[img.length][img[0].length][3];
        int[][][] img2 = new int[img.length][img[0].length][3];
        int[][][] img3 = new int[img.length][img[0].length][3];
        
        ImagemDigital.plotarImagemCor(img, "Imagem Original");
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                //0.7
                img1[i][j][0] = (int)(Math.pow(254, 1 - 0.7) * (Math.pow(img[i][j][0], 0.7)));
                img1[i][j][1] = (int)(Math.pow(254, 1 - 0.7) * (Math.pow(img[i][j][1], 0.7)));
                img1[i][j][2] = (int)(Math.pow(254, 1 - 0.7) * (Math.pow(img[i][j][2], 0.7)));
                //0.5
                img2[i][j][0] = (int)(Math.pow(254, 1 - 0.5) * (Math.pow(img[i][j][0], 0.5)));
                img2[i][j][1] = (int)(Math.pow(254, 1 - 0.5) * (Math.pow(img[i][j][1], 0.5)));
                img2[i][j][2] = (int)(Math.pow(254, 1 - 0.5) * (Math.pow(img[i][j][2], 0.5)));
                //0.3
                img3[i][j][0] = (int)(Math.pow(254, 1 - 0.3) * (Math.pow(img[i][j][0], 0.3)));
                img3[i][j][1] = (int)(Math.pow(254, 1 - 0.3) * (Math.pow(img[i][j][1], 0.3)));
                img3[i][j][2] = (int)(Math.pow(254, 1 - 0.3) * (Math.pow(img[i][j][2], 0.3)));
            }
        }
        
        correcao(img1);
        correcao(img2);
        correcao(img3);
        
        ImagemDigital.plotarImagemCor(img1, "0.7");
        ImagemDigital.plotarImagemCor(img2, "0.5");
        ImagemDigital.plotarImagemCor(img3, "0.3");
            
    }
}
