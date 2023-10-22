package com.kamal.binarytreemanager.util;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Utility class for handling user input.
 */
public class InputUtil {
    private static final String INVALID_INPUT_MESSAGE = "Invalid input. Please try again.";

    /**
     * Get an integer input from the user.
     *
     * @param scanner The Scanner object for input.
     * @param prompt  The message to prompt the user for input.
     * @return The integer input provided by the user.
     */
    public static int getIntInput(final Scanner scanner, final String prompt) {
        int userInput = -1;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(prompt);
                userInput = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println(INVALID_INPUT_MESSAGE);
                scanner.nextLine(); // Consume the newline character
            }
        }

        return userInput;
    }
}
