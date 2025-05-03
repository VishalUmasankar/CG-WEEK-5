import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;

public class MergeJsonFiles {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode json1 = objectMapper.readTree(new File("file1.json"));
        JsonNode json2 = objectMapper.readTree(new File("file2.json"));
        JsonNode mergedJson = json1.deepCopy();
        if (json1.isObject() && json2.isObject()) {
            ((ObjectNode) mergedJson).setAll((ObjectNode) json2);
        }
        System.out.println("Merged JSON: " + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedJson));
        objectMapper.writeValue(new File("merged.json"), mergedJson);
    }
}
