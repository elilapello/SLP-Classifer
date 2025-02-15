import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            // load train and test data
            ArrayList<IrisDatasetRecord> trainData = loadDataset("resources/mnist_train.csv");
            ArrayList<IrisDatasetRecord> testData = loadDataset("resources/mnist_test.csv");

            // create a new perceptron
            Perceptron perceptron = new Perceptron(trainData);

            // train perceptron for 100 epochs
            perceptron.trainPerceptron(100);

            // classify test data
            int[] testResults = new int[testData.size()];
            for (int i = 0; i < testData.size(); i++) {
                IrisDatasetRecord record = testData.get(i);
                int result = perceptron.classify(record.getNormPixels());
                int success = -1;

                if (result == record.getLabel()) {
                    success = 1;
                }
                testResults[i] = success;
            }

            // find percentage classified correctly
            int sumIncorrect = 0;
            for (int test : testResults) {
                if (test == -1) {
                    sumIncorrect++;
                }
            }
            double percentCorrect = 100 - (((double) sumIncorrect / testResults.length) * 100);

            // print percentage
            System.out.print("Percent classified correctly: ");
            System.out.format("%.2f\n", percentCorrect);











        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<IrisDatasetRecord> loadDataset(String fileName) {
        ArrayList<IrisDatasetRecord> dataset = new ArrayList<>();

        // CSV reader is configured to only load labels 0 and 1
        CSVReader csv = new CSVReader(fileName);
        ArrayList<String> data = csv.getData();

        for (String record : data) {
            dataset.add(new IrisDatasetRecord(record));
        }
        return dataset;
    }
}