import java.lang.reflect.Method;

public class LogExecutionTimeAspect {

    public static void logExecutionTime(Object obj, String methodName, Object... args) throws Exception {
        Method method = obj.getClass().getMethod(methodName, getParameterTypes(args));

        if (method.isAnnotationPresent(LogExecutionTime.class)) {
            long startTime = System.nanoTime();
            method.invoke(obj, args);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println("Execution time of " + methodName + " = " + duration + " nanoseconds");
        } else {
            method.invoke(obj, args);
        }
    }

    private static Class<?>[] getParameterTypes(Object[] args) {
        Class<?>[] parameterTypes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            parameterTypes[i] = args[i].getClass();
        }
        return parameterTypes;
    }
}
