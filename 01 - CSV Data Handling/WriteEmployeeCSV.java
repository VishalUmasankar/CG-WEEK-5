import java.io.FileWriter;
import java.io.IOException;

public class WriteEmployeeCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        String header = "ID,Name,Department,Salary\n";
        String[] records = {
                "101,John Doe,Engineering,75000",
                "102,Jane Smith,Marketing,68000",
                "103,David Brown,Finance,72000",
                "104,Lisa Johnson,HR,65000",
                "105,Michael Lee,IT,79000"
        };

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(header);
            for (String record : records) {
                writer.write(record + "\n");
            }

            System.out.println("CSV file created successfully: " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
