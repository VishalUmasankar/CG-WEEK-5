public class TestAccessControl {

    public static void main(String[] args) throws Exception {
        AdminActions adminActions = new AdminActions();

        String adminRole = "ADMIN";
        String userRole = "USER";

        System.out.println("Admin trying to delete user:");
        AccessControl.checkAccess(adminActions, adminRole, "deleteUser");

        System.out.println("\nUser trying to delete user:");
        AccessControl.checkAccess(adminActions, userRole, "deleteUser");

        System.out.println("\nAdmin trying to view user:");
        AccessControl.checkAccess(adminActions, adminRole, "viewUser");
    }
}
