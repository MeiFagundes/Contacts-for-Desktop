package mei.contacts_for_desktop.view;

import java.text.DateFormatSymbols;
import java.util.List;
import java.util.Locale;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import mei.contacts_for_desktop.model.IPerson;
import mei.contacts_for_desktop.model.Person;

/**
 * The controller for the birthday statistics view.
 * 
 * @author Marco Jakob, Mei
 */
public class BirthdayStatisticsController implements IBirthdayStatisticsController {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xAxis;
    
    private IFXChart birthdayChart = new FXChart();
    
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        
        // Get an array with the English month names.
        String[] months = DateFormatSymbols.getInstance(Locale.ENGLISH).getMonths();
        
        birthdayChart.createChart(xAxis, months);
    }

    /**
     * Sets the persons to show the statistics for.
     * 
     * @param persons
     */
    @Override
    public void setPersonData(List<Person> persons) {
        
        // Count the number of people having their birthday in a specific month.
        int[] monthCounter = new int[12];
        for (IPerson p : persons) {
            int month = p.getBirthday().getMonthValue() - 1;
            monthCounter[month]++;
        }
        
        birthdayChart.fillChart(barChart, monthCounter);
    }
}