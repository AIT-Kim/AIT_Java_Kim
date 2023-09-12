package lesson_07;
/**
 * 12.09.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */

import java.util.*;

public class HomeWork07 {
    private static ResourceBundle messages;

    /**
     * Task 0: Ask the user to input a number: 1, 2, or 3 and print which number the user entered.
     */
    public static void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(messages.getString("enterNumber"));
        String input = scanner.nextLine();

        switch (input) {
            case "1":
            case "2":
            case "3":
                System.out.println(messages.getString("youEntered") + input);
                break;
            default:
                System.out.println(messages.getString("not123"));
        }
    }

    /**
     * Task 1: Generate 4 random numbers between 0 and 100, print them and determine the maximum number.
     */
    public static void randomNumbers() {
        Random random = new Random();

        // Generate 4 random numbers
        int num1 = random.nextInt(101);
        int num2 = random.nextInt(101);
        int num3 = random.nextInt(101);
        int num4 = random.nextInt(101);

        // Print generated numbers
        System.out.println(messages.getString("randomNumbers") + num1 + ", " + num2 + ", " + num3 + ", " + num4);

        // Determine and print the maximum number
        int max = Math.max(Math.max(num1, num2), Math.max(num3, num4));
        System.out.println(messages.getString("maxNumber") + max);
    }

    /**
     * Task 2: Ask the user to enter a four-digit number and determine if it is a "lucky ticket".
     * A lucky ticket is a number where the sum of the first two digits is equal to the sum of the last two digits.
     */
    public static void checkLuckyTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(messages.getString("enterFourDigit"));
        String input = scanner.nextLine();

        // Check if input is not a 4-digit number
        if (input.length() != 4) {
            System.out.println(messages.getString("notFourDigit"));
            return;
        }

        // Calculate the sums of the first and last two digits
        int firstHalf = Character.getNumericValue(input.charAt(0)) + Character.getNumericValue(input.charAt(1));
        int secondHalf = Character.getNumericValue(input.charAt(2)) + Character.getNumericValue(input.charAt(3));

        // Check if it is a lucky ticket and print the result
        if (firstHalf == secondHalf) {
            System.out.println(messages.getString("lucky"));
        } else {
            System.out.println(messages.getString("notLucky"));
        }
    }

    // Main method to run all tasks
    public static void main(String[] args) {
        // Detect the default system locale
        Locale currentLocale = Locale.getDefault();
        // Load the appropriate language strings based on the system locale
        messages = ResourceBundle.getBundle("lesson_07.messages.Messages", currentLocale);

        // Execute tasks sequentially
        getUserInput();
        randomNumbers();
        checkLuckyTicket();
    }
}