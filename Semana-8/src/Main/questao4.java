/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.io.File;
import java.io.IOException;
import net.sf.javaml.classification.Classifier;
import net.sf.javaml.classification.KNearestNeighbors;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.tools.data.FileHandler;

/**
 *
 * @author michel
 */
public class questao4 {
    public static void main(String[] args) throws IOException {
        //File f = new File("iris.data");
        //System.out.println(f);
        Dataset data = FileHandler.loadDataset(new File("./iris.data"), 4, ",");

        //Classifier knn = new KNearestNeighbors(5);
    }

    
   
}
