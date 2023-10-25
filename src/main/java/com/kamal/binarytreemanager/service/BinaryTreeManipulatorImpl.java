package com.kamal.binarytreemanager.service;

import com.kamal.binarytreemanager.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Class for manipulating binary trees.
 */
public class BinaryTreeManipulatorImpl implements BinaryTreeManipulator {
    /**
     * Remove a node from the binary tree and return the roots of subtrees.
     *
     * @param root        The root node of the binary tree.
     * @param nodeToRemove The value of the node to be removed.
     * @return A list of root nodes of subtrees.
     */
    @Override
    public List<TreeNode> findNodeAndReturnSubtrees(TreeNode root, int nodeToRemove) {
        List<TreeNode> rootTreeNodes = new ArrayList<>();

        // Check if the tree is empty
        if (root == null) {
            return rootTreeNodes; // Return an empty list, indicating an empty tree
        }

        if (nodeToRemove != root.data) {
            rootTreeNodes.add(root);
        }

        // Create a queue for BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // Enqueue the root node

        // Perform BFS traversal
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll(); // Dequeue a node from the queue

            if (current.data == nodeToRemove) {
                if (current.left != null) {
                    rootTreeNodes.add(current.left);
                }

                if (current.right != null) {
                    rootTreeNodes.add(current.right);
                }
                return rootTreeNodes;
            }

            // Enqueue the left child if it exists
            if (current.left != null) {
                queue.add(current.left);
            }

            // Enqueue the right child if it exists
            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return rootTreeNodes;
    }
}