import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "DEFAULT_KEY";
}

public class StaticFieldModifier {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Configuration.class;
        Field field = clazz.getDeclaredField("API_KEY");
        field.setAccessible(true);
        field.set(null, "NEW_KEY");
        String modifiedKey = (String) field.get(null);
        System.out.println(modifiedKey);
    }
}
