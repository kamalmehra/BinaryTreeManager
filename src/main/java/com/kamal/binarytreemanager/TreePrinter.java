package com.kamal.binarytreemanager;

import java.util.LinkedList;
import java.util.Queue;

public class TreePrinter {
    // Function to print the binary tree level by level
    public void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("The tree is empty.");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            boolean levelContainsNonNullNodes = false;

            System.out.print("Level " + level + ": ");
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
                    System.out.print("-1 ");
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
