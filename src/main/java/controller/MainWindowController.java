package main.java.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import main.java.algorithms.AlgorithmAbstractFX;
import main.java.algorithms.AlgorithmMyTest;
import main.java.algorithms.AlgorithmQuickSort;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {
    @FXML
    private AnchorPane elementField;

    @FXML
    private Button start_btn;

    @FXML
    void press_start_btn(ActionEvent event) {
        if(currentAlgorithm==null){
            return;
        }
        elementField.getChildren().add(getAlgorithmId(currentAlgorithm).getPane());
    }

    @FXML
    private ListView<String> algorithm_listViewFX;
    String currentAlgorithm;

    ArrayList<AlgorithmAbstractFX> algorithmArray= new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addAlgorithms();
        for(AlgorithmAbstractFX oneAlgorithm: algorithmArray){
            algorithm_listViewFX.getItems().add(oneAlgorithm.getName());
        }

        algorithm_listViewFX.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                currentAlgorithm = algorithm_listViewFX.getSelectionModel().getSelectedItem();
            }
        });
    }

    private void addAlgorithms() {
        algorithmArray.add(new AlgorithmMyTest());
        algorithmArray.add(new AlgorithmQuickSort());
    }
    private AlgorithmAbstractFX getAlgorithmId(String algName){
        for(AlgorithmAbstractFX oneAlgorithm: algorithmArray){
            if(oneAlgorithm.getName()==algName){
                return oneAlgorithm;
            }
        }
        return null;
    }
}
