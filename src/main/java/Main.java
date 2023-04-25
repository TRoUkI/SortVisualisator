package main.java;

import main.java.algorithms.AlgorithmMyTest;
import main.java.algorithms.AlgorithmQuickSort;

import java.util.Arrays;
import java.util.Random;
public class Main {
    int[] inputDataArr;
    int[] shuffledInputDataArr;
    int[] sortedAfterShuffleInputDataArr;
    int count = 0;
    public Main(int size){
        inputDataArr = new int[size];
        fillInputArr();
        shuffledInputDataArr = inputDataArr.clone();
        sortedAfterShuffleInputDataArr = new int[size];

        shuffleInputArr();
        sortArray(shuffledInputDataArr);
        System.out.println("First:"+sortedAfterShuffleInputDataArr[0]
                + " Last:" + sortedAfterShuffleInputDataArr[sortedAfterShuffleInputDataArr.length-1]
                + " Count:" + count);
    }

    private void sortArray(int[] arr) {
        System.out.println(Arrays.toString(arr));

//        AlgorithmMyTest al1MyTest = new AlgorithmMyTest(arr);
        AlgorithmQuickSort al1MyTest = new AlgorithmQuickSort(arr);
        sortedAfterShuffleInputDataArr = al1MyTest.getArr();
        count = al1MyTest.getCount();

        System.out.println(Arrays.toString(sortedAfterShuffleInputDataArr));
    }

    private void fillInputArr() {
        for(int i = 0; i<inputDataArr.length; i++){
            inputDataArr[i] = i;
        }
    }
    private void shuffleInputArr() {
        Random random = new Random();

        random.setSeed(1); //setSeed for control result

        for(int i = 0; i<shuffledInputDataArr.length; i++){
            int randomIndexForSwap = random.nextInt(shuffledInputDataArr.length);
            int temp = shuffledInputDataArr[randomIndexForSwap];
            shuffledInputDataArr[randomIndexForSwap] = shuffledInputDataArr[i];
            shuffledInputDataArr[i] = temp;
        }

    }
}
