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
public class Questao10 {
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
    static void correcaoCor(int[][][] img){
        int maxR = 0;
        int maxG = 0;
        int maxB = 0;
        int minR = 255;
        int minG = 255;
        int minB = 255;
        
        //calcular máximo e minino
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                maxR = Math.max(maxR, img[i][j][0]);
                maxG = Math.max(maxG, img[i][j][1]);
                maxB = Math.max(maxB, img[i][j][2]);
                
                minR = Math.min(minR, img[i][j][0]);
                minG = Math.min(minG, img[i][j][1]);
                minB = Math.min(minB, img[i][j][2]);
            }
        }
        //fazendo correcao
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                img[i][j][0] = (255 * (img[i][j][0] - minR)) / (maxR - minR);    
                img[i][j][1] = (255 * (img[i][j][1] - minG)) / (maxG - minG);    
                img[i][j][2] = (255 * (img[i][j][2] - minB)) / (maxB - minB);    
            }
        }
        
    }
    
    public static void main(String[] args) {
        int[][][] floresta = ImagemDigital.carregarImagemCor("./imagens/Floresta.png");
        int[][] celula = ImagemDigital.carregarImagem("./imagens/Celula.png");
        int[][] cerebro = ImagemDigital.carregarImagem("./imagens/Cérebro.png");
        int[][][] gorisRaioni = ImagemDigital.carregarImagemCor("./imagens/GorisRaioni.jpg");
        
        ImagemDigital.plotarImagemCor(floresta, "floresta");
        ImagemDigital.plotarImagem(celula, "celula");
        ImagemDigital.plotarImagem(cerebro, "cerebro");
        ImagemDigital.plotarImagemCor(gorisRaioni, "GorisRaioni");
        
        //floresta------------------------------------------------------------------------------------
        for(int i = 0; i < floresta.length; i++){
            for(int j = 0; j < floresta[0].length; j++){
                floresta[i][j][0] = (int)(Math.pow(254, 1 - 0.5) * (Math.pow(floresta[i][j][0], 0.5)));
                floresta[i][j][1] = (int)(Math.pow(254, 1 - 0.5) * (Math.pow(floresta[i][j][1], 0.5)));
                floresta[i][j][2] = (int)(Math.pow(254, 1 - 0.5) * (Math.pow(floresta[i][j][2], 0.5)));
            } 
        }
 
        correcaoCor(floresta);
        ImagemDigital.plotarImagemCor(floresta, "florestaCorrigida");
        
        //celula --------------------------------------------------------------------------------------------
        for(int i = 0; i < celula.length; i++){
            for(int j = 0; j < celula[0].length; j++){
                celula[i][j] = (255 - 1) - celula[i][j];
                celula[i][j] = (int)(Math.pow(254, 1 - 0.5) * (Math.pow(celula[i][j],0.5)));
            }
        }
        correcao(celula);
        ImagemDigital.plotarImagem(celula, "celulaTratada");
        
        //GorisRaoni----------------------------------------------------------------------------------
        for(int i = 0; i < gorisRaioni.length; i++){
            for(int j = 0; j < gorisRaioni[0].length; j++){
                gorisRaioni[i][j][0] = (int)(Math.pow(254, 1 - 5.0) * (Math.pow(gorisRaioni[i][j][0],5.0)));
                gorisRaioni[i][j][1] = (int)(Math.pow(254, 1 - 5.0) * (Math.pow(gorisRaioni[i][j][1],5.0)));    
                gorisRaioni[i][j][2] = (int)(Math.pow(254, 1 - 5.0) * (Math.pow(gorisRaioni[i][j][2],5.0))); 
            }
        }
        correcaoCor(gorisRaioni);
        ImagemDigital.plotarImagemCor(gorisRaioni, "gorisRaoniTratada");
        
        //celula --------------------------------------------------------------------------------------------
        for(int i = 0; i < celula.length; i++){
            for(int j = 0; j < celula[0].length; j++){
                celula[i][j] = (255 - 1) - celula[i][j];
                celula[i][j] = (int)(Math.pow(254, 1 - 0.5) * (Math.pow(celula[i][j],0.5)));
            }
        }
        correcao(celula);
        ImagemDigital.plotarImagem(celula, "celulaTratada");
        
        //cerebro --------------------------------------------------------------------------------------------
        for(int i = 0; i < cerebro.length; i++){
            for(int j = 0; j < cerebro[0].length; j++){
                cerebro[i][j] = (255 - 1) - cerebro[i][j];
            }
        }
        correcao(cerebro);
        ImagemDigital.plotarImagem(cerebro, "cerebroTratado");      
    }
    
}
