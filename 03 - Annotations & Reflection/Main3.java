public class Main3 {

    public static void main(String[] args) throws IllegalAccessException {
        User2 user = new User2("Ruchi Shah", 22, "ruchishah@example.com");

        String jsonString = JsonSerializer.toJson(user);

        System.out.println(jsonString);
    }
}
