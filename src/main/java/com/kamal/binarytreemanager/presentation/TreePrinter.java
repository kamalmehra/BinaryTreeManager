package com.kamal.binarytreemanager.presentation;


import com.kamal.binarytreemanager.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class for printing binary trees.
 */
public class TreePrinter {
    private static final String EMPTY_TREE_MESSAGE = "The tree is empty.";
    private static final String LEVEL_PREFIX = "Level ";
    private static final String NULL_NODE = "-1 ";

    /**
     * Print the binary tree in level order.
     *
     * @param root The root node of the binary tree.
     */
    public void printLevelOrder(final TreeNode root) {
        if (root == null) {
            System.out.println(EMPTY_TREE_MESSAGE);
            return;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            boolean levelContainsNonNullNodes = false;

            System.out.print(LEVEL_PREFIX + level + ": ");
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                if (current != null) {
                    System.out.print(current.data + " ");
                    levelContainsNonNullNodes = true;

                    if (current.left != null) {
                        queue.add(current.left);
                    } else {
                        queue.add(null); // Add null for missing left child
                    }

                    if (current.right != null) {
                        queue.add(current.right);
                    } else {
                        queue.add(null); // Add null for missing right child
                    }
                } else {
                    System.out.print(NULL_NODE);
                }
            }

            System.out.println();
            level++;

            // Exit the loop if the level only contains null nodes
            if (!levelContainsNonNullNodes) {
                break;
            }
        }
    }
}
