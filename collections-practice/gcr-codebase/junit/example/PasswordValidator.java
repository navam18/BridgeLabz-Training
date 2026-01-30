package junit.example;

public class PasswordValidator {

    public static boolean isValid(String password) {
        if (password == null || password.length() < 8) return false;

        boolean hasUppercase = password.matches(".*[A-Z].*");
        boolean hasDigit = password.matches(".*\\d.*");

        return hasUppercase && hasDigit;
    }
}