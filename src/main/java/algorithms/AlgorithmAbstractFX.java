package main.java.algorithms;

import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//Abstract class is responsible for base function/variable for every Algorithm
public abstract class AlgorithmAbstractFX {
    protected int [] arr; //main array for sort
    protected int count = 0; //for amount of chosen operation

    //JavaFX obj
    Pane box = new Pane();
    Rectangle rectangleArray[];


    //function create rectangles that used as representative of values
    public Pane paneWithRect(){
        box.setMaxHeight(600);
        box.setMaxSize(1000, 600);
        box.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        rectangleArray = new Rectangle[arr.length];
        for(int i = 0; i<rectangleArray.length; i++){
            rectangleArray[i] = new Rectangle(box.getMaxWidth()/rectangleArray.length, (box.getMaxHeight()/rectangleArray.length)*i);

            rectangleArray[i].setFill(Color.web("#6666ff"));
            rectangleArray[i].setX(rectangleArray[i].getWidth()*i);

            changeRectangleHeight(i, rectangleArray[i].getHeight());

            box.getChildren().add(rectangleArray[i]);
        }
        return box;
    }

    public void changeRectangleHeight(int i, double height){
        rectangleArray[i].setHeight(height);
        rectangleArray[i].setY(box.getMaxHeight()-rectangleArray[i].getHeight());
    }



    // A utility function to swap two elements
    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //Getter for count
    public int getCount() {
        return count;
    }

    //getter for arr array
    public int[] getArr() {
        return arr;
    }

    public String getName(){
        return this.getClass().getSimpleName();
    }

    public Pane getPane() {
        return box;
    }
}
