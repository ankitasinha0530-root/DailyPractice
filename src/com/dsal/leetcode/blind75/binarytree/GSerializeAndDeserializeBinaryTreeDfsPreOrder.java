package com.dsal.leetcode.blind75.binarytree;


import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class GSerializeAndDeserializeBinaryTreeDfsPreOrder {

    private static class TreeNode {
        int val = 0;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        String serializedTree = srializeTree(root);
        System.out.println("Level Order Traversal = " + serializedTree);

        System.out.println();
        TreeNode resultRoot = deserializedTree(serializedTree);
        printPreOrder(resultRoot);
    }

    public static String srializeTree(TreeNode root) {

        StringBuilder sb = new StringBuilder();

        preOrderSerialize(root, sb);

        return sb.toString();

    }

    private static void preOrderSerialize(TreeNode root, StringBuilder sb) {

        if (root == null) {
            sb.append("null").append(",");
            return;
        }
        sb.append(root.val).append(",");
        preOrderSerialize(root.left, sb);
        preOrderSerialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserializedTree(String data) {

//        Queue<String> queue = new LinkedList<>();
//        queue.addAll(Arrays.asList(data.split(",")));

        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));

        return deserializedTreeHelper(queue);

    }

    private static TreeNode deserializedTreeHelper(Queue<String> queue) {

        String currVal = queue.poll();

        if(currVal.equals("null")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(currVal));

        root.left = deserializedTreeHelper(queue);
        root.right = deserializedTreeHelper(queue);

        return root;
    }

    private static void printPreOrder(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }

        System.out.print(root.val + " ");

        printPreOrder(root.left);
        printPreOrder(root.right);
    }
}
