import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {

    public static void main(String[] args) {
        String filePath = "students.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                if (fields.length == 4) {
                    String id = fields[0].trim();
                    String name = fields[1].trim();
                    String age = fields[2].trim();
                    String marks = fields[3].trim();

                    System.out.println("Student ID: " + id);
                    System.out.println("Name      : " + name);
                    System.out.println("Age       : " + age);
                    System.out.println("Marks     : " + marks);
                    System.out.println("---------------------------");
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
