package main.java.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import main.java.algorithmsFX.AlgorithmAbstractFX;
import main.java.algorithmsFX.AlgorithmMyTestFX;
import main.java.algorithmsFX.AlgorithmQuickSortFX;
import main.java.utility.ButtonTask;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {


    String currentAlgorithmStr;
    ArrayList<AlgorithmAbstractFX> algorithmArray= new ArrayList<>();
    AlgorithmAbstractFX currentAlgorithm;

    private ButtonTask buttonTask;

    @FXML
    private AnchorPane elementField;

    @FXML
    private Button start_btn;

    //button for start sorting process
    //check if chosen algorithm notNull
    //clear previous data
    //add pane with rectangles
    @FXML
    void press_start_btn(ActionEvent event) {
        if(currentAlgorithm==null){
            return;
        }
        invokeStartSorting();
    }

    private void invokeStartSorting() {
        elementField.getChildren().clear();
        elementField.getChildren().add(currentAlgorithm.getPane());
        buttonTask = new ButtonTask(currentAlgorithm);

        Thread th = new Thread(buttonTask);
        th.setDaemon(true);
        th.start();
    }
//        new ButtonService(currentAlgorithm).start();
//        Thread thread = new Thread(){
//            @Override
//            public void run() {
        //                currentAlgorithm.AlgorithmBody();

//            }
//        };
//        thread.start();

    @FXML
    private ListView<String> algorithm_listViewFX;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addAlgorithms();
        for(AlgorithmAbstractFX oneAlgorithm: algorithmArray){
            algorithm_listViewFX.getItems().add(oneAlgorithm.getName());
        }

        algorithm_listViewFX.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                currentAlgorithmStr = algorithm_listViewFX.getSelectionModel().getSelectedItem();
                currentAlgorithm = getAlgorithmByName(currentAlgorithmStr);
            }
        });
    }

    private void addAlgorithms() {
        algorithmArray.add(new AlgorithmMyTestFX());
        algorithmArray.add(new AlgorithmQuickSortFX());
    }
    private AlgorithmAbstractFX getAlgorithmByName(String algName){
        for(AlgorithmAbstractFX oneAlgorithm: algorithmArray){
            if(oneAlgorithm.getName()==algName){
                return oneAlgorithm;
            }
        }
        return null;
    }
}

