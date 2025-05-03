import java.lang.reflect.Field;

class JsonConverter {
    public static String toJson(Object object) throws IllegalAccessException {
        StringBuilder json = new StringBuilder("{");
        Field[] fields = object.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            json.append("\"")
                    .append(fields[i].getName())
                    .append("\": \"")
                    .append(fields[i].get(object))
                    .append("\"");
            if (i < fields.length - 1) {
                json.append(", ");
            }
        }

        json.append("}");
        return json.toString();
    }
}

class Person2 {
    private String name;
    private int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Main6 {
    public static void main(String[] args) throws IllegalAccessException {
        Person2 person = new Person2("Ruchi", 22);
        String json = JsonConverter.toJson(person);
        System.out.println(json);
    }
}
