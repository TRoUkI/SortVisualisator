package main.java.utility;

import javafx.concurrent.Task;
import main.java.algorithmsFX.AlgorithmAbstractFX;

public class ButtonTask extends Task {
    private AlgorithmAbstractFX currentAlgorithm;
    public ButtonTask(AlgorithmAbstractFX currentAlgorithm) {
        this.currentAlgorithm = currentAlgorithm;
    }

    @Override
    protected Object call() {
        currentAlgorithm.AlgorithmBody();
        return currentAlgorithm;
    }
}
