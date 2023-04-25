package main.java;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SortingVisualisationApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 500, 1000);
        stage.show();
    }

    public static void main(String[] args){
launch(args);
    }
}
