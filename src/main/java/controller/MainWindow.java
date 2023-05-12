package main.java.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import main.java.algorithms.AlgorithmAbstract;
import main.java.algorithms.AlgorithmMyTest;

public class MainWindow {
    @FXML
    private Button start_btn;

    @FXML
    void press_start_btn(ActionEvent event) {

    }

    @FXML
    private ListView<?> algorithm_list;

    MainWindow(){
        AlgorithmAbstract aa[] = new AlgorithmAbstract[5];
        AlgorithmAbstract a = new AlgorithmMyTest();
        algorithm_list.
    }
}
