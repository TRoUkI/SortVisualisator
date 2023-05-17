package main.java.algorithms;

import main.java.utility.InputArrayClass;

import java.util.Arrays;

//Abstract class is responsible for base function/variable for every Algorithm
public abstract class AlgorithmAbstract{
    protected int [] arrNumbers; //main array for sort
    protected int count = 0; //for amount of chosen operation

    private final int size = 30; //size of the array

    //initialise shuffled array from class with size
    //print the array
    AlgorithmAbstract() {
        arrNumbers = new InputArrayClass(size).getArray();
        getConsoleArray();
        }

    public void AlgorithmBody(){    }

    // A utility function to swap two elements
    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //print array of this class
    public void getConsoleArray() {
        System.out.println(Arrays.toString(arrNumbers));
    }
}
