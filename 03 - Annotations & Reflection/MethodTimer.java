import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

class Sample {
    public void fast() {
        for (int i = 0; i < 1000; i++);
    }

    public void slow() {
        for (int i = 0; i < 1000000; i++);
    }
}

public class MethodTimer {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Sample.class;
        Object obj = clazz.getDeclaredConstructor().newInstance();

        for (Method method : clazz.getDeclaredMethods()) {
            if (!method.isSynthetic()) {
                long start = System.nanoTime();
                method.invoke(obj);
                long end = System.nanoTime();
                System.out.println(method.getName() + " took " + (end - start) + " ns");
            }
        }
    }
}
