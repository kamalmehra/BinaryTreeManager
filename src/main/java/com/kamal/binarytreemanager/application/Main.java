package com.kamal.binarytreemanager.application;

import com.kamal.binarytreemanager.presentation.TreePrinter;
import com.kamal.binarytreemanager.presentation.UserInterface;
import com.kamal.binarytreemanager.service.BinaryTreeManipulatorImpl;
import com.kamal.binarytreemanager.service.TreeBuilder;
import com.kamal.binarytreemanager.service.BinaryTreeManipulator;

/**
 * Main class responsible for starting the application.
 */
public class Main {
    public static void main(String[] args) {
        TreeBuilder treeBuilder = new TreeBuilder();
        BinaryTreeManipulator treeManipulator = new BinaryTreeManipulatorImpl();
        TreePrinter treePrinter = new TreePrinter();
        final UserInterface userInterface = new UserInterface(treeBuilder, treeManipulator, treePrinter);

        // Start the user interface
        userInterface.run();
    }
}