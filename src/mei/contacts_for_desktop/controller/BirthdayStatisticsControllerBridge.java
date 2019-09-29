package mei.contacts_for_desktop.controller;

import mei.contacts_for_desktop.controller.Interface.IBirthdayStatisticsController;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import mei.contacts_for_desktop.model.Person;

/**
 * The controller for the birthday statistics view.
 * 
 * @author Marco Jakob, Mei
 */
public class BirthdayStatisticsControllerBridge implements IBirthdayStatisticsController {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xAxis;
    
    private BirthdayStatisticsControllerImp birthdayStatistics;
    
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        
        birthdayStatistics = new BirthdayStatisticsControllerImp();
        birthdayStatistics.initialize(xAxis);
    }

    /**
     * Sets the persons to show the statistics for.
     * 
     * @param persons
     */
    @Override
    public void setPersonData(List<Person> persons) {
        
        birthdayStatistics.setPersonData(persons, barChart);
    }
}