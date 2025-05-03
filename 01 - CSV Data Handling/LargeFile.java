import java.io.*;

public class LargeFile {
    public static void main(String[] args) {
        String filePath = "deliveries.csv";  // Your large CSV file
        int batchSize = 100;
        int totalLinesProcessed = 0;
        int lineCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read header and display
            String header = br.readLine();
            if (header != null) {
                System.out.println("Header: " + header);
            }

            // Start reading the data
            while ((line = br.readLine()) != null) {
                // Split columns
                String[] parts = line.split(",");

                // Example columns: Adjust indices based on actual file
                String matchId = parts[0];
                String over = parts[1];
                String ball = parts[2];
                String batsman = parts[3];
                String bowler = parts[4];
                String runs = parts[5];
                String wicket = parts[6];

                // Process line here (you can customize this part)
                // For now, we just count the records
                lineCount++;
                totalLinesProcessed++;

                if (lineCount == batchSize) {
                    System.out.println("Processed " + totalLinesProcessed + " deliveries...");
                    lineCount = 0;
                }
            }

            if (lineCount > 0) {
                System.out.println("Processed " + totalLinesProcessed + " deliveries...");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
