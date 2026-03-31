package src.test.java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {

    @Test
    void testValidUserRegistration() {
        assertDoesNotThrow(() ->
                UserRegistration.registerUser(
                        "divyansh",
                        "divyansh@gmail.com",
                        "secure123"));
    }

    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () ->
                UserRegistration.registerUser("", "test@gmail.com", "pass123"));
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () ->
                UserRegistration.registerUser("user", "invalid", "pass123"));
    }

    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () ->
                UserRegistration.registerUser("user", "test@gmail.com", "123"));
    }
}