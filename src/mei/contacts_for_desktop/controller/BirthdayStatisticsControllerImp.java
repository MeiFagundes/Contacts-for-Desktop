/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mei.contacts_for_desktop.controller;

import java.text.DateFormatSymbols;
import java.util.List;
import java.util.Locale;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import mei.contacts_for_desktop.model.Interface.IPerson;
import mei.contacts_for_desktop.model.Person;
import mei.contacts_for_desktop.view.FXChartSingleton;
import mei.contacts_for_desktop.view.Interface.IFXChart;

/**
 *
 * @author Mei
 */
public class BirthdayStatisticsControllerImp {
    
    private IFXChart birthdayChart;

    public BirthdayStatisticsControllerImp() {
        
        birthdayChart = FXChartSingleton.getNewInstance();
    }
    
    public void initialize(CategoryAxis xAxis){
        
        // Get an array with the English month names.
        String[] months = DateFormatSymbols.getInstance(Locale.ENGLISH).getMonths();
        
        birthdayChart.createChart(xAxis, months);
    }
    
    public void setPersonData(List<Person> persons, BarChart<String, Integer> barChart) {
        
        // Count the number of people having their birthday in a specific month.
        int[] monthCounter = new int[12];
        for (IPerson p : persons) {
            int month = p.getBirthday().getMonthValue() - 1;
            monthCounter[month]++;
        }
        
        birthdayChart.fillChart(barChart, monthCounter);
    }
}
