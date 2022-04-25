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
public class questao3 {
    static void correcao(int[][] img){
        //fazendo correcao
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                //System.out.println(img[i][j]);
                img[i][j] = (int)(200) * img[i][j];
            }
        }
        
    }
    
    
    
    public static void main(String[] args) {
        int[][] img = ImagemDigital.carregarImagem("./imagens/Fig0229(a)(tungsten_filament_shaded).png");
        int[][] img2 = ImagemDigital.carregarImagem("./imagens/Fig0229(b)(tungsten_sensor_shading).png");
        
        int[][] imgFinal = new int[754][892];
        
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                imgFinal[i][j] = (int) (img[i][j]) / img2[i][j];
            }
        }
        
        correcao(imgFinal);
        
        ImagemDigital.plotarImagem(img, "Antes");
        ImagemDigital.plotarImagem(imgFinal, "Rersultado Final");
        
    }
}
