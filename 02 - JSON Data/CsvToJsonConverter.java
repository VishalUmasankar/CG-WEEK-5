import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class CsvToJsonConverter {
    public static void main(String[] args) throws Exception {
        CSVReader reader = new CSVReader(new FileReader("data.csv"));
        List<String[]> rows = reader.readAll();

        String[] headers = rows.get(0);
        List<Map<String, String>> data = new ArrayList<>();

        for (int i = 1; i < rows.size(); i++) {
            Map<String, String> obj = new LinkedHashMap<>();
            for (int j = 0; j < headers.length; j++) {
                obj.put(headers[j], rows.get(i)[j]);
            }
            data.add(obj);
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new FileWriter("output.json"), data);
    }
}
