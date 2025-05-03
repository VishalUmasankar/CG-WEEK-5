import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

public class EncryptDecryptCSV {

    private static SecretKeySpec secretKey;

    public static void setKey(String myKey) {
        byte[] key = myKey.getBytes();
        secretKey = new SecretKeySpec(key, "AES");
    }

    public static String encrypt(String strToEncrypt) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String strToDecrypt) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void encryptCsvData(String inputCsvFile, String outputCsvFile, String encryptionKey) {
        setKey(encryptionKey);  // Set the key for encryption

        try (BufferedReader reader = new BufferedReader(new FileReader(inputCsvFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputCsvFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                // Encrypt sensitive fields (Email and Salary)
                String encryptedEmail = encrypt(fields[2]);  // Email field
                String encryptedSalary = encrypt(fields[3]);  // Salary field

                // Write the modified (encrypted) fields to the output CSV file
                writer.write(fields[0] + "," + fields[1] + "," + encryptedEmail + "," + encryptedSalary);
                writer.newLine();
            }
            System.out.println("Data encrypted and written to: " + outputCsvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Convert data from encrypted CSV to decrypted data
    public static void decryptCsvData(String inputCsvFile, String outputCsvFile, String encryptionKey) {
        setKey(encryptionKey);  // Set the key for decryption

        try (BufferedReader reader = new BufferedReader(new FileReader(inputCsvFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputCsvFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                // Decrypt sensitive fields (Email and Salary)
                String decryptedEmail = decrypt(fields[2]);  // Encrypted Email field
                String decryptedSalary = decrypt(fields[3]);  // Encrypted Salary field

                // Write the modified (decrypted) fields to the output CSV file
                writer.write(fields[0] + "," + fields[1] + "," + decryptedEmail + "," + decryptedSalary);
                writer.newLine();
            }
            System.out.println("Data decrypted and written to: " + outputCsvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String encryptionKey = "1234567890123456";  // 16-byte key for AES encryption (128 bits)

        String inputCsvFile = "employees.csv";
        String encryptedCsvFile = "employees_encrypted.csv";
        String decryptedCsvFile = "employees_decrypted.csv";

        // Encrypt the data and write to a new CSV file
        encryptCsvData(inputCsvFile, encryptedCsvFile, encryptionKey);

        // Decrypt the encrypted CSV data and write to another file
        decryptCsvData(encryptedCsvFile, decryptedCsvFile, encryptionKey);
    }
}
