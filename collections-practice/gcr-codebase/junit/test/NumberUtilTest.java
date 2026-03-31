package src.test.java;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import src.main.java.org.example.NumberUtils;

import static org.junit.jupiter.api.Assertions.*;
class NumberUtilsTest {


    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    void testIsEven_withEvenNumbers(int number) {
        assertTrue(NumberUtils.isEven(number));
    }


    @ParameterizedTest
    @ValueSource(ints = {7, 9})
    void testIsEven_withOddNumbers(int number) {
        assertFalse(NumberUtils.isEven(number));
    }
}