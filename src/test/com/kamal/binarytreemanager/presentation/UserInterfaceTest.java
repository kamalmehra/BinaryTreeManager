package com.kamal.binarytreemanager.presentation;

import com.kamal.binarytreemanager.service.BinaryTreeManipulator;
import com.kamal.binarytreemanager.service.TreeBuilder;
import com.kamal.binarytreemanager.model.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserInterfaceTest {
    private final TreeBuilder treeBuilder = mock(TreeBuilder.class);
    private final BinaryTreeManipulator treeManipulator = mock(BinaryTreeManipulator.class);
    private final LevelTreePrinter levelTreePrinter = mock(LevelTreePrinter.class);

    private UserInterface userInterface;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        userInterface = new UserInterface(treeBuilder, treeManipulator, levelTreePrinter);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testRunWithEmptyTree() {
        // Arrange
        Scanner scanner = new Scanner(new ByteArrayInputStream("".getBytes()));
        when(treeBuilder.buildTree(scanner)).thenReturn(null);

        // Act
        userInterface.run();

        // Assert
        assertTrue(outContent.toString().contains("Tree is empty! Exiting."));
        verify(levelTreePrinter, never()).printTree(any(TreeNode.class));
        verify(treeManipulator, never()).findNodeAndReturnSubtrees(any(TreeNode.class), anyInt());
    }
}
