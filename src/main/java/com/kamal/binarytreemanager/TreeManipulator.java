package com.kamal.binarytreemanager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeManipulator {
    public List<TreeNode> removeNodeAndReturnSubtrees(TreeNode root, int nodeToRemove) {
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