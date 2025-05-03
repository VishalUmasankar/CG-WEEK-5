import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class JsonSerializer {

    public static String toJson(Object obj) throws IllegalAccessException {
        Class<?> objClass = obj.getClass();
        Map<String, Object> jsonMap = new HashMap<>();

        for (Field field : objClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                String jsonKey = annotation.name();

                field.setAccessible(true);

                jsonMap.put(jsonKey, field.get(obj));
            }
        }

        StringBuilder jsonString = new StringBuilder("{");
        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
            jsonString.append("\"").append(entry.getKey()).append("\": \"").append(entry.getValue()).append("\", ");
        }

        if (jsonString.length() > 1) {
            jsonString.setLength(jsonString.length() - 2);
        }
        jsonString.append("}");

        return jsonString.toString();
    }
}
