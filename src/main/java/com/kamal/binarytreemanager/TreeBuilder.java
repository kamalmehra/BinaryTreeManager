package com.kamal.binarytreemanager;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeBuilder {
    public TreeNode buildTree(Scanner scanner) {

        System.out.println("Enter the root node value (or -1 to skip creating the tree):");
        int rootData = getUserInput(scanner);

        if (rootData == -1) {
            System.out.println("Tree creation skipped.");
            return null;
        }

        TreeNode root = new TreeNode(rootData);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            System.out.println("Enter nodes for level " + level + ":");
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentTreeNode = queue.poll();

                System.out.print("Enter left child value of " + currentTreeNode.data + " (or -1 for no left child): ");
                int leftData = getUserInput(scanner);
                if (leftData != -1) {
                    TreeNode leftChild = new TreeNode(leftData);
                    currentTreeNode.left = leftChild;
                    queue.add(leftChild);
                }

                System.out.print("Enter right child value of " + currentTreeNode.data + " (or -1 for no right child): ");
                int rightData = getUserInput(scanner);
                if (rightData != -1) {
                    TreeNode rightChild = new TreeNode(rightData);
                    currentTreeNode.right = rightChild;
                    queue.add(rightChild);
                }
            }

            level++;
        }

        return root;
    }

    private int getUserInput(Scanner scanner) {
        int userInput = -1;
        boolean validInput = false;

        while (!validInput) {
            try {
                userInput = scanner.nextInt();
                validInput = true; // Mark as valid input
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); // Consume the newline character
            }
        }

        return userInput;
    }
}