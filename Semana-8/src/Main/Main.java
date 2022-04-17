/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import imagemDigital.ImagemDigital;

/**
 *
 * @author michel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //QUESTAO -1 -----------------------------------------------------------
    
        int[][] img = ImagemDigital.carregarImagem("Fig0207(a)(gray-level-band).png");
        
        //ImagemDigital.plotarImagem(img, "Tela");
        
        int[][] img2 = new int[7200][2400]; //Array para armazenar img
        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img.length; j++){
                if(j > 240 && j < 360){
                    img2[i][j] = img[i][j];
                   // System.out.print(img2[i][j] + ",");
                }
            }
            //System.out.print("\n");
        }
        
        
        //ImagemDigital.plotarImagem(img, "teste");
        
        //QUESTÃO 2-------------------------------------------------------------
        
        int[][] square1 = new int[300][300];
        int[][] square2 = new int[300][300];
        int[][] square3 = new int[300][300];
        
        //square1
        for(int i = 0; i < square1.length; i++){
            for(int j = 0; j < square1.length; j++){
                if(j >= 100 && j <= 200 && i >= 100 && i <= 200){
                    square1[i][j] = 128;
                }
                else{
                    square1[i][j] = 0;
                }
            }
        }
        //square2
        for(int i = 0; i < square2.length; i++){
            for(int j = 0; j < square2.length; j++){
                if(j >= 100 && j <= 200 && i >= 100 && i <= 200){
                    square2[i][j] = 128;
                }
                else{
                    square2[i][j] = 64;
                }
            }
        }
        //square3
        for(int i = 0; i < square3.length; i++){
            for(int j = 0; j < square3.length; j++){
                if(j >= 100 && j <= 200 && i >= 100 && i <= 200){
                    square3[i][j] = 128;
                }
                else{
                    square3[i][j] = 192;
                }
            }
        }
                
        ImagemDigital.plotarImagem(square1, "Square1");
        ImagemDigital.plotarImagem(square2, "Square2");
        ImagemDigital.plotarImagem(square3, "Square3");
        
        //QUESTÃO 3-------------------------------------------------------------
    }
    
}
