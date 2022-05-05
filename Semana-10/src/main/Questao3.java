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
    public static void main(String[] args) {
        int[][] img = ImagemDigital.carregarImagem("./imagens/Fig0308(a)(fractured_spine).png");
        int[][] img1 = new int[img.length][img[0].length];
        int[][] img2 = new int[img.length][img[0].length];
        int[][] img3 = new int[img.length][img[0].length];
        
        ImagemDigital.plotarImagem(img, "Imagem Original");
        
        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                
                img1[i][j] = (int) ((double)((0.6*254) / Math.log(1+img[i][j]))); //s = c log(1+r)

            } 
        }

        ImagemDigital.plotarImagem(img1, "γ = 0.6");

    }
    
}
