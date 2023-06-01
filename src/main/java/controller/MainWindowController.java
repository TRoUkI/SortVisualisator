package main.java.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import main.java.algorithmsFX.AlgorithmAbstractFX;
import main.java.algorithmsFX.AlgorithmMyTestFX;
import main.java.algorithmsFX.AlgorithmQuickSortFX;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    String currentAlgorithmStr;
    ArrayList<AlgorithmAbstractFX> algorithmArray= new ArrayList<>();
    AlgorithmAbstractFX currentAlgorithm;
    Thread th;

    @FXML
    private TextField speedField;

    @FXML
    private AnchorPane elementField;

    @FXML
    private Button pause_btn;

    @FXML
    void pause_btn_action(ActionEvent event) {
        if(pause_btn.getText().equals("PAUSE")){
            currentAlgorithm.setPaused(true);
            pause_btn.setText("RESUME");
            return;
        }
        currentAlgorithm.setPaused(false);
        pause_btn.setText("PAUSE");
    }

    @FXML
    private Button set_btn;

    @FXML
    void set_btn_action(ActionEvent event) {
        int i = Integer.parseInt(speedField.getText());
        currentAlgorithm.setTime(i);
    }

    @FXML
    private Button start_btn;

    //button for start sorting process
    //check if chosen algorithm notNull
    //nulling previous thread iif exist
    //canceling previous calculation
    //clear previous data
    //recreating currentAlgorithm for initialisation constructor if needed
    //invoke start sorting with current algorithm
    @FXML
    void start_btn_action(ActionEvent event) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if(currentAlgorithm==null){
            return;
        }
        if(th != null){
            th.interrupt();
            th = null;
        }
        currentAlgorithm.cancel();
        elementField.getChildren().clear();
        currentAlgorithm = currentAlgorithm.getClass().getConstructor().newInstance();
        invokeStartSorting(currentAlgorithm);
    }
    //add pane with rectangles
    //start new thread with overwritten interrupt() function witch call canceling currentAlgorithm
    private void invokeStartSorting(AlgorithmAbstractFX currentAlgorithm) {
        elementField.getChildren().add(currentAlgorithm.getPane());
        th = new Thread(new Runnable() {
            @Override
            public void run() {
                currentAlgorithm.run();
            }
        }){
            @Override
            public void interrupt() {
                super.interrupt();
                currentAlgorithm.cancel();
            }
        };
        th.setDaemon(true);
        th.start();
    }

    @FXML
    private ListView<String> algorithm_listViewFX;

    //create array of algorithm tasks,
    //as element is different algorithm classes that inherit AlgorithmAbstractFX
    //add all nodes as string objects
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        speedField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    speedField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
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
            if(oneAlgorithm.getName().equals(algName)){
                return oneAlgorithm;
            }
        }
        return null;
    }
}