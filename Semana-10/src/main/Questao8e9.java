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
public class Questao8e9 {
       static void correcao(int[][] img){
        int max = 0;
        int min = 255;
        
        //calcular máximo e minino
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                max = Math.max(max, img[i][j]);
                min = Math.min(min, img[i][j]);
            }
        }
        //fazendo correcao
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                img[i][j] = (255 * (img[i][j] - min)) / (max - min);    
            }
        }
        
    }
    static String convertToBinary(int valor){
        String binary = Integer.toBinaryString(valor);
        String formatted = String.format("%8s", binary);
        String output = formatted.replaceAll(" ", "0");
        
        return output;
    }
    
    public static void main(String[] args) {
        int[][] img = ImagemDigital.carregarImagem("./imagens/Fig0314(a)(100-dollars).png");
        int[][] plano1 = new int[img.length][img[0].length];
        int[][] plano2 = new int[img.length][img[0].length];
        int[][] plano3 = new int[img.length][img[0].length];
        int[][] plano4 = new int[img.length][img[0].length];
        int[][] plano5 = new int[img.length][img[0].length];
        int[][] plano6 = new int[img.length][img[0].length];
        int[][] plano7 = new int[img.length][img[0].length];
        int[][] plano8 = new int[img.length][img[0].length];
        
        ImagemDigital.plotarImagem(img, "teste");
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                String bin = convertToBinary(img[i][j]);
                //System.out.println(bin.charAt(0));
                        
                plano1[i][j] = (int)(Math.pow(2,0) *  Character.getNumericValue(bin.charAt(0)));
                plano2[i][j] = (int)(Math.pow(2,1) *  Character.getNumericValue(bin.charAt(1)));
                plano3[i][j] = (int)(Math.pow(2,2) *  Character.getNumericValue(bin.charAt(2)));
                plano4[i][j] = (int)(Math.pow(2,3) *  Character.getNumericValue(bin.charAt(3)));
                plano5[i][j] = (int)(Math.pow(2,4) *  Character.getNumericValue(bin.charAt(4)));
                plano6[i][j] = (int)(Math.pow(2,5) *  Character.getNumericValue(bin.charAt(5)));
                plano7[i][j] = (int)(Math.pow(2,6) *  Character.getNumericValue(bin.charAt(6)));
                plano8[i][j] = (int)(Math.pow(2,7) *  Character.getNumericValue(bin.charAt(7)));

            }
        }
        correcao(plano1);
        correcao(plano2);
        correcao(plano3);
        correcao(plano4);
        correcao(plano5);
        correcao(plano6);
        correcao(plano7);
        correcao(plano8);
        
        ImagemDigital.plotarImagem(plano1,"1");
        ImagemDigital.plotarImagem(plano2,"2");
        ImagemDigital.plotarImagem(plano3,"3");
        ImagemDigital.plotarImagem(plano4,"4");
        ImagemDigital.plotarImagem(plano5,"5");
        ImagemDigital.plotarImagem(plano6,"6");
        ImagemDigital.plotarImagem(plano7,"7");
        ImagemDigital.plotarImagem(plano8,"8");
        
        
        
        int[][] imgCombined = new int[img.length][img[0].length];
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                String bin = convertToBinary(img[i][j]);
                imgCombined[i][j] = (128 * plano1[i][j]) + (64 * plano2[i][j]);
                
            }
        }
        correcao(imgCombined);
        ImagemDigital.plotarImagem(imgCombined,"Combinado");
        
    }

    
}
