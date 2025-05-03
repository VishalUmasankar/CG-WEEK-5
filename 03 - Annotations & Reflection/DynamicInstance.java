class Student {
    String name;
    int age;

    public Student() {
        this.name = "Ruchi";
        this.age = 18;
    }

    public String toString() {
        return "Student {name = '" + name + "', age = " + age + "}";
    }
}

public class DynamicInstance {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("Student");
        Object obj = clazz.getDeclaredConstructor().newInstance();
        System.out.println(obj);
    }
}
