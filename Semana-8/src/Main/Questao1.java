/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import imagemDigital.ImagemDigital;
import java.util.ArrayList;

/**
 *
 * @author michel
 */
public class Questao1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //QUESTAO -1 -----------------------------------------------------------
    
        int[][] img = ImagemDigital.carregarImagem("Fig0207(a)(gray-level-band).png");
        ArrayList<Integer> lista = new ArrayList<Integer>();
        //ImagemDigital.plotarImagem(img, "Tela");
       
        // varendo os pixels
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                if(!lista.contains(img[i][j])){
                    lista.add(img[i][j]);
                }
            }
        }
        for(int item : lista){
            System.out.println(item);
        }
     
    }
    
}
