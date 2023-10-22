package com.kamal.binarytreemanager;

import com.kamal.binarytreemanager.domain.TreeNode;
import com.kamal.binarytreemanager.presentation.TreePrinter;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TreePrinterTest {

    @Test
    void testPrintLevelOrder() {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-1); // Missing right child
        root.left.left = new TreeNode(-1); // Missing left and right children
        root.left.right = new TreeNode(5);

        // Create an instance of TreePrinter
        TreePrinter treePrinter = new TreePrinter();

        // Redirect the standard output to capture printed text
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the printLevelOrder method
        treePrinter.printLevelOrder(root);

        // Restore the standard output
        System.setOut(System.out);

        // Extract the printed text
        String printedOutput = outputStream.toString();

        // Write assertions to check the printed output
        assertTrue(printedOutput.contains("Level 0: 1"));
        assertTrue(printedOutput.contains("Level 1: 2 -1"));
        assertFalse(printedOutput.contains("Level 2: -1 -1"));
    }
}