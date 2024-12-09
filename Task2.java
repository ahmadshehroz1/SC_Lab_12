import java.util.*;

public class Task2 {

    // Main function to evaluate the expression
    public static double evaluate(String expression) throws Exception {
        expression = expression.replaceAll("\\s+", ""); // Remove all spaces
        List<String> tokens = tokenize(expression);
        return evaluateExpression(tokens, new int[]{0});
    }

    // Tokenize the expression into a list of tokens
    private static List<String> tokenize(String expression) {
        List<String> tokens = new ArrayList<>();
        StringBuilder currentToken = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // If the character is an operator or parenthesis, save the current token and reset
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')') {
                if (currentToken.length() > 0) {
                    tokens.add(currentToken.toString());
                    currentToken.setLength(0);
                }
                tokens.add(String.valueOf(c));
            } else if (Character.isDigit(c) || c == '.') {
                currentToken.append(c);
            }
        }
        if (currentToken.length() > 0) {
            tokens.add(currentToken.toString());
        }
        return tokens;
    }

    // Recursive function to evaluate the expression
    private static double evaluateExpression(List<String> tokens, int[] index) throws Exception {
        // Parse the first term (multiplication/division level)
        double result = parseTerm(tokens, index);

        // Now handle addition/subtraction (left to right)
        while (index[0] < tokens.size()) {
            String token = tokens.get(index[0]);
            if (token.equals("+")) {
                index[0]++;
                result += parseTerm(tokens, index);
            } else if (token.equals("-")) {
                index[0]++;
                result -= parseTerm(tokens, index);
            } else {
                // End of expression or invalid operator
                break;
            }
        }
        return result;
    }

    // Function to parse a term (multiplication/division level)
    private static double parseTerm(List<String> tokens, int[] index) throws Exception {
        double result = parseFactor(tokens, index);

        // Now handle multiplication/division (left to right)
        while (index[0] < tokens.size()) {
            String token = tokens.get(index[0]);
            if (token.equals("*")) {
                index[0]++;
                result *= parseFactor(tokens, index);
            } else if (token.equals("/")) {
                index[0]++;
                double divisor = parseFactor(tokens, index);
                if (divisor == 0) {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                result /= divisor;
            } else {
                // End of term or invalid operator
                break;
            }
        }
        return result;
    }

    // Function to parse factors (numbers or expressions in parentheses)
    private static double parseFactor(List<String> tokens, int[] index) throws Exception {
        if (index[0] >= tokens.size()) {
            throw new Exception("Unexpected end of input.");
        }

        String token = tokens.get(index[0]);

        if (token.equals("(")) {
            // If the token is an opening parenthesis, evaluate the sub-expression
            index[0]++;
            double result = evaluateExpression(tokens, index);
            if (index[0] >= tokens.size() || !tokens.get(index[0]).equals(")")) {
                throw new Exception("Mismatched parentheses.");
            }
            index[0]++; // Skip the closing parenthesis
            return result;
        } else if (token.equals("-") || token.equals("+")) {
            // Handle unary plus or minus
            index[0]++;
            return token.equals("-") ? -parseNumber(tokens, index) : parseNumber(tokens, index);
        } else {
            // Otherwise, it must be a number
            return parseNumber(tokens, index);
        }
    }

    // Parse a number (could be integer or floating point)
    private static double parseNumber(List<String> tokens, int[] index) throws Exception {
        if (index[0] >= tokens.size()) {
            throw new Exception("Invalid number format.");
        }

        String token = tokens.get(index[0]);
        try {
            index[0]++;
            return Double.parseDouble(token);
        } catch (NumberFormatException e) {
            throw new Exception("Invalid number format: " + token);
        }
    }

    public static void main(String[] args) {
        // Test expressions
        String[] expressions = {
            "3 + 5 * 2", // normal case
            "10 / 2 + 3", // division and addition
            "3 + (2 * 4) - 5", // parentheses
            "(3 + 5) * (2 + 3)", // parentheses
            "3.5 + 4.2 * 2", // floating point
            "-3 + 5 * 2", // unary minus
            "100 / 0", // division by zero
            "(3 + 5", // mismatched parentheses
            "3 + * 5" // invalid expression
        };

        for (String expression : expressions) {
            try {
                System.out.println(expression + " = " + evaluate(expression));
            } catch (Exception e) {
                System.out.println("Error evaluating expression '" + expression + "': " + e.getMessage());
            }
        }
    }
}
