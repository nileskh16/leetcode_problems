package com.plural.spring.fundamentals.problems.design;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        preOrder(sb, root);
        ans.append(new String(sb)).append("_");
        sb.setLength(0);
        inOrder(sb, root);
        ans.append(new String(sb));
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] parts = data.split("_");
        if (parts.length == 0) return null;
        String pre = parts[0];
        String in = parts[1];
        System.out.printf("In -> %s.%nPre -> %s.%n", in, pre);
        String[] pres = skipEmpty(pre.split("-"));
        String[] ins = skipEmpty(in.split("-"));
        System.out.println(Arrays.toString(pres));
        System.out.println(Arrays.toString(ins));
        return constructTree(ins, pres);
    }

    private void inOrder(StringBuilder sb, TreeNode node) {
        if (node == null) return;
        inOrder(sb, node.left);
        sb.append(node.val).append("-");
        inOrder(sb, node.right);
    }

    private void preOrder(StringBuilder sb, TreeNode node) {
        if (node == null) return;
        sb.append(node.val).append("-");
        preOrder(sb, node.left);
        preOrder(sb, node.right);
    }

    private TreeNode constructTree(String[] in, String[] pre) {
        if (in.length == 0) return null;
        String rootVal = in[0];
        int val = Integer.parseInt(rootVal), index = findIndex(in, rootVal);
        TreeNode node = new TreeNode(val);
        node.left = constructTree(splitArray(in, 0, index), splitArray(pre, 1, index + 1));
        node.right = constructTree(splitArray(in, index + 1, in.length), splitArray(pre, index + 1, pre.length));
        return node;
    }

    private int findIndex (String[] arr, String val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(val)) return i;
        }
        return -1;
    }

    private String[] splitArray(String[] arr, int left, int right) {
        if (right < left) return null;
        String[] ans = new String[right - left];
        if (right - left >= 0) System.arraycopy(arr, left, ans, 0, right - left);
        return ans;
    }

    private String[] skipEmpty(String[] arr) {
        return Arrays.stream(arr)
                .filter((val) -> !val.isEmpty())
                .toArray(String[]::new);
    }

    public static String DELIM = ",";
    public static String NULLX = "X";


    // Encodes a tree to a single string.
    public String seerialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null)
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            if (sb.length() > 0){
                sb.append(DELIM);
            }
            if (cur == null){
                sb.append(NULLX);
            } else {
                sb.append(cur.val);
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deeserialize(String data) {
        if (data == null)
            return null;
        if (data.equals(NULLX))
            return null;
        String[] toks = data.split(DELIM);
        int idx = 0;
        TreeNode root = new TreeNode(getNum(toks[idx++]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty() && idx < toks.length){
            TreeNode cur = q.poll();
            if (!toks[idx].equals(NULLX)){
                cur.left = new TreeNode( getNum(toks[idx]) );
                q.offer(cur.left);
            }
            idx++;
            if (idx < toks.length && !toks[idx].equals(NULLX)){
                cur.right = new TreeNode( getNum(toks[idx]) );
                q.offer(cur.right);
            }
            idx++;
        }
        return root;
    }
    private int getNum(String x){
        return Integer.parseInt(x);
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
