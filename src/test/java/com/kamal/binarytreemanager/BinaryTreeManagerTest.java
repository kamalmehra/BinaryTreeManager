package com.kamal.binarytreemanager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BinaryTreeManagerTest {

    private BinaryTreeManager binaryTreeManager;
    private Scanner scanner;

    @BeforeEach
    void setUp() {
        binaryTreeManager = new BinaryTreeManager();
        scanner = mock(Scanner.class);
    }

    @Test
    void testGetUserInputToRemoveNode() {
        // Prepare test input
        String input = "5\n";

        // Set up the input stream and scanner
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        when(scanner.hasNextInt()).thenReturn(true);
        when(scanner.nextInt()).thenReturn(5);

        // Call the method
        int result = binaryTreeManager.getUserInputToRemoveNode(scanner);

        // Verify that the method returns the expected value
        assertEquals(5, result);

        // Verify that the scanner methods were called
        verify(scanner, times(1)).hasNextInt();
        verify(scanner, times(1)).nextInt();
    }

    @Test
    void testBinaryTreeManager() {
        // Prepare test input
        String input = "5\n";

        // Set up the input stream and scanner
        // Create an input stream that simulates user input "5" followed by Enter.
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Define the expected behavior of the mock Scanner.
        when(scanner.hasNextInt()).thenReturn(true);  // The scanner will report that it has an integer.
        when(scanner.nextInt()).thenReturn(5);         // The scanner will return 5 as the next integer.

        // Call the method under test
        int result = binaryTreeManager.getUserInputToRemoveNode(scanner);

        // Verify that the method returns the expected value
        assertEquals(5, result);

        // Verify that the scanner methods were called
        verify(scanner, times(1)).hasNextInt();  // Check if hasNextInt was called once.
        verify(scanner, times(1)).nextInt();     // Check if nextInt was called once.
    }
}
