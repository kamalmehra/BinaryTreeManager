package com.kamal.binarytreemanager.service;

import com.kamal.binarytreemanager.model.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BinaryTreeManipulatorTest {

    private BinaryTreeManipulator treeManipulator;

    @BeforeEach
    public void setup() {
        treeManipulator = new BinaryTreeManipulatorImpl();
    }

    @Test
    public void testRemoveNodeAndReturnSubtrees() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        List<TreeNode> subtrees = treeManipulator.findNodeAndReturnSubtrees(root, 3);

        assertEquals(5, subtrees.get(0).data);
    }
}
