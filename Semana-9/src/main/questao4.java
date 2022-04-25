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
public class questao4 {
     public static void main(String[] args) {
        int[][] img = ImagemDigital.carregarImagem("./imagens/Fig0230(a)(dental_xray).png");
        int[][] img2 = ImagemDigital.carregarImagem("./imagens/Fig0230(b)(dental_xray_mask).png");
        int[][] img3 = ImagemDigital.carregarImagem("./imagens/Fig0230(b)(dental_xray_mask)custom.png");
        
        int[][] imgFinal = new int[882][674];
        int[][] imgFinalCustom = new int[882][674];
        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                imgFinal[i][j] = (int) Math.sqrt(img[i][j] * img2[i][j]);
                imgFinalCustom[i][j] = (int) Math.sqrt(img[i][j] * img3[i][j]);
            }
        }
        
        
        ImagemDigital.plotarImagem(img, "Antes");
        ImagemDigital.plotarImagem(imgFinal, "Rersultado Final");
        ImagemDigital.plotarImagem(imgFinalCustom, "Mascara Custom");
        
        
    }
    
}
