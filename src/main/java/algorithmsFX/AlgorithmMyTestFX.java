package main.java.algorithmsFX;

public final class AlgorithmMyTestFX extends AlgorithmAbstractFX {
    private boolean isSorted = false;


    @Override
    //constructor with variable
    public void AlgorithmBody(){
        super.AlgorithmBody();
        while(!isSorted) {
            for (int i = 0; i < rectangleArray.length - 1; i++) { //swap the two elements(el) if el. i+1 less than el. i
                count++;
                if(rectangleArray[i].greaterThan(rectangleArray[i+1])){
                    swap(rectangleArray, i, i+1);
                }
            }
            isSorted = true;
            for (int i = 0; i<rectangleArray.length-1; i++) { //check if array is sorted
                count++;
                if(rectangleArray[i].greaterThan(rectangleArray[i + 1])){
                    isSorted = false;
                    break;
                }
            }
        }
    }
}
