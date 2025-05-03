import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchEmployeeByName {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter employee name to search: ");
        String searchName = sc.nextLine().trim().toLowerCase();

        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                if (fields.length >= 4) {
                    String name = fields[1].trim().toLowerCase();

                    if (name.equals(searchName)) {
                        String department = fields[2].trim();
                        String salary = fields[3].trim();
                        System.out.println("Department: " + department);
                        System.out.println("Salary: " + salary);
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();
        }

        sc.close();
    }
}
