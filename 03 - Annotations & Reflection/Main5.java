import java.lang.reflect.Field;
import java.util.Map;

class CustomMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T instance = clazz.getDeclaredConstructor().newInstance();
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            try {
                Field field = clazz.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(instance, entry.getValue());
            } catch (NoSuchFieldException ignored) {
            }
        }
        return instance;
    }
}

class User3 {
    private String name;
    private int age;

    public String toString() {
        return "User {name = '" + name + "', age = " + age + "}";
    }
}

public class Main5 {
    public static void main(String[] args) throws Exception {
        Map<String, Object> data = Map.of("name", "Ruchi", "age", 22);
        User3 user = CustomMapper.toObject(User3.class, data);
        System.out.println(user);
    }
}
