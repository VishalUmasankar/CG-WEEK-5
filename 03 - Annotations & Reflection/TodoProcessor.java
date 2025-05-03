import java.lang.reflect.Method;

public class TodoProcessor {

    public static void main(String[] args) throws Exception {
        Method[] methods = Project.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Method = " + method.getName() + ", Task = " + todo.task() + ", Assigned To = " + todo.assignedTo() + ", Priority = " + todo.priority());
            }
        }
    }
}
