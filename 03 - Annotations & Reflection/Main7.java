import java.lang.reflect.*;

interface Greeting {
    void sayHello(String name);
}

class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

class LoggingHandler implements InvocationHandler {
    private final Object target;

    public LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Method " + method.getName() + " is being called");
        return method.invoke(target, args);
    }
}

public class Main7 {
    public static void main(String[] args) {
        Greeting greeting = new GreetingImpl();
        Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingHandler(greeting)
        );

        proxyInstance.sayHello("Ruchi");
    }
}
