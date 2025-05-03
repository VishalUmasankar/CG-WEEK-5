import java.lang.reflect.Field;

class Person {
    private int age = 22;
}

public class AccessPrivateField {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Class<?> clazz = person.getClass();

        Field ageField = clazz.getDeclaredField("age");
        ageField.setAccessible(true);

        int originalAge = (int) ageField.get(person);
        System.out.println("Original Age = " + originalAge);

        ageField.set(person, 25);

        int updatedAge = (int) ageField.get(person);
        System.out.println("Updated Age = " + updatedAge);
    }
}
