import java.lang.reflect.Method;

public class TaskInfoReader {
    public static void main(String[] args) throws Exception {
        Method method = TaskManager.class.getMethod("completePaymentTask");
        if (method.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo info = method.getAnnotation(TaskInfo.class);
            System.out.println("Priority: " + info.priority());
            System.out.println("Assigned To: " + info.assignedTo());
        }
    }
}
