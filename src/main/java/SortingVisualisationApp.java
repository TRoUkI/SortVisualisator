package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SortingVisualisationApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/main/resources/fxml/MainWindow.fxml"));
        Scene scene = new Scene(root, 1000, 600);
        stage.setScene(scene);
//        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args){
launch(args);
    }
}
