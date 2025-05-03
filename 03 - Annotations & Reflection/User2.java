public class User2 {

    @JsonField(name = "user_name")
    private String name;

    @JsonField(name = "user_age")
    private int age;

    @JsonField(name = "user_email")
    private String email;

    public User2(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
