package com.kamal.binarytreemanager.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test cases for the InputUtil class.
 */
public class InputUtilTest {
    private final InputUtil inputUtil = new InputUtil();
    private final Scanner scanner = mock(Scanner.class);

    // Variables to capture standard output
    private final InputStream originalIn = System.in;

    @BeforeEach
    public void setUp() {
        // Redirect System.in to a ByteArrayInputStream for simulating user input
        String simulatedInput = "123"; // Simulate user input
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
    }

    @Test
    public void testGetIntInputWithValidInput() {
        // Arrange
        when(scanner.nextInt()).thenReturn(123);

        // Act
        int result = inputUtil.getIntInput(scanner, "Enter an integer: ");

        // Assert
        assertEquals(123, result);
    }

    @Test
    public void testGetIntInputWithMultipleInvalidInputsFollowedByValidInput() {
        // Arrange
        when(scanner.nextInt())
                .thenThrow(new InputMismatchException()) // Invalid input
                .thenThrow(new InputMismatchException()) // Another invalid input
                .thenReturn(456); // Valid input

        // Act
        int result = inputUtil.getIntInput(scanner, "Enter an integer: ");

        // Assert
        assertEquals(456, result);
    }

    @Test
    public void testGetIntInputWithInvalidInputFollowedByValidInput() {
        // Arrange
        when(scanner.nextInt())
                .thenThrow(new InputMismatchException()) // Invalid input
                .thenReturn(789); // Valid input

        // Act
        int result = inputUtil.getIntInput(scanner, "Enter an integer: ");

        // Assert
        assertEquals(789, result);
    }

    @Test
    public void testGetIntInputWithSimulatedSystemIn() {
        // Arrange
        // Reset the System.in to the original value
        System.setIn(originalIn);

        // Simulate user input
        String simulatedInput = "abc\n123\n"; // Invalid input (abc) and then valid input (123)
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Act
        int result = inputUtil.getIntInput(new Scanner(System.in), "Enter an integer: ");

        // Assert
        assertEquals(123, result);
    }
}
