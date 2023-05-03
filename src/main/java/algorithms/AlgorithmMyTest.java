package main.java.algorithms;

import java.util.stream.IntStream;

public final class AlgorithmMyTest extends AlgorithmAbstract{
    private boolean isSorted = false;


    //constructor with variable
    public AlgorithmMyTest(int[] arr){
        while(!isSorted) {
            for (int i = 0; i < arr.length - 1; i++) { //swap the two elements(el) if el. i+1 less than el. i
                count++;
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            isSorted = true;
            for (int i = 0; i<arr.length-1; i++) { //check if array is sorted
                count++;
                if(arr[i] > arr[i + 1]){
                    isSorted = false;
                    break;
                }
            }
        }
        this.arr = arr.clone();
    }

    //constructor withOut variable
    public AlgorithmMyTest(){ //
        arr = IntStream.rangeClosed(0, 499).toArray();
        while(!isSorted) {
            for (int i = 0; i < arr.length - 1; i++) {
                count++;
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            isSorted = true;
            for (int i = 0; i<arr.length-1; i++) {
                count++;
                if(arr[i] > arr[i + 1]){
                    isSorted = false;
                    break;
                }
            }
        }
    }
}
