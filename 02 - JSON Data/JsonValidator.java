import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JsonValidator {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Student student = mapper.readValue(new File("data.json"), Student.class);
            System.out.println("Valid JSON structure.");
            System.out.println("Student: " + student.getName() + ", Age: " + student.getAge());
        } catch (Exception e) {
            System.out.println("Invalid JSON structure: " + e.getMessage());
        }
    }
}
