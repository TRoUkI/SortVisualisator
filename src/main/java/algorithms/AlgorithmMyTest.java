package main.java.algorithms;

import java.util.stream.IntStream;

public final class AlgorithmMyTest extends AlgorithmAbstract{
    private boolean isSorted = false;
    public AlgorithmMyTest(int[] arr){
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
        this.arr = arr.clone();
    }
    public AlgorithmMyTest(){
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
