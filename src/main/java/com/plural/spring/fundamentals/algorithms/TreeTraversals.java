package com.plural.spring.fundamentals.algorithms;

import com.plural.spring.fundamentals.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeTraversals {

    private TreeNode<Integer> root;

    public void addNode(Integer... values) {
        for (Integer value : values) {
            root = updateTree(value, root);
        }
    }

    public List<Integer> treeTraversal(String mode) {
        List<Integer> list = new ArrayList<>();
        switch (mode) {
            case "IN_ORDER":
                inOrderTraversal(root, list);
                break;
            case "PRE_ORDER":
                preOrderTraversal(root, list);
                break;
            case "POST_ORDER":
                postOrderTraversal(root, list);
                break;
            case "BFS":
                bfsOfTree(root, list);
                break;
            case "DFS":
                dfsOfTree(root, list);
                break;
            default:
                System.out.println("Invalid traversal mode provided");
                break;
        }
        return list;
    }

    private TreeNode<Integer> updateTree(Integer value, TreeNode<Integer> node) {
        if (node == null) {
            node = new TreeNode<>(value);
        } else {
            if (node.getValue() > value) {
                node.setLeft(updateTree(value, node.getLeft()));
            } else {
                node.setRight(updateTree(value, node.getRight()));
            }
        }
        return node;
    }

    private void inOrderTraversal(TreeNode<Integer> node, List<Integer> list) {
        if (node == null) return;
        inOrderTraversal(node.getLeft(), list);
        list.add(node.getValue());
        inOrderTraversal(node.getRight(), list);
    }

    private void preOrderTraversal(TreeNode<Integer> node, List<Integer> list) {
        if (node == null) return;
        list.add(node.getValue());
        preOrderTraversal(node.getLeft(), list);
        preOrderTraversal(node.getRight(), list);
    }

    private void postOrderTraversal(TreeNode<Integer> node, List<Integer> list) {
        if (node == null) return;
        postOrderTraversal(node.getLeft(), list);
        preOrderTraversal(node.getRight(), list);
        list.add(node.getValue());
    }

    private void bfsOfTree(TreeNode<Integer> node, List<Integer> list) {
        Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode<Integer> tempNode = queue.poll();
            if (tempNode != null) {
                list.add(tempNode.getValue());
                if (tempNode.getLeft() != null) queue.add(tempNode.getLeft());
                if (tempNode.getRight() != null) queue.add(tempNode.getRight());
            }
        }
    }

    private void dfsOfTree(TreeNode<Integer> node, List<Integer> list) {
        if (node == null) return;
        list.add(node.getValue());
        dfsOfTree(node.getLeft(), list);
        dfsOfTree(node.getRight(), list);
    }
}
