package main.java.algorithms;

//Abstract class is responsible for base function/variable for every Algorithm
public abstract class AlgorithmAbstract{
    protected int [] arr; //main array for sort
    protected int count = 0; //for amount of chosen operation

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
}
