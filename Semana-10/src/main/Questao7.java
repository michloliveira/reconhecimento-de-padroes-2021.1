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
public class Questao7 {
    public static void main(String[] args) {
        int[][] img = ImagemDigital.carregarImagem("./imagens/Fig0312(a)(kidney).png");
        int[][] img2 = new int[img.length][img[0].length];
        
        ImagemDigital.plotarImagem(img, "Imagem Original");
        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                
                if(img[i][j] >= 100 && img[i][j] <= 150){
                    img2[i][j] = 153;
                }
                else{
                     img2[i][j] = 25;
                }
            }
        }
        ImagemDigital.plotarImagem(img2, "img2");
        
    }
}
