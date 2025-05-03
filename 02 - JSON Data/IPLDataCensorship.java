import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.*;

class Match {
    public int match_id;
    public String team1;
    public String team2;
    public Map<String, Integer> score;
    public String winner;
    public String player_of_match;
}

public class IPLDataCensorship {

    public static void main(String[] args) {
        try {
            processJson("ipl.json", "ipl_censored.json");
        } catch (IOException e) {
            System.err.println("Error processing JSON: " + e.getMessage());
            e.printStackTrace();
        }

        processCsv("ipl.csv", "ipl_censored.csv");
    }

    static void processJson(String inputPath, String outputPath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Match> matches = mapper.readValue(new File(inputPath), new TypeReference<List<Match>>() {});

        for (Match match : matches) {
            match.team1 = censorTeamName(match.team1);
            match.team2 = censorTeamName(match.team2);
            match.winner = censorTeamName(match.winner);
            match.player_of_match = "REDACTED";

            Map<String, Integer> newScore = new LinkedHashMap<>();
            for (Map.Entry<String, Integer> entry : match.score.entrySet()) {
                newScore.put(censorTeamName(entry.getKey()), entry.getValue());
            }
            match.score = newScore;
        }

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputPath), matches);
    }

    static void processCsv(String inputPath, String outputPath) {
        try (
                CSVReader reader = new CSVReader(new FileReader(inputPath));
                CSVWriter writer = new CSVWriter(new FileWriter(outputPath))
        ) {
            String[] header = reader.readNext();
            writer.writeNext(header);

            String[] line;
            while ((line = reader.readNext()) != null) {
                line[1] = censorTeamName(line[1]); // team1
                line[2] = censorTeamName(line[2]); // team2
                line[5] = censorTeamName(line[5]); // winner
                line[6] = "REDACTED";              // player_of_match
                writer.writeNext(line);
            }

            System.out.println("Censored CSV written to " + outputPath);
        } catch (IOException | CsvValidationException e) {
            System.err.println("Error processing CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }

    static String censorTeamName(String teamName) {
        int index = teamName.indexOf(" ");
        return (index != -1) ? teamName.substring(0, index) + " ***" : "***";
    }
}
