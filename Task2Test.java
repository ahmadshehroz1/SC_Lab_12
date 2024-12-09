import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task2Test {

    @Test
    public void testAdditionAndMultiplication() {
        try {
            assertEquals(13.0, Task2.evaluate("3 + 5 * 2"));
        } catch (Exception e) {
            fail("Exception should not occur");
        }
    }

    @Test
    public void testParentheses() {
        try {
            assertEquals(40.0, Task2.evaluate("(3 + 5) * (2 + 3)"));
        } catch (Exception e) {
            fail("Exception should not occur");
        }
    }

    @Test
    public void testDivisionByZero() {
        try {
        	Task2.evaluate("100 / 0");
            fail("Expected ArithmeticException for division by zero.");
        } catch (ArithmeticException e) {
            assertEquals("Division by zero is not allowed.", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testFloatingPoint() {
        try {
            assertEquals(11.9, Task2.evaluate("3.5 + 4.2 * 2"), 0.0001);
        } catch (Exception e) {
            fail("Exception should not occur");
        }
    }

    @Test
    public void testInvalidExpression() {
        try {
        	Task2.evaluate("3 + * 5");
            fail("Expected Exception for invalid syntax.");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Invalid"));
        }
    }

    @Test
    public void testUnaryMinus() {
        try {
            assertEquals(7.0, Task2.evaluate("-3 + 5 * 2"));
        } catch (Exception e) {
            fail("Exception should not occur");
        }
    }
    
    @Test
    public void testNegativeResult() {
        String expression = "3 + 5 - 10";
        try {
            double result = Task2.evaluate(expression);
            assertEquals(-2.0, result, 0.0001);
        } catch (Exception e) {
            fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
