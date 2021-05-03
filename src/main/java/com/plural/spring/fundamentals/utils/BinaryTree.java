package com.plural.spring.fundamentals.utils;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private TreeNode root;

    public void addNode(String value) {
        root = add(root, value);
    }

    public List<String> sortValues() {
        List<String> values = new ArrayList<>();
        sortValues(values, root);
        return values;
    }

    public void traverse() {
        printAll(root);
    }

    private TreeNode add(TreeNode node, String value) {
        if (node == null) {
            node = new TreeNode(value);
        } else {
            if (node.getValue().compareTo(value) > 0) {
                node.setLeft(add(node.getLeft(), value));
            } else {
                node.setRight(add(node.getRight(), value));
            }
        }
        return node;
    }

    private void sortValues(List<String> values, TreeNode node) {
        if (node != null) {
            sortValues(values, node.getLeft());
            values.add(node.getValue());
            sortValues(values, node.getRight());
        }
    }

    private void printAll(TreeNode node) {
        if (node != null) {
            System.out.println(node.getValue());
            printAll(node.getLeft());
            printAll(node.getRight());
        }
    }
}
