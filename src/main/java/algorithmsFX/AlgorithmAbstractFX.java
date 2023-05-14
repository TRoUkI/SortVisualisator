package main.java.algorithmsFX;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import main.java.utility.InputArrayClass;

//Abstract class is responsible for base function/variable for every Algorithm
public abstract class AlgorithmAbstractFX {
    protected int [] arrNumbers; //main array for sort
    protected int count = 0; //for amount of chosen operation

    //JavaFX obj
    Pane box = new Pane(); //Main pane that set all elements and after will be set in main program
    Rectangle[] rectangleArray;

    //constructor for all Algorithms
    //get shuffled array of numbers
    //set Pane settings
    //create rectangle array
    //fill rectangle array
    //add array of rectangles to pane
    AlgorithmAbstractFX(){
        arrNumbers = new InputArrayClass(20).getArray();
        box.setMaxSize(1000, 500);
        box.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        rectangleArray = new Rectangle[arrNumbers.length];
        fillRectangleArray(arrNumbers, rectangleArray);
        box.getChildren().addAll(rectangleArray);
    }

    public void AlgorithmBody(){

    }

    //function fill the given array of rectangles by
    //using numbers from array of shuffled numbers
    protected void fillRectangleArray(int[] arrNumbers, Rectangle[] rectangle){
        for(int i = 0; i<rectangleArray.length; i++){
            rectangle[i] = createRectangle(arrNumbers[i]);
            changeRectangleXPosition(rectangle[i], i);
        }
    }

    //function create rectangle
    // with WIDTH of boxWidth divided to number of rectangle, it`s for maximum usage of the pane
    //with HEIGHT of the UNIT by boxHeight divided to max number of i(array length) and multiplying UNIT for i
    //set Color for rectangle
    //correcting Y axis
    private Rectangle createRectangle(int i) {
        Rectangle rectangle = new Rectangle(box.getMaxWidth()/rectangleArray.length, (box.getMaxHeight()/rectangleArray.length)*i);
        correctRectanglePlacement(rectangle);

        rectangle.setFill(Color.web("#CBB279"));
        rectangle.setStroke(Color.web("#537188"));
        rectangle.setStyle("-fx-stroke-type:inside; -fx-stroke-width: 1;");

        return(rectangle);
    }

    //function for changing X position of rectangle
    private void changeRectangleXPosition(Rectangle rectangle, int pos) {
        rectangle.setX(rectangle.getWidth()*pos);
    }

    //function correct the Y axis
    protected void correctRectanglePlacement(Rectangle rectangle){
        rectangle.setY(box.getMaxHeight()-rectangle.getHeight());
    }

    protected double convetrRectangleXPlacement(Rectangle rectangle){
        return rectangle.getX()/rectangle.getWidth();
    }

    // A utility function to swap two elements
    protected void swap(int[] arrNumbers, int a, int b){
        int temp = arrNumbers[a];
        arrNumbers[a] = arrNumbers[b];
        arrNumbers[b] = temp;
    }

    //Getter for count
    public int getCount() {
        return count;
    }

    //getter for arrNumbers array
    public int[] getArr() {
        return arrNumbers;
    }

    public String getName(){
        return this.getClass().getSimpleName();
    }

    public Pane getPane() {
        return box;
    }
}
