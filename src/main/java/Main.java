package main.java;

import main.java.algorithms.AlgorithmMyTest;
import main.java.algorithms.AlgorithmQuickSort;

import java.util.Arrays;
import java.util.Random;
public class Main {
    int[] inputDataArr; //input array
    int[] shuffledInputDataArr; //shuffled input array
    int[] sortedAfterShuffleInputDataArr; //sorted after shuffle input array
    int count = 0; //for amount of chosen operation

    //constructor set size of array,
    // initialise function of filling array,
    //shuffle initialised and filled array
    // initialise array sort function
    //output LOG info

    public Main(int size){
        inputDataArr = new int[size];
        fillInputArr();
        shuffledInputDataArr = inputDataArr.clone();
        shuffleInputArr();
        sortedAfterShuffleInputDataArr = new int[size];

        sortArray(shuffledInputDataArr);
        System.out.println("First:"+sortedAfterShuffleInputDataArr[0]
                + " Last:" + sortedAfterShuffleInputDataArr[sortedAfterShuffleInputDataArr.length-1]
                + " Count:" + count);
    }


    //function print in console already shuffled array
    //initialise sorting algorithm class and setting array in
    //getting array from class
    //getting count from class
    //printing in console sorted array
    private void sortArray(int[] arr) {
        System.out.println(Arrays.toString(arr));

//        AlgorithmMyTest al1MyTest = new AlgorithmMyTest(arr);
        AlgorithmQuickSort al1MyTest = new AlgorithmQuickSort(arr);

        sortedAfterShuffleInputDataArr = al1MyTest.getArr();
        count = al1MyTest.getCount();

        System.out.println(Arrays.toString(sortedAfterShuffleInputDataArr));
    }

    //function for filling array in numbers with step 1 for array length
    private void fillInputArr() {
        for(int i = 0; i<inputDataArr.length; i++){
            inputDataArr[i] = i;
        }
    }

    //function for shuffling array by choosing random index in range [0, array length]
    // and swapping element i with random index element
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
