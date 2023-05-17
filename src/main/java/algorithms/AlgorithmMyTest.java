package main.java.algorithms;

public final class AlgorithmMyTest extends AlgorithmAbstract{
    private boolean isSorted = false;

    @Override
    //function that start algorithm calculation
    //and print result
    public void AlgorithmBody(){
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
        getConsoleArray();
    }
}
