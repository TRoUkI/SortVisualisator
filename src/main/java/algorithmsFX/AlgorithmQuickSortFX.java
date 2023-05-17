package main.java.algorithmsFX;

import javafx.scene.paint.Color;
import main.java.utility.RectangleClass;

public class AlgorithmQuickSortFX extends AlgorithmAbstractFX {

    @Override
    public void AlgorithmBody() {
        super.AlgorithmBody();
        quickSort(rectangleArray, 0, rectangleArray.length-1);
    }

    // The main function that implements QuickSort
    // rectangle[] --> Array to be sorted,
    // low --> Starting index,
    // high --> Ending index
    public void quickSort(RectangleClass [] rectangle, int low, int high)  {

        if(low < high){
            // pi is partitioning index, rectangle[p]
            // is now at right place
            int pi = partition(rectangle, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(rectangle, low, pi-1);
            quickSort(rectangle, pi + 1, high);
        }
    }

    // This function takes last element as pivot,
    // places the pivot element at its correct position
    // in sorted array, and places all smaller to left
    // of pivot and all greater elements to right of pivot
    public int partition(RectangleClass[] rectangle, int low, int high){
        RectangleClass pivot = rectangle[high];
        pivot.setFill(Color.GREEN);

        // Choosing the pivot
        int i = low-1;

        // Index of smaller element and indicates
        // the right position of pivot found so far
        for(int j = low; j <= high; j++){
            count++;
            // If current element is smaller than the pivot
            if(rectangle[j].lessThan(pivot)){
                // Increment index of smaller element
                i++;
                swap(rectangle, i, j);
            }
        }
        swap(rectangle, i+1, high);
        pivot.setStandartColor();
        return (i+1);
    }
}
