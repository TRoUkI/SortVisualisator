package main.java.algorithmsFX;

import javafx.scene.control.Tooltip;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import main.java.utility.InputArrayClass;
import main.java.utility.RectangleClass;

//Abstract class is responsible for base function/variable for every Algorithm
public abstract class AlgorithmAbstractFX {
    protected int [] arrNumbers; //main array for sort
    protected int count = 0; //for amount of chosen operation

    //JavaFX obj
    Pane box = new Pane(); //Main pane that set all elements and after will be set in main program
    RectangleClass[] rectangleArray;
    private final long time = 500; //full delay for swap function
    private final int size = 30; //size of the array

    //constructor for all Algorithms
    //get shuffled array of numbers
    //set Pane settings
    //create rectangle array
    //fill rectangle array
    //add array of rectangles to pane
    AlgorithmAbstractFX(){
        box.setMaxSize(1000, 500);
        box.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        arrNumbers = new InputArrayClass(size).getArray();
        rectangleArray = new RectangleClass[arrNumbers.length];
        fillRectangleArray(arrNumbers, rectangleArray);
        box.getChildren().addAll(rectangleArray);
    }

    public void AlgorithmBody(){    }

    //function fill the given array of rectangles by
    //using numbers from array of shuffled numbers
    protected void fillRectangleArray(int[] arrNumbers, RectangleClass[] rectangle){
        for(int i = 0; i<rectangleArray.length; i++){
            rectangle[i] = createRectangle(arrNumbers[i]);
            rectangle[i].changeRectangleXPosition(i);
        }
    }

    //function create rectangle
    // with WIDTH of boxWidth divided to number of rectangle, it`s for maximum usage of the pane
    //with HEIGHT of the UNIT by boxHeight divided to max number of i(array length) and multiplying UNIT for i
    //set Color for rectangle
    //correcting Y axis
    private RectangleClass createRectangle(int i) {
        RectangleClass rectangle = new RectangleClass(box.getMaxWidth()/rectangleArray.length, (box.getMaxHeight()/rectangleArray.length)*i);
        rectangle.setId(String.valueOf(i));
        Tooltip tooltip = new Tooltip(String.valueOf(i));
        Tooltip.install(rectangle,tooltip);
        rectangle.correctRectanglePlacement(box);

        rectangle.setStandartColor();
        rectangle.setStroke(Color.web("#537188"));
        rectangle.setStyle("-fx-stroke-type:inside; -fx-stroke-width: 1;");

        return(rectangle);
    }



    // A utility function to swap two elements
    protected void swap(RectangleClass[] arr, int a, int b){
        arr[a].setFill(Color.PINK);
        arr[b].setFill(Color.BLUE);
        try {
            Thread.sleep((long) (time*0.4));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        RectangleClass temp = arr[a];
        arr[a] = arr[b];
        arr[a].changeRectangleXPosition(a);
        arr[b] = temp;
        arr[b].changeRectangleXPosition(b);
        try {
            Thread.sleep((long) (time*0.4));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        arr[a].setStandartColor();
        arr[b].setStandartColor();
    }

    public String getName(){
        return this.getClass().getSimpleName();
    }

    public Pane getPane() {
        return box;
    }

    public void getConsoleArray() {
        String st = "";
        for(RectangleClass rectangleClass : rectangleArray){
            st += " "+rectangleClass.getIntId();
        }
        System.out.println(st);
    }
}
