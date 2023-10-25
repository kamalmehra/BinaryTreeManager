package com.kamal.binarytreemanager.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TreeNodeTest {

    @Test
    public void testTreeNodeCreation() {
        TreeNode node = new TreeNode(42);
        assertEquals(42, node.data);
        assertNull(node.left);
        assertNull(node.right);
    }
}