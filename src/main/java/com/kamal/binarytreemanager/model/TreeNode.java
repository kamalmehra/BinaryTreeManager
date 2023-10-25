package com.kamal.binarytreemanager.domain;

/**
 * Class representing a binary tree node.
 */
public class TreeNode {
    public final int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}