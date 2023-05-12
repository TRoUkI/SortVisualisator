package main.java.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import main.java.algorithms.AlgorithmAbstract;
import main.java.algorithms.AlgorithmMyTest;
import main.java.algorithms.AlgorithmQuickSort;

import java.util.ArrayList;

public class MainWindowController {
    @FXML
    private Button start_btn;

    @FXML
    void press_start_btn(ActionEvent event) {

    }

    @FXML
    private ListView<?> algorithm_list;



    ArrayList<AlgorithmAbstract> algorithmArray;

    public MainWindowController(){
        algorithmArray = new ArrayList<>();
        algorithmArray.add(new AlgorithmMyTest());
        algorithmArray.add(new AlgorithmQuickSort());
    }
}
