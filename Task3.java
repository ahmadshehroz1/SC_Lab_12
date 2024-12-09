import java.util.Scanner;

public class Task3 {

    // Recursive function to calculate the sum of digits of a number
    public static int sumOfDigits(int number) {
        // Base case: If the number is 0, return 0
        if (number == 0) {
            return 0;
        }
        
        // Recursive case: Add the last digit (number % 10) to the result of the recursive call with the rest of the digits (number / 10)
        return Math.abs(number % 10) + sumOfDigits(number / 10); // Handling negative numbers using Math.abs
    }

    public static void main(String[] args) {
        // Input: Read a non-negative integer from the user
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        // Ensure the number is non-negative before calling sumOfDigits
        if (number < 0) {
            System.out.println("The number is negative. We will convert it to positive.");
            number = Math.abs(number);  // Convert to positive
        }
        
        // Call the recursive function and display the result
        int sum = sumOfDigits(number);
        System.out.println("The sum of digits of " + number + " is: " + sum);
        
        scanner.close();
    }
}
