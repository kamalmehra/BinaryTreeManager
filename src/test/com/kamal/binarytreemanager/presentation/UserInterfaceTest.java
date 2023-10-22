package com.kamal.binarytreemanager.presentation;

import com.kamal.binarytreemanager.service.TreeBuilder;
import com.kamal.binarytreemanager.service.TreeManipulator;
import com.kamal.binarytreemanager.domain.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserInterfaceTest {
    private final TreeBuilder treeBuilder = mock(TreeBuilder.class);
    private final TreeManipulator treeManipulator = mock(TreeManipulator.class);
    private final TreePrinter treePrinter = mock(TreePrinter.class);

    private UserInterface userInterface;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        userInterface = new UserInterface(treeBuilder, treeManipulator, treePrinter);
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
        verify(treePrinter, never()).printLevelOrder(any(TreeNode.class));
        verify(treeManipulator, never()).removeNodeAndReturnSubtrees(any(TreeNode.class), anyInt());
    }
}
