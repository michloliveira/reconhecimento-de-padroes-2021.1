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
        
        
        ImagemDigital.plotarImagem(img, "teste");
        
        //QUESTÃO 2-------------------------------------------------------------
    }
    
}
