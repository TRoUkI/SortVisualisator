package main.java.algorithms;

import java.util.stream.IntStream;

public class AlgorithmQuickSort extends AlgorithmAbstractFX{


    //constructor with variable
    public AlgorithmQuickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
        this.arr = arr.clone();
    }

    //constructor with variable
    public AlgorithmQuickSort(){
        arr = IntStream.rangeClosed(0, 499).toArray();
        quickSort(arr, 0, arr.length-1);
    }

    // The main function that implements QuickSort
    // arr[] --> Array to be sorted,
    // low --> Starting index,
    // high --> Ending index
    public void quickSort(int [] arr, int low, int high)  {

        if(low < high){
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi-1);
            quickSort(arr, pi + 1, high);
        }
    }

    // This function takes last element as pivot,
    // places the pivot element at its correct position
    // in sorted array, and places all smaller to left
    // of pivot and all greater elements to right of pivot
    public int partition(int[] arr, int low, int high){
        int pivot = arr[high];

        // Choosing the pivot
        int i = low-1;

        // Index of smaller element and indicates
        // the right position of pivot found so far
        for(int j = low; j <= high; j++){
            count++;
            // If current element is smaller than the pivot
            if(arr[j]<pivot){
                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return (i+1);
    }
}
