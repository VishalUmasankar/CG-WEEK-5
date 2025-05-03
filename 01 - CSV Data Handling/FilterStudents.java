import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterStudents {
    public static void main(String[] args) {
        String filePath = "students.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String header = reader.readLine();
            System.out.println(header);
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                if (fields.length >= 4) {
                    String name = fields[1];
                    int marks = Integer.parseInt(fields[3]); // Marks is the 4th field

                    if (marks > 80) {
                        System.out.println(line); // Print full record
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in marks field.");
            e.printStackTrace();
        }
    }
}
