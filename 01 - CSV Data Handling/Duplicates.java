import java.io.*;
import java.util.*;

public class Duplicates {
    public static void main(String[] args) {
        String filePath = "Student3.csv";
        Set<String> seenIds = new HashSet<>();
        List<String> duplicates = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read header
            String header = br.readLine();
            System.out.println("Header: " + header);

            // Process lines
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length > 0) {
                    String id = parts[0];

                    // Check for duplicates
                    if (seenIds.contains(id)) {
                        duplicates.add(line);
                    } else {
                        seenIds.add(id);
                    }
                }
            }

            // Print results
            if (duplicates.isEmpty()) {
                System.out.println("No duplicate IDs found.");
            } else {
                System.out.println("Duplicate records based on ID:");
                for (String dup : duplicates) {
                    System.out.println(dup);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
