/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.Color;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author michel
 */
public class Histograma extends JFrame{
    
    public Histograma(int[] dataArray, String title){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("histograma");
        setSize(500,500);
        setLocationRelativeTo(null);
        criarHistograma(dataArray, title);
        setVisible(true);
    }
    
    public void criarHistograma(int[] dataArray, String title){

        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for(int i = 0; i < dataArray.length; i++){
            dataSet.addValue(dataArray[i], "tons", (Integer) i);         
        }

        
         
        JFreeChart chart = ChartFactory.createBarChart(title, "",
            "", dataSet, PlotOrientation.VERTICAL, true,false,false);
        chart.setBackgroundPaint(Color.WHITE);
        
        ChartPanel painel =  new ChartPanel(chart);
        add(painel);
    }
    
    
}
