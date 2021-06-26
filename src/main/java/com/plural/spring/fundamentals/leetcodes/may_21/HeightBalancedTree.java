package com.plural.spring.fundamentals.leetcodes.may_21;

import com.plural.spring.fundamentals.utils.TreeNode;

import java.util.List;

public class HeightBalancedTree {

    private TreeNode<Integer> root;

    public void constructTree(List<Integer> values) {
        root = recurseTree(values, 0, values.size() - 1, root);
    }

    private TreeNode<Integer> recurseTree(List<Integer> values, int left, int right, TreeNode<Integer> node) {
        if (left > right) return null;
        Integer mid = (left + right) / 2;
        Integer value = values.get(mid);
        node = new TreeNode<>(value);
        node.setLeft(recurseTree(values, left, mid - 1, node.getLeft()));
        node.setRight(recurseTree(values, mid + 1, right, node.getRight()));
        return node;
    }
}