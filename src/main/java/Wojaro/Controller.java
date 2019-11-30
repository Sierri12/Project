package Wojaro;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField e;

    @FXML
    private TextField a;





    @FXML
    private ScatterChart<Number,Number> Wykres;

    @FXML
    private NumberAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private Button btnBisekcja;

    @FXML
    private Button btnPktStaly;

    @FXML
    private Button btnNewton;

    @FXML
    private Button btnSieczne;

    @FXML
    void ActBtnBisekcja(ActionEvent event) {
        System.out.println("Wybrano metodę bisekcji");

        Wykres.getData().clear();

        XYChart.Series series= new XYChart.Series();

        double M;
        double a=150*10^6;
        double e=0.0167;

        for (int i=0;i<=360;i++) {
           M = i * Math.PI / (180);
            double finalM = M;

            double E = RootSolver.bisekcja(0, 2 * Math.PI, 0.005, 30, (x) -> finalM + e * Math.sin(x) - x);

            double x = a * Math.cos(E - e);
            double y = a * Math.sqrt(1 - Math.pow(e, 2)) * Math.sin(E);
            series.getData().add(new XYChart.Data(x,y));
        }
        // dodaj dane do wykresu
        Wykres.getData().add(series);


    }

    @FXML
    void ActBtnNewton(ActionEvent event) {

    }

    @FXML
    void ActBtnPktStaly(ActionEvent event) {

    }

    @FXML
    void ActBtnSieczne(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert Wykres != null : "fx:id=\"Wykres\" was not injected: check your FXML file 'graph.fxml'.";
        assert btnBisekcja != null : "fx:id=\"btnBisekcja\" was not injected: check your FXML file 'graph.fxml'.";
        assert btnPktStaly != null : "fx:id=\"btnPktStaly\" was not injected: check your FXML file 'graph.fxml'.";
        assert btnNewton != null : "fx:id=\"btnNewton\" was not injected: check your FXML file 'graph.fxml'.";
        assert btnSieczne != null : "fx:id=\"btnSieczne\" was not injected: check your FXML file 'graph.fxml'.";
        assert e != null : "fx:id=\"e\" was not injected: check your FXML file 'graph.fxml'.";
        assert a != null : "fx:id=\"a\" was not injected: check your FXML file 'graph.fxml'.";

    }
}
