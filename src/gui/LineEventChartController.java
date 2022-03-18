/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;
import java.util.Date;
import entities.Evenement;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.time.LocalDate;
import java.util.Calendar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import static javax.swing.UIManager.get;
import services.EventCrud;
/**
 * FXML Controller class
 *
 * @author oussa
 */
public class LineEventChartController implements Initializable {
        
      @FXML
    private LineChart<String, Integer> Linechart;

    @FXML
    private CategoryAxis xAxis;

    private ObservableList<String> monthNames = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String[] months = DateFormatSymbols.getInstance(Locale.ENGLISH).getMonths();
        // Convert it to a list and add it to our ObservableList of months.
        monthNames.addAll(Arrays.asList(months));
        EventCrud s = new EventCrud();
        List<Evenement> l= s.afficher();
        // Assign the month names as categories for the horizontal axis.
        
        xAxis.setCategories(monthNames);
        setEventData(l);
    }  
    public void setEventData(List<Evenement> events) {
       
    	// Count the number of people having their birthday in a specific month.
        int[] monthCounter = new int[12];
        for (Evenement p : events) {
           Calendar calendar = Calendar.getInstance();
           calendar.setTime(p.getDate_evenement());
          
           int month = p.getDate_evenement().getMonth();
            System.out.println(month);
           monthCounter[month]++;
        }

        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        
        // Create a XYChart.Data object for each month. Add it to the series.
        for (int i = 0; i < monthCounter.length; i++) {
        	series.getData().add(new XYChart.Data<>(monthNames.get(i), monthCounter[i]));
        }
        
         Linechart.getData().add(series);
        
    }
    
}
