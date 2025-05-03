public class AdminActions {

    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted successfully.");
    }

    @RoleAllowed("ADMIN")
    public void createUser() {
        System.out.println("User created successfully.");
    }

    public void viewUser() {
        System.out.println("Viewing user details.");
    }
}
