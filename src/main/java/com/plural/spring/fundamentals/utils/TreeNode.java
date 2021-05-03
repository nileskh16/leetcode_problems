package com.plural.spring.fundamentals.utils;

public class TreeNode {
    private String value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(String value) {
        this.value = value;
        left = null;
        right = null;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public String getValue() { return value; }

    public void setLeft(TreeNode left) { this.left = left; }

    public void setRight(TreeNode right) { this.right = right; }
}