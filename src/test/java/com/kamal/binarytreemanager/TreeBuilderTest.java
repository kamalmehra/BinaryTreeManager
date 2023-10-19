package com.kamal.binarytreemanager;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class TreeBuilderTest {

    private TreeBuilder treeBuilder;
    private Scanner scanner;

    @BeforeEach
    void setUp() {
        treeBuilder = new TreeBuilder();
        scanner = mock(Scanner.class);
    }

    @AfterEach
    void tearDown() {
        System.setIn(System.in); // Reset System.in to its original value
    }

    @Test
    void testBuildTree_NormalInput() {
        // Prepare input for creating a simple tree: 1 -> 2, 3
        String input = "1\n2\n3\n-1\n-1\n-1\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        when(scanner.nextInt()).thenReturn(1, 2, 3, -1, -1, -1);

        // Build a tree using the provided input
        TreeNode root = treeBuilder.buildTree(scanner);

        // Assert that the tree is created correctly
        assertNotNull(root);
        assertEquals(1, root.data);
        assertNotNull(root.left);
        assertEquals(2, root.left.data);
        assertNotNull(root.right);
        assertEquals(3, root.right.data);
        assertNull(root.left.left);
        assertNull(root.left.right);
        assertNull(root.right.left);
        assertNull(root.right.right);
    }

    @Test
    void testBuildTree_SkippedTreeCreation() {
        // Prepare input to skip tree creation
        String input = "-1\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        when(scanner.nextInt()).thenReturn(-1);

        // Build a tree using the provided input (skipping tree creation)
        TreeNode root = treeBuilder.buildTree(scanner);

        // Assert that root is null, indicating tree creation was skipped
        assertNull(root);
    }

//    @Test
//    void testBuildTree_InvalidInput() {
//        // Prepare input with invalid values
//        String input = "1\na\n3\n-1\n-1\n";
//        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
//        System.setIn(inputStream);
//        when(scanner.nextInt()).thenThrow(new InputMismatchException()); // Simulate invalid input
//
//        // Build a tree using the provided input (expecting exceptions)
//        assertThrows(InputMismatchException.class, () -> treeBuilder.buildTree(scanner));
//    }

    @Test
    void testBuildTree_EmptyTree() {
        // Prepare input to create an empty tree (no nodes)
        String input = "-1\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        when(scanner.nextInt()).thenReturn(-1);

        // Build a tree using the provided input (expecting an empty tree)
        TreeNode root = treeBuilder.buildTree(scanner);

        // Assert that root is null, indicating an empty tree
        assertNull(root);
    }

    // Add more test cases here...
}
