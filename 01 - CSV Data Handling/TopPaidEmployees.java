import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TopPaidEmployees {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        List<String[]> employeeList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String header = reader.readLine(); // Store header
            String line;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 4) {
                    employeeList.add(fields);
                }
            }

            // Sort by Salary (index 3) in descending order
            employeeList.sort((a, b) -> {
                double salaryA = Double.parseDouble(a[3].trim());
                double salaryB = Double.parseDouble(b[3].trim());
                return Double.compare(salaryB, salaryA); // Descending
            });

            System.out.println(header);

            for (int i = 0; i < Math.min(5, employeeList.size()); i++) {
                String[] emp = employeeList.get(i);
                System.out.println(String.join(",", emp));
            }

        } catch (IOException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid salary format.");
            e.printStackTrace();
        }
    }
}
