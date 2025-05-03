import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ValidateContactsCSV {
    public static void main(String[] args) {
        String filePath = "Contacts.csv";

        // Regex patterns for email and phone
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^\\d{10}$";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String header = reader.readLine(); // Skip header row
            String line;
            int rowNumber = 1;

            while ((line = reader.readLine()) != null) {
                rowNumber++;
                String[] fields = line.split(",");

                if (fields.length >= 4) {
                    String email = fields[2].trim();
                    String phone = fields[3].trim();

                    Matcher emailMatcher = emailPattern.matcher(email);
                    Matcher phoneMatcher = phonePattern.matcher(phone);

                    boolean valid = true;

                    if (!emailMatcher.matches()) {
                        System.out.println("Row " + rowNumber + " - Invalid email: " + email);
                        valid = false;
                    }

                    if (!phoneMatcher.matches()) {
                        System.out.println("Row " + rowNumber + " - Invalid phone number: " + phone);
                        valid = false;
                    }

                    if (valid) {
                        System.out.println("Row " + rowNumber + " - Valid");
                    }
                } else {
                    System.out.println("Row " + rowNumber + " - Incomplete data: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();
        }
    }
}
