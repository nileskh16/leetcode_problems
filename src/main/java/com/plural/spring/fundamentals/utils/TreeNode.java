package com.plural.spring.fundamentals.utils;

public class TreeNode <T> {
    private T value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(T value) {
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

    public T getValue() { return value; }

    public void setLeft(TreeNode left) { this.left = left; }

    public void setRight(TreeNode right) { this.right = right; }
}