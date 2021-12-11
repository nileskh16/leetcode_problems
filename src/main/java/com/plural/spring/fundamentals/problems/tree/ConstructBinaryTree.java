package com.plural.spring.fundamentals.problems.tree;

public class ConstructBinaryTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return constructTree(preorder, inorder, 0, 0, preorder.length - 1);
    }

    private TreeNode constructTree(int[] preorder, int[] inorder, int pivotIndex, int left, int right) {
        if (left > right) return null;
        int rootValue = preorder[pivotIndex];
        TreeNode node = new TreeNode(rootValue);
        int index = getIndex(inorder, rootValue, left, right);
        int leftChildren = index - left;
        node.left = constructTree(preorder, inorder, pivotIndex + 1, left, index - 1);
        node.right = constructTree(preorder, inorder, pivotIndex + 1 + leftChildren, index + 1, right);
        return node;
    }

    private int getIndex(int[] nums, int val, int low, int right) {
        for (int i = low; i <= right; i++) {
            if (nums[i] == val) return i;
        }
        return -1;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
