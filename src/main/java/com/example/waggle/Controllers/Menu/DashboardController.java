package com.example.waggle.Controllers.Menu;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;


import java.net.URL;
import java.util.ResourceBundle;



public class DashboardController implements Initializable
{
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
   /* @FXML
    public BarChart<String,Integer> DailyProgress;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        DailyProgress.getXAxis().setLabel("Days");
        DailyProgress.getYAxis().setLabel("Progress");

        XYChart.Series<String,Integer> series1 = new XYChart.Series<>();
        series1.setName("Advertisement");
        series1.getData().add(new XYChart.Data<>("January", 23));
        series1.getData().add(new XYChart.Data<>("February", 14));
        series1.getData().add(new XYChart.Data<>("March", 15));

        XYChart.Series<String,Integer> series2 = new XYChart.Series<>();
        series2.setName("Lost");
        series2.getData().add(new XYChart.Data<>("January", 33));
        series2.getData().add(new XYChart.Data<>("February", 22));
        series2.getData().add(new XYChart.Data<>("March", 27));

        DailyProgress.getData().addAll(series1, series2);

    }

*/

}
