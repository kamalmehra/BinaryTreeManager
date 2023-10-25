package com.kamal.binarytreemanager.service;

import com.kamal.binarytreemanager.model.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class TreeBuilderTest {

    private TreeBuilder treeBuilder;

    @BeforeEach
    public void setup() {
        treeBuilder = new TreeBuilder();
    }

    @Test
    public void testTreeBuilderWithValidInput() {
        // Simulate user input with ByteArrayInputStream
        Scanner scanner = new Scanner("5\n1\n2\n-1\n-1\n-1\n-1\n");
        TreeNode root = treeBuilder.buildTree(scanner);
        assertNotNull(root);
        assertEquals(5, root.data);
        assertNotNull(root.left);
        assertNotNull(root.right);
    }

    @Test
    public void testTreeBuilderWithSkippedTreeCreation() {
        Scanner scanner = new Scanner("-1\n");
        TreeNode root = treeBuilder.buildTree(scanner);
        assertNull(root);
    }
}
