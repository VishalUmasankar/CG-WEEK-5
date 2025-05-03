public class ExampleClass {
    private String name;
    public int age;

    public ExampleClass() {}

    public ExampleClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void greet() {
        System.out.println("Hello, " + name);
    }

    private int calculateYearOfBirth(int currentYear) {
        return currentYear - age;
    }
}
