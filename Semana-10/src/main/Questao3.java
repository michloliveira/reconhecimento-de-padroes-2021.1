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
public class Questao3 {
   /* static float getBase(float gama){
        float x = Math.pow(10,(Math.log(P)/ Math.pow(P, gama)));
    }*/
    public static void main(String[] args) {
        int[][] img = ImagemDigital.carregarImagem("./imagens/Fig0308(a)(fractured_spine).png");
        int[][] img1 = new int[img.length][img[0].length];
        int[][] img2 = new int[img.length][img[0].length];
        int[][] img3 = new int[img.length][img[0].length];
        
        ImagemDigital.plotarImagem(img, "Imagem Original");
        
        double gama1 = 0.6;
        double gama2 = 0.5;
        double gama3 = 0.4;
        double C;
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                
                C =  Math.pow(Math.E,(Math.log(img1[i][j])/ (Math.pow(img1[i][j], gama1))));
                Math.lo
                System.out.println(C);
                
                //C = (255 - 1) / Math.log(255);
                
                img1[i][j] = (int)(C * Math.log(1 + img1[i][j]));

            } 
        }

        ImagemDigital.plotarImagem(img1, "γ = 0.6");

    }
    
}
