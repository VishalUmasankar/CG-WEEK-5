import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";

        Map<String, String[]> studentDetails = new HashMap<>();

        try (
                BufferedReader br1 = new BufferedReader(new FileReader(file1));
                BufferedReader br2 = new BufferedReader(new FileReader(file2));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;

            br1.readLine();
            while ((line = br1.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    studentDetails.put(parts[0], new String[] { parts[1], parts[2] });
                }
            }

            writer.write("ID,Name,Age,Marks,Grade");
            writer.newLine();

            br2.readLine();
            while ((line = br2.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String id = parts[0];
                    String marks = parts[1];
                    String grade = parts[2];

                    String[] details = studentDetails.get(id);
                    if (details != null) {
                        writer.write(id + "," + details[0] + "," + details[1] + "," + marks + "," + grade);
                        writer.newLine();
                    }
                }
            }

            System.out.println("Merged CSV created: " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
