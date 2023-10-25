package com.kamal.binarytreemanager.service;

import com.kamal.binarytreemanager.model.TreeNode;
import com.kamal.binarytreemanager.util.InputUtil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeBuilder {
    private static final String ROOT_NODE_PROMPT = "Enter the root node value (or -1 to skip creating the tree): ";
    private static final String TREE_CREATION_SKIPPED_MESSAGE = "Tree creation skipped.";
    private static final String LEVEL_PROMPT = "Enter nodes for level %d:";
    private static final String LEFT_CHILD_PROMPT = "Enter left child value of %d (or -1 for no left child): ";
    private static final String RIGHT_CHILD_PROMPT = "Enter right child value of %d (or -1 for no right child): ";


    /**
     * Build a binary tree by taking user input.
     *
     * @param scanner The Scanner object for input.
     * @return The root node of the binary tree.
     */
    public TreeNode buildTree(Scanner scanner) {
        int rootData = InputUtil.getIntInput(scanner, ROOT_NODE_PROMPT);
        if (rootData == -1) {
            System.out.println(TREE_CREATION_SKIPPED_MESSAGE);
            return null;
        } else {
            TreeNode root = new TreeNode(rootData);
            buildTreeLevelByLevel(root, scanner);
            return root;
        }
    }

    /**
     * Build a binary tree level-by-level by taking user input.
     *
     * @param root    The root node of the current level.
     * @param scanner The Scanner object for input.
     */
    private void buildTreeLevelByLevel(TreeNode root, Scanner scanner) {
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        for (int level = 1; !queue.isEmpty(); ++level) {
            int levelSize = queue.size();
            System.out.println(String.format(LEVEL_PROMPT, level));

            for (int i = 0; i < levelSize; ++i) {
                TreeNode currentTreeNode = queue.poll();
                assert currentTreeNode != null;
                buildLeftChild(currentTreeNode, queue, scanner);
                buildRightChild(currentTreeNode, queue, scanner);
            }
        }
    }

    /**
     * Build the left child of a node by taking user input.
     *
     * @param parent  The parent node.
     * @param queue   The queue for BFS traversal.
     * @param scanner The Scanner object for input.
     */
    private void buildLeftChild(TreeNode parent, Queue<TreeNode> queue, Scanner scanner) {
        int leftData = InputUtil.getIntInput(scanner, String.format(LEFT_CHILD_PROMPT, parent.data));
        if (leftData != -1) {
            TreeNode leftChild = new TreeNode(leftData);
            parent.left = leftChild;
            queue.add(leftChild);
        }
    }

    /**
     * Build the right child of a node by taking user input.
     *
     * @param parent  The parent node.
     * @param queue   The queue for BFS traversal.
     * @param scanner The Scanner object for input.
     */
    private void buildRightChild(TreeNode parent, Queue<TreeNode> queue, Scanner scanner) {
        int rightData = InputUtil.getIntInput(scanner, String.format(RIGHT_CHILD_PROMPT, parent.data));
        if (rightData != -1) {
            TreeNode rightChild = new TreeNode(rightData);
            parent.right = rightChild;
            queue.add(rightChild);
        }
    }
}