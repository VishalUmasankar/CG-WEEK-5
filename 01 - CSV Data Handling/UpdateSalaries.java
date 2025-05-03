import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class UpdateSalaries {
    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputFile = "updated_employees.csv";

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line = reader.readLine();
            writer.write(line);
            writer.newLine();

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 4) {
                    String department = fields[2].trim();
                    double salary = Double.parseDouble(fields[3].trim());
                    if (department.equalsIgnoreCase("IT")) {
                        salary = salary * 1.10;
                        fields[3] = String.format("%.2f", salary);
                    }
                    String updatedLine = String.join(",", fields);
                    writer.write(updatedLine);
                    writer.newLine();
                }
            }

            System.out.println("Updated salaries written to: " + outputFile);

        } catch (IOException e) {
            System.out.println("Error processing the file.");
            e.printStackTrace();
        }
    }
}
