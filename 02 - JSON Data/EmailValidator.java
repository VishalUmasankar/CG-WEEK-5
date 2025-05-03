import org.json.JSONObject;
import org.json.JSONTokener;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.everit.json.schema.ValidationException;

import java.io.FileReader;
import java.io.IOException;

public class EmailValidator {
    public static void main(String[] args) {
        try {
            FileReader jsonData = new FileReader("data4.json");
            JSONObject jsonObject = new JSONObject(new JSONTokener(jsonData));

            FileReader schemaData = new FileReader("email-schema.json");
            JSONObject jsonSchema = new JSONObject(new JSONTokener(schemaData));
            Schema schema = SchemaLoader.load(jsonSchema);

            schema.validate(jsonObject);
            System.out.println("JSON is valid.");

        } catch (ValidationException e) {
            System.out.println("Validation failed: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
