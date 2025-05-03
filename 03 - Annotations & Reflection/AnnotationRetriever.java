import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

@Author(name = "Ruchi Shah")
class MyClass {
}

public class AnnotationRetriever {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("MyClass");
        if (clazz.isAnnotationPresent(Author.class)) {
            Author author = clazz.getAnnotation(Author.class);
            System.out.println(author.name());
        }
    }
}
