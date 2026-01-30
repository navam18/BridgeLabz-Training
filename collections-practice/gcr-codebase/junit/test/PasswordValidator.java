package src.test.java;

import org.junit.jupiter.api.Test;
import src.main.java.org.example.PasswordValidator;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValid("Strong123"));
    }

    @Test
    void testInvalidPassword_NoUppercase() {
        assertFalse(PasswordValidator.isValid("weak1234"));
    }

    @Test
    void testInvalidPassword_NoDigit() {
        assertFalse(PasswordValidator.isValid("WeakPass"));
    }

    @Test
    void testInvalidPassword_TooShort() {
        assertFalse(PasswordValidator.isValid("A1bc"));
    }
}