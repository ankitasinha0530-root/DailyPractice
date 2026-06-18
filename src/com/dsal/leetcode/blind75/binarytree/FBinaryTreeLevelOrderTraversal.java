package com.dsal.leetcode.blind75.binarytree;

import java.util.*;

public class FBinaryTreeLevelOrderTraversal {

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

        List<List<Integer>> result = traverseBinaryTreeLevelOrder(root);
        System.out.println("Level Order Traversal = " + result);
    }

    private static List<List<Integer>> traverseBinaryTreeLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

//        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){

            int levelSize = queue.size();
            List<Integer> currLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {

                TreeNode currNode = queue.poll();

                if(currNode != null) {
                    currLevel.add(currNode.val);

                    if (currNode.left != null) {
                        queue.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        queue.add(currNode.right);
                    }
                }
            }
            result.add(currLevel);
        }
        return result;
    }
}
