import java.lang.reflect.Method;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class InvokePrivateMethod {
    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        Class<?> clazz = calc.getClass();

        Method method = clazz.getDeclaredMethod("multiply", int.class, int.class);
        method.setAccessible(true);

        Object result = method.invoke(calc, 6, 7);
        System.out.println("Result = " + result);
    }
}
