import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVtoStudentObject {
    public static void main(String[] args) {
        String filePath = "students.csv";  // Make sure the file exists
        List<Student> studentList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 4) {
                    int id = Integer.parseInt(fields[0].trim());
                    String name = fields[1].trim();
                    int age = Integer.parseInt(fields[2].trim());
                    int marks = Integer.parseInt(fields[3].trim());

                    Student student = new Student(id, name, age, marks);
                    studentList.add(student);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the CSV file.");
            e.printStackTrace();
        }
        for (Student s : studentList) {
            System.out.println(s);
        }
    }
}
