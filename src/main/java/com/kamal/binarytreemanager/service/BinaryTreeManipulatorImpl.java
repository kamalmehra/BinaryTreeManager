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

            //finding whether childs are the desired node

            if(current.left != null) {
                if(current.left.data == nodeToRemove) {
                    rootTreeNodes.add(current.left);
                    rootTreeNodes = addChilds(current.left, rootTreeNodes);
                    replaceNode(current, false);
                }
            }

            if(current.right != null) {
                if(current.right.data == nodeToRemove) {
                    rootTreeNodes = addChilds(current.right, rootTreeNodes);
                    replaceNode(current, true);
                }
            }

//            if (current.data == nodeToRemove) {
//
//                if (current.left != null) {
//                    rootTreeNodes.add(current.left);
//                }
//
//                if (current.right != null) {
//                    rootTreeNodes.add(current.right);
//                }
//                return rootTreeNodes;
//            }

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

    public List<TreeNode> addChilds(TreeNode node, List<TreeNode> roots) {
        if(node.left != null) {
            roots.add(node.left);
        }
        if(node.right != null) {
            roots.add(node.left);
        }

        return roots;
    }

    public void replaceNode(TreeNode current, boolean isRight) {
        if(isRight) {
            //node to replace is in right side of parent
            if(current.right.right != null) {
                current.right = current.right.right;
            }
            else if(current.right.left != null) {
                current.right = current.right.left;
            }

            else {
                current.right = null;
            }
        }

        else {
            if(current.left.right != null) {
                current.left = current.left.right;
            }
            else if(current.left.left != null) {
                current.left = current.left.left;
            }

            else {
                current.left = null;
            }
        }
    }
}

// 2
// 1 3
// 4 5 -1 -1