package main.java.algorithmsFX;

import java.util.stream.IntStream;

public final class AlgorithmMyTestFX extends AlgorithmAbstractFX {
    private boolean isSorted = false;


    //constructor with variable
    public AlgorithmMyTestFX(int[] arrNumbers){
        while(!isSorted) {
            for (int i = 0; i < arrNumbers.length - 1; i++) { //swap the two elements(el) if el. i+1 less than el. i
                count++;
                if (arrNumbers[i] > arrNumbers[i + 1]) {
                    swap(arrNumbers, i, i+1);
                }
            }
            isSorted = true;
            for (int i = 0; i<arrNumbers.length-1; i++) { //check if array is sorted
                count++;
                if(arrNumbers[i] > arrNumbers[i + 1]){
                    isSorted = false;
                    break;
                }
            }
        }
        this.arrNumbers = arrNumbers.clone();
    }

    //constructor withOut variable
    public AlgorithmMyTestFX(){
        arrNumbers = IntStream.rangeClosed(0, 499).toArray();
        while(!isSorted) {
            for (int i = 0; i < arrNumbers.length - 1; i++) {
                count++;
                if (arrNumbers[i] > arrNumbers[i + 1]) {
                    int temp = arrNumbers[i];
                    arrNumbers[i] = arrNumbers[i + 1];
                    arrNumbers[i + 1] = temp;
                }
            }
            isSorted = true;
            for (int i = 0; i<arrNumbers.length-1; i++) {
                count++;
                if(arrNumbers[i] > arrNumbers[i + 1]){
                    isSorted = false;
                    break;
                }
            }
        }
    }
}
