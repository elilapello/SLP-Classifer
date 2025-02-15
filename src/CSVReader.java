import java.io.*;
import java.util.ArrayList;

public class CSVReader {

    private final String csvFileName;
    private ArrayList<String> fileData;

    public CSVReader(String fileName) {
        this.csvFileName = fileName;
        this.fileData = new ArrayList<>();
        readData();
    }

    private void readData() {
        File csvFile = new File(csvFileName);
        if (!csvFile.exists()) {
            System.out.println("File does not exist");
        }

        // only read mnist handwritten numbers 0 and 1
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while(br.ready()) {
                line = br.readLine();
                if (line.charAt(0) == '1' || line.charAt(0) == '0') {
                    fileData.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(String.format("CSVReader.readData(): file %s not found.", csvFile));
        } catch (IOException e) {
            throw new RuntimeException("CSVReader.readData(): I/O exception.");
        }
    }

    public ArrayList<String> getData() {
        return fileData;
    }
}
