public class TestMaxLength {

    public static void main(String[] args) {
        try {
            User user1 = new User("shortname");
            System.out.println("User1 created = " + user1.getUsername());

            User user2 = new User("thisUsernameIsTooLong");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
