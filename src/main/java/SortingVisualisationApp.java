package main.java;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyListWrapper;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import main.java.algorithms.AlgorithmMyTest;

public class SortingVisualisationApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ScrollPane sp = new ScrollPane();
        sp.fitToWidthProperty().set(true);
        sp.fitToHeightProperty().set(true);

        StackPane root = new StackPane();
        sp.setContent(root);

        Scene scene = new Scene(sp, 1100, 600);

//        root.getChildren().add(new Main(1000).getNode());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
launch(args);
    }
}
