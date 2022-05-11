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
        int[][] img = ImagemDigital.carregarImagem("./imagens/Fig1038(a)(noisy_fingerprint).png");
        int[][] out = new int[img.length][img[0].length];
        
        int T = 180;
        int newT = 0;
        int delta = 30;
        
        while(true){
            System.out.println(T);
            System.out.println(newT);
            int div1 = 0;
            int div2 = 0;
            int media1 = 0;
            int media2 = 0;

            for(int i = 0; i < img.length; i++){
                for(int j = 0; j < img[0].length; j++){
                    if(img[i][j] < T){
                        media1 += img[i][j];
                        div1 += 1;
                    }
                    else{
                        media2 += img[i][j];
                        div2 += 1;
                    }
                }
            }
            
            media1 = media1 / div1;
            
            media2 = media2 / div2;
            System.out.println("media1 "+ media1);
            System.out.println("media2 "+ media2);

            newT = (media1 + media2)/2;
            System.out.println(newT);
            
            if((T - newT) < delta){
                T = newT;
                break;
            }
            else{
                T = newT;
            }
        }
        System.out.println(T);
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                if(img[i][j] > T){
                    out[i][j] = 255;
                }
                else{
                    out[i][j] = 0;
                }
            }
        }
        ImagemDigital.plotarImagem(img, "Original");
        ImagemDigital.plotarImagem(out, "saida");
        
    }
}
