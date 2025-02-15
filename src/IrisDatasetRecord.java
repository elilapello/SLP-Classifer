import java.util.Arrays;

public class IrisDatasetRecord {
    private final int label;
    private int[] pixels;
    private double[] normPixels;

    public IrisDatasetRecord(String record) {
        pixels = new int[784]; //iris dataset record has a length of 785 *INCLUDING* label so size is 784
        normPixels = new double[pixels.length];

        String[] recordValues = record.split(",");
        if (recordValues.length != 785) {
            throw new IllegalArgumentException("IrisDatasetRecord: record must be of length 785.");
        }

        this.label = Integer.parseInt(recordValues[0]);
        for (int i = 1; i < recordValues.length; i++) {
            this.pixels[i - 1] = Integer.parseInt(recordValues[i]);
        }

        normalizePixels();
    }

    private void normalizePixels() {
        for (int i = 0; i < 784; i++) {
            normPixels[i] = (double) pixels[i] / 255;
        }
    }

    public int getLabel() {
        return label;
    }

    public int[] getPixels() {
        return pixels;
    }

    public double[] getNormPixels() {
        return normPixels;
    }

    @Override
    public String toString() {
        return "Label: " + this.label + '\n'
                + "Normalized pixels: " + Arrays.toString(this.normPixels);
    }
}
