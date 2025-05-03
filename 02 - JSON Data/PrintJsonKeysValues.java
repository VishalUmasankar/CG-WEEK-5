import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class PrintJsonKeysValues {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File("data3.json"));
        printJson("", root);
    }

    private static void printJson(String prefix, JsonNode node) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                printJson(prefix.isEmpty() ? entry.getKey() : prefix + "." + entry.getKey(), entry.getValue());
            }
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                printJson(prefix + "[" + i + "]", node.get(i));
            }
        } else {
            System.out.println(prefix + " : " + node.asText());
        }
    }
}
