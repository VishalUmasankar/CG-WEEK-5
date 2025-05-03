import java.lang.reflect.Field;

public class User {

    @MaxLength(10)
    private String username;

    public User(String username) {
        this.username = username;

        validateMaxLength();
    }

    private void validateMaxLength() {
        try {
            Field field = this.getClass().getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength annotation = field.getAnnotation(MaxLength.class);
                int maxLength = annotation.value();
                if (username.length() > maxLength) {
                    throw new IllegalArgumentException("Username length exceeds the maximum allowed length of " + maxLength + " characters.");
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}
