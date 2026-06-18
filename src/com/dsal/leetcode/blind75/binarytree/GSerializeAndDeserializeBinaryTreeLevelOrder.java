package com.dsal.leetcode.blind75.binarytree;


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class GSerializeAndDeserializeBinaryTreeLevelOrder {

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

        TreeNode resultRoot = deserializedTree(serializedTree);
        printPreOrder(resultRoot);
    }

    private static void printPreOrder(TreeNode root) {
        if (root == null) {
//            System.out.print("null ");
            return;
        }

        System.out.print(root.val + " ");

        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static String srializeTree(TreeNode root) {

        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){

            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {

                TreeNode currNode = queue.poll();

                if(currNode == null){
                    sb.append("null,");
                }else {
                    sb.append(currNode.val).append(",");
                    queue.add(currNode.left);
                    queue.add(currNode.right);
                }
            }
        }
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public static TreeNode deserializedTree(String data) {

        if(data == null){
            return null;
        }
        String[] strArr = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strArr[0]));
        queue.add(root);
        int i = 1;

        while(!queue.isEmpty() && i < strArr.length){

            TreeNode currNode = queue.poll();

            if(!strArr[i].equals("null")){
                currNode.left = new TreeNode(Integer.parseInt(strArr[i]));
                queue.add(currNode.left);
            }
            i++;

            if( i < strArr.length && !strArr[i].equals("null")){
                currNode.right = new TreeNode(Integer.parseInt(strArr[i]));
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
}
