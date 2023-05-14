package main.java.algorithmsFX;

import java.util.stream.IntStream;

public class AlgorithmQuickSortFX extends AlgorithmAbstractFX {


    //constructor with variable
    public AlgorithmQuickSortFX(int[] arrNumbers){
        quickSort(arrNumbers, 0, arrNumbers.length-1);
        this.arrNumbers = arrNumbers.clone();
    }

    //constructor with variable
    public AlgorithmQuickSortFX(){
        arrNumbers = IntStream.rangeClosed(0, 499).toArray();
        quickSort(arrNumbers, 0, arrNumbers.length-1);
    }

    // The main function that implements QuickSort
    // arrNumbers[] --> Array to be sorted,
    // low --> Starting index,
    // high --> Ending index
    public void quickSort(int [] arrNumbers, int low, int high)  {

        if(low < high){
            // pi is partitioning index, arrNumbers[p]
            // is now at right place
            int pi = partition(arrNumbers, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arrNumbers, low, pi-1);
            quickSort(arrNumbers, pi + 1, high);
        }
    }

    // This function takes last element as pivot,
    // places the pivot element at its correct position
    // in sorted array, and places all smaller to left
    // of pivot and all greater elements to right of pivot
    public int partition(int[] arrNumbers, int low, int high){
        int pivot = arrNumbers[high];

        // Choosing the pivot
        int i = low-1;

        // Index of smaller element and indicates
        // the right position of pivot found so far
        for(int j = low; j <= high; j++){
            count++;
            // If current element is smaller than the pivot
            if(arrNumbers[j]<pivot){
                // Increment index of smaller element
                i++;
                swap(arrNumbers, i, j);
            }
        }
        swap(arrNumbers, i+1, high);
        return (i+1);
    }
}
