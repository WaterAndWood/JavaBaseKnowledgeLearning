package annotations;

public class PasswordUtils {
    @UseCase(id = 47, description = "Password must contain on numeric")
    public boolean validatePassword(String password) {
        return password.matches("\\w*\\d\\w*");
    }
}
