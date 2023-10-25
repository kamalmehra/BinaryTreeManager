package com.kamal.binarytreemanager.presentation;

import com.kamal.binarytreemanager.model.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * Test cases for the LevelTreePrinter class.
 */
public class LevelTreePrinterTest {
    private final LevelTreePrinter levelTreePrinter = new LevelTreePrinter();
    private final TreeNode root = new TreeNode(1);
    private final TreeNode leftNode = new TreeNode(2);
    private final TreeNode rightNode = new TreeNode(3);
    private final TreeNode leftLeftNode = new TreeNode(4);

    // Variables to capture standard output
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        // Redirect System.out to outContent for capturing console output
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testPrintLevelOrderWithEmptyTree() {
        // Arrange
        // No need to mock the TreeNode, as it's an empty tree

        // Act
        levelTreePrinter.printTree(null);

        // Assert
        assertTrue(outContent.toString().contains("The tree is empty."));
    }

    @Test
    public void testPrintLevelOrderWithNonEmptyTree() {
        // Arrange
        // Set up a tree structure
        root.left = leftNode;
        root.right = rightNode;
        leftNode.left = leftLeftNode;

        // Act
        levelTreePrinter.printTree(root);

        // Assert
        // Check if the expected structure is printed
        assertTrue(outContent.toString().contains("Level 0: "));
        assertTrue(outContent.toString().contains("Level 1: "));
        assertTrue(outContent.toString().contains("Level 2: "));

        // Check if the data of nodes is printed in the correct order
        assertTrue(outContent.toString().contains("Level 0: "));
        assertTrue(outContent.toString().contains("1 "));
        assertTrue(outContent.toString().contains("Level 1: "));
        assertTrue(outContent.toString().contains("2 "));
        assertTrue(outContent.toString().contains("3 "));
        assertTrue(outContent.toString().contains("Level 2: "));
        assertTrue(outContent.toString().contains("4 "));
        assertTrue(outContent.toString().contains("-1 "));

        // Reset System.out to its original value
        System.setOut(originalOut);
    }

    @Test
    public void testPrintLevelOrderWithSingleRootNode() {
        // Arrange
        // Set up a tree with only a root node (no children)
        // The tree will have a single node at Level 0

        // Act
        levelTreePrinter.printTree(root);

        // Assert
        // Check if the expected structure is printed
        assertTrue(outContent.toString().contains("Level 0: "));

        // Check if the data of the root node is printed
        assertTrue(outContent.toString().contains("1 "));

        // Reset System.out to its original value
        System.setOut(originalOut);
    }
}
