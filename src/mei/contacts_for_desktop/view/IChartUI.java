/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mei.contacts_for_desktop.view;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;

/**
 *
 * @author Mei
 */
public interface IChartUI {
    
    public CategoryAxis createChart(CategoryAxis xAxis, String[] categories);
    public BarChart<String, Integer> fillChart(BarChart<String, Integer> barChart, int[] monthCounter);
}
