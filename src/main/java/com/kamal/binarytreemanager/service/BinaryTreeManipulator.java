package com.kamal.binarytreemanager.service;

import com.kamal.binarytreemanager.model.TreeNode;

import java.util.List;

/**
 * The {@code BinaryTreeManipulator} interface defines a contract for classes that
 * perform various operations on binary trees.
 */
public interface BinaryTreeManipulator {

    /**
     * Finds a node with the specified value in the binary tree rooted at {@code root}
     * and returns a list of roots of the subtrees that will be formed if we removed
     * the specified node.
     *
     * @param root  The root node of the binary tree.
     * @param value The value of node to be searched in the binary tree.
     * @return A list of roots of subtrees that will be formed if we removed the specified node.
     */
    List<TreeNode> findNodeAndReturnSubtrees(TreeNode root, int value);
}
