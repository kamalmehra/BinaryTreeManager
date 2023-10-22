package com.kamal.binarytreemanager;

import com.kamal.binarytreemanager.domain.TreeNode;
import com.kamal.binarytreemanager.service.TreeManipulator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeManipulatorTest {
    private TreeManipulator treeManipulator;

    @BeforeEach
    void setUp() {
        // Initialize the TreeManipulator before each test.
        treeManipulator = new TreeManipulator();
    }

    @Test
    void testRemoveNodeAndReturnSubtrees_NodeExists() {
        // Create a sample tree:
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int nodeToRemove = 2;

        // Execute the method to remove the specified node and return subtrees.
        List<TreeNode> result = treeManipulator.removeNodeAndReturnSubtrees(root, nodeToRemove);

        // The node with the value 2 exists in the tree.
        // The result should contain the roots of the subtrees created by removing node 2.
        assertEquals(3, result.size(), "Result should contain 3 subtrees.");
        assertEquals(1, result.get(0).data, "First subtree should be rooted at 1.");
        assertEquals(4, result.get(1).data, "Second subtree should be rooted at 4.");
        assertEquals(5, result.get(2).data, "Second subtree should be rooted at 5.");
    }

    @Test
    void testRemoveNodeAndReturnSubtrees_NodeNotExists() {
        // Create a sample tree:
        //       1
        //      / \
        //     2   3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        int nodeToRemove = 4; // Node with value 4 doesn't exist in the tree.

        // Execute the method to remove the specified node and return subtrees.
        List<TreeNode> result = treeManipulator.removeNodeAndReturnSubtrees(root, nodeToRemove);

        // The node with the value 4 doesn't exist in the tree.
        // The result should be an empty list.
        assertEquals(1, result.get(0).data, "Result will be subtree with 1 as root.");
    }
}
