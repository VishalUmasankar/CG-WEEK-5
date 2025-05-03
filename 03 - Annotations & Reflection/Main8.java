import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

class Engine {
    public void start() {
        System.out.println("Engine started.");
    }
}

class Car {
    @Inject
    private Engine engine;

    public void drive() {
        engine.start();
        System.out.println("Car is driving.");
    }
}

class DIContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    public <T> T getInstance(Class<T> clazz) throws Exception {
        if (instances.containsKey(clazz)) {
            return (T) instances.get(clazz);
        }

        T instance = clazz.getDeclaredConstructor().newInstance();
        instances.put(clazz, instance);

        injectDependencies(instance);
        return instance;
    }

    private void injectDependencies(Object instance) throws Exception {
        Field[] fields = instance.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object dependency = getInstance(field.getType());
                field.set(instance, dependency);
            }
        }
    }
}

public class Main8 {
    public static void main(String[] args) {
        try {
            DIContainer diContainer = new DIContainer();
            Car car = diContainer.getInstance(Car.class);
            car.drive();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
