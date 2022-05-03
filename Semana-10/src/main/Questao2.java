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
    public static void main(String[] args) {
        int[][] img = ImagemDigital.carregarImagem("./imagens/Fig0308(a)(fractured_spine).png");
        int[][] img1 = new int[img.length][img[0].length];
        int[][] img2 = new int[img.length][img[0].length];
        int[][] img3 = new int[img.length][img[0].length];
        
        ImagemDigital.plotarImagem(img, "Imagem Original");
        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                img1[i][j] = (int)(Math.pow(254, 1 - 0.6) * (Math.pow(img[i][j], 0.6)));
                img2[i][j] = (int)(Math.pow(254, 1 - 0.5) * (Math.pow(img[i][j], 0.5)));
                img3[i][j] = (int)(Math.pow(254, 1 - 0.4) * (Math.pow(img[i][j], 0.4)));
            } 
        }

        ImagemDigital.plotarImagem(img1, "γ = 0.6");
        ImagemDigital.plotarImagem(img2, "γ = 0.5");
        ImagemDigital.plotarImagem(img3, "γ = 0.4");
    
    }
    
}
