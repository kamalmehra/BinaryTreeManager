package com.kamal.binarytreemanager.presentation;

import com.kamal.binarytreemanager.service.TreeBuilder;
import com.kamal.binarytreemanager.service.TreeManipulator;
import com.kamal.binarytreemanager.model.TreeNode;
import com.kamal.binarytreemanager.util.InputUtil;

import java.util.List;
import java.util.Scanner;

/**
 * UserInterface class responsible for interacting with the user and managing the application flow.
 */
public class UserInterface {
    private static final String EXIT_MESSAGE = "Tree is empty! Exiting.";
    private static final String REMOVE_NODE_PROMPT = "Enter the node to remove: ";
    private static final String SUBTREE_MESSAGE = "Roots of Subtrees:";
    private static final String SUBTREE_TEMPLATE = "Subtree %d: %d";
    private final TreeBuilder treeBuilder;
    private final TreeManipulator treeManipulator;
    private final TreePrinter treePrinter;

    public UserInterface(TreeBuilder treeBuilder, TreeManipulator treeManipulator, TreePrinter treePrinter) {
        this.treeBuilder = treeBuilder;
        this.treeManipulator = treeManipulator;
        this.treePrinter = treePrinter;
    }

    /**
     * Start the user interface and the application.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);

        TreeNode rootNode = treeBuilder.buildTree(scanner);

        if (rootNode != null) {
            treePrinter.printLevelOrder(rootNode);
        } else {
            System.out.println(EXIT_MESSAGE);
            return;
        }

        int nodeToRemove = InputUtil.getIntInput(scanner, REMOVE_NODE_PROMPT);
        List<TreeNode> rootsOfSubtrees = treeManipulator.removeNodeAndReturnSubtrees(rootNode, nodeToRemove);
        System.out.println(SUBTREE_MESSAGE);

        for (int i = 0; i < rootsOfSubtrees.size(); ++i) {
            System.out.println(String.format(SUBTREE_TEMPLATE, i + 1, rootsOfSubtrees.get(i).data));
        }
    }
}

