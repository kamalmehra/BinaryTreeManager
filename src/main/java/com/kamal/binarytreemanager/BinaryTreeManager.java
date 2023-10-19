package com.kamal.binarytreemanager;

import java.util.Scanner;
import java.util.List;

public class BinaryTreeManager {
    public static void main(String[] args) {
        // Create instances of TreeBuilder, TreeManipulator, and TreePrinter
        TreeBuilder treeBuilder = new TreeBuilder();
        TreeManipulator treeManipulator = new TreeManipulator();
        TreePrinter treePrinter = new TreePrinter();

        // Create a single Scanner for input
        Scanner scanner = new Scanner(System.in);

        // Take user input, build the tree, and remove a node
        TreeNode rootNode = treeBuilder.buildTree(scanner);

        if (rootNode != null) {
            treePrinter.printLevelOrder(rootNode);
        } else {
            System.out.println("Tree is empty! Exiting.");
            System.exit(0); // Exit the program gracefully
        }

        int nodeToRemove = getUserInputToRemoveNode(scanner);
        List<TreeNode> rootsOfSubtrees = treeManipulator.removeNodeAndReturnSubtrees(rootNode, nodeToRemove);
        // Print the roots of subtrees
        System.out.println("Roots of Subtrees:");
        for (int i = 0; i < rootsOfSubtrees.size(); i++) {
            System.out.println("Subtree " + (i + 1) + ": " + rootsOfSubtrees.get(i).data);
        }

        // Close the single Scanner when it's no longer needed
        //scanner.close();
    }

    public static int getUserInputToRemoveNode(Scanner scanner) {
        int nodeToRemove;
        do {
            System.out.print("Enter the node to remove: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
            nodeToRemove = scanner.nextInt();
        } while (nodeToRemove < 0);
        return nodeToRemove;
    }
}