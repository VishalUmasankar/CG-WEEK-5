import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountCSVRecords {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        int recordCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    recordCount++;
                }
            }

            System.out.println("Number of employee records (excluding header): " + recordCount);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
