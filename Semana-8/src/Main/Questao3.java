/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import imagemDigital.ImagemDigital;

/**
 *
 * @author michel
 */
public class Questao3 {
    public static void main(String[] args) {
        
        int[][][] imgMichel = ImagemDigital.carregarImagemCor("michel.jpg");
        ImagemDigital.plotarImagemCor(imgMichel, "Michel.jpg");
        int[][][] imgMichelFace = new int[300][300][3];
        
        //letra A --------------------------------------------------------------
        for(int i = 70; i < 370; i++){
            for(int j = 95; j < 395; j++){
                imgMichelFace[i-70][j-95][0] = imgMichel[i][j][0]; //red
                imgMichelFace[i-70][j-95][1] = imgMichel[i][j][1]; //green
                imgMichelFace[i-70][j-95][2] = imgMichel[i][j][2]; //blue
            }
        }
        ImagemDigital.plotarImagemCor(imgMichelFace, "Michel Face");
        
        //letra B --------------------------------------------------------------
        final int B = 100;
        
        for(int i = 0; i < imgMichelFace.length; i++){
            for(int j = 0; j < imgMichelFace[0].length; j++){
                imgMichelFace[i][j][2] = Math.min(imgMichelFace[i][j][2] + B, 255);
            }
        }
        ImagemDigital.plotarImagemCor(imgMichelFace, "Michel Face Azul");
        
        //letra C --------------------------------------------------------------
        
        final int C = 70;
        
            for(int i = 0; i < imgMichelFace.length; i++){
                for(int j = 0; j < imgMichelFace[0].length; j++){
                    imgMichelFace[i][j][0] = Math.min(imgMichelFace[i][j][0] + C, 255);
                    imgMichelFace[i][j][1] = Math.min(imgMichelFace[i][j][1] + C, 255);
                    imgMichelFace[i][j][2] = Math.min(imgMichelFace[i][j][2] + C, 255);
            }
        }
        ImagemDigital.plotarImagemCor(imgMichelFace, "Mais claro");
        
         //letra D --------------------------------------------------------------
         final int D = -100;
            for(int i = 0; i < imgMichelFace.length; i++){
                for(int j = 0; j < imgMichelFace[0].length; j++){
                    imgMichelFace[i][j][0] = Math.max(imgMichelFace[i][j][0] + D, 0);
                    imgMichelFace[i][j][1] = Math.max(imgMichelFace[i][j][1] + D, 0);
                    imgMichelFace[i][j][2] = Math.max(imgMichelFace[i][j][2] + D, 0);
                }
            }
        ImagemDigital.plotarImagemCor(imgMichelFace, "Mais escuro");
        
        //letra E ---------------------------------------------------------------
        final float E = (float) 1.4;
        for(int i = 0; i < imgMichelFace.length; i++){
            for(int j = 0; j < imgMichelFace[0].length; j++){
                imgMichelFace[i][j][0] = Math.min((int)(imgMichelFace[i][j][0] * E), 255);
                imgMichelFace[i][j][1] = Math.min((int)(imgMichelFace[i][j][1] * E), 255);
                imgMichelFace[i][j][2] = Math.min((int)(imgMichelFace[i][j][2] * E), 255);
            }
        }
        ImagemDigital.plotarImagemCor(imgMichelFace, "const > 1");

        //letra F ---------------------------------------------------------------
        final float F = (float) 0.4;
        for(int i = 0; i < imgMichelFace.length; i++){
            for(int j = 0; j < imgMichelFace[0].length; j++){
                imgMichelFace[i][j][0] = Math.max((int)(imgMichelFace[i][j][0] * F), 0);
                imgMichelFace[i][j][1] = Math.max((int)(imgMichelFace[i][j][1] * F), 0);
                imgMichelFace[i][j][2] = Math.max((int)(imgMichelFace[i][j][2] * F), 0);
            }
        }
        ImagemDigital.plotarImagemCor(imgMichelFace, "const < 1");
        
    }
}
