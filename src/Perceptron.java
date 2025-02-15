import java.util.ArrayList;

public class Perceptron {
    private double output;
    private double bias;
    private int target;
    private final double[] weights;
    private final ArrayList<IrisDatasetRecord> trainingData;

    public Perceptron(ArrayList<IrisDatasetRecord> trainingData) {
        output = 0;
        bias = 0;
        target = 0; // 1 if current record matches label, 0 otherwise
        weights = new double[784]; // same size as pixel amount
        this.trainingData = trainingData;
    }

    public void trainPerceptron(int maxEpochs) {
        for (int epoch = 0; epoch < maxEpochs; epoch++) {
            for (IrisDatasetRecord record : trainingData) {
                updateTarget(record.getLabel());
                trainSample(record.getNormPixels());
            }
        }
    }

    public int classify(double[] normPixels) {
        double weightedSum = bias + sumWeights(normPixels);
        return stepFunction(weightedSum);
    }

    private void trainSample(double[] normPixels) {
        output = bias + sumWeights(normPixels);
        int prediction = stepFunction(output);
        int error = target - prediction;
        for (int i = 0; i < weights.length; i++) {
            weights[i] += error * normPixels[i];
        }
        bias += error;
    }

    private void updateTarget(int recordLabel) {
        if (recordLabel == 0) {
            target = 0;
        }
        else if (recordLabel == 1) {
            target = 1;
        }
    }

    private double sumWeights(double[] normPixels) {
        double sum = 0;
        for (int i = 0; i < normPixels.length; i++) {
            sum += normPixels[i] * weights[i];
        }
        return sum;
    }

    private int stepFunction(double output) {
        if (output > 0) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
