package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * Created by Oxana on 23.02.2016.
 */
public class FastController {
    @FXML
    public LineChart origin;

    @FXML
    public LineChart reverse;

    @FXML
    public LineChart convert;


    @FXML
    public Label fast;

    int N = 8;


    public  void initialize(){
        origin.getXAxis().setAutoRanging(true);
        origin.getYAxis().setAutoRanging(true);
        XYChart.Series seriesOrigin = new XYChart.Series<>();
        seriesOrigin.setName("Original Function");
        FastConversion conversion = new FastConversion();
        ArrayList<Double> functionValue = conversion.getFunction();
        for(Integer i = 0; i < N; i++){
            Double temp = 2 * Math.PI / (N) * i;
            temp = new BigDecimal(temp).setScale(2, RoundingMode.UP).doubleValue();
            seriesOrigin.getData().add(new XYChart.Data<>(temp.toString(), functionValue.get(i)));
        }
        origin.getData().add(seriesOrigin);

        convert.getXAxis().setAutoRanging(true);
        convert.getYAxis().setAutoRanging(true);
        XYChart.Series seriesAbsolute = new XYChart.Series<>();
        seriesAbsolute.setName("Convert Function");
        ArrayList<Double> function = conversion.fastWalshTransform(functionValue, 1);
        for(Integer i = 0; i < N; i++){
            Double temp = 2 * Math.PI / (N) * i;
            temp = new BigDecimal(temp).setScale(2, RoundingMode.UP).doubleValue();
            seriesAbsolute.getData().add(new XYChart.Data<>(temp.toString(), function.get(i)));
        }
        convert.getData().add(seriesAbsolute);

        reverse.getXAxis().setAutoRanging(true);
        reverse.getYAxis().setAutoRanging(true);
        XYChart.Series seriesReverse = new XYChart.Series<>();
        seriesReverse.setName("Reverse  Function");
        ArrayList<Double> functionReverse = conversion.fastWalshTransform(function, -1);
        for(Integer i = 0; i < N; i++){
            Double temp = 2 * Math.PI / (N) * i;
            temp = new BigDecimal(temp).setScale(2, RoundingMode.UP).doubleValue();
            seriesReverse.getData().add(new XYChart.Data<>(temp.toString(), functionReverse.get(i) / N));
        }
        reverse.getData().add(seriesReverse);

        int countOperation;
        countOperation = conversion.getMulCount()+conversion.getSumCount();
        fast.setText(fast.getText()+countOperation);



    }
    public void changeScene(ActionEvent event)throws IOException {
        Parent original = FXMLLoader.load(getClass().getResource("digitalConversion.fxml"));
        Scene originalScene = new Scene(original);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(originalScene);
        stage.show();
    }
}
