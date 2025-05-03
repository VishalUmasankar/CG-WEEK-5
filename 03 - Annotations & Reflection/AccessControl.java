import java.lang.reflect.Method;

public class AccessControl {

    public static void checkAccess(Object obj, String userRole, String methodName) throws Exception {
        Method method = obj.getClass().getMethod(methodName);

        if (method.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
            String allowedRole = roleAllowed.value();

            if (!allowedRole.equals(userRole)) {
                System.out.println("Access Denied!");
                return;
            }
        }

        method.invoke(obj);
    }
}
