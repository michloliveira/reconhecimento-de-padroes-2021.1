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
public class Questao1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] img = ImagemDigital.carregarImagem("./imagens/lena_gray_512.png");
        int[][] img2 = ImagemDigital.carregarImagem("./imagens/mandril_gray.png");
        
        int[][] newImg1 =  new int[512][512];
        int[][] newImg2 =  new int[512][512];
        int[][] newImg3 =  new int[512][512];
        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                newImg1[i][j] = (int) (0.25*(img[i][j]) + (1 - 0.25)*(img2[i][j]));
                newImg2[i][j] = (int) (0.50*(img[i][j]) + (1 - 0.50)*(img2[i][j]));
                newImg3[i][j] = (int) (0.75*(img[i][j]) + (1 - 0.75)*(img2[i][j]));
            }
        }
        ImagemDigital.plotarImagem(newImg1, "α: 0,25");
        ImagemDigital.plotarImagem(newImg2, "α: 0,50");
        ImagemDigital.plotarImagem(newImg3, "α: 0,75");
    }
    
}
