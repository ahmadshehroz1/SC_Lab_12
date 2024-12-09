import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task3Test {

    @Test
    public void testSumOfDigitsPositive() {
        // Testing with a positive number
        assertEquals(10, Task3.sumOfDigits(1234));  // 1 + 2 + 3 + 4 = 10
    }

    @Test
    public void testSumOfDigitsZero() {
        // Testing with zero
        assertEquals(0, Task3.sumOfDigits(0));  // Sum of digits of 0 is 0
    }

    @Test
    public void testSumOfDigitsNegative() {
        // Testing with a negative number
        assertEquals(30, Task3.sumOfDigits(-9876));  // 9 + 8 + 7 + 6 = 30
    }

    @Test
    public void testSumOfDigitsLargeNumber() {
        // Testing with a large number
        assertEquals(45, Task3.sumOfDigits(1234567890));  // 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 0 = 45
    }

    @Test
    public void testSumOfDigitsSingleDigit() {
        // Testing with a single digit number
        assertEquals(7, Task3.sumOfDigits(7));  // Sum of digits of 7 is 7
    }

    @Test
    public void testSumOfDigitsLargeNegativeNumber() {
        // Testing with a large negative number
        assertEquals(45, Task3.sumOfDigits(-1234567890));  // 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 0 = 45
    }

    @Test
    public void testSumOfDigitsBigNumberWithZeros() {
        // Testing with a big number containing zeros
        assertEquals(6, Task3.sumOfDigits(100200300));  // 1 + 0 + 0 + 2 + 0 + 0 + 3 + 0 + 0 = 18
    }
}
