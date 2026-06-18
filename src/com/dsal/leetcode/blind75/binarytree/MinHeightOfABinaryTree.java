package com.dsal.leetcode.blind75.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MinHeightOfABinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(9);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(8);
        root.right.left.right.left = new TreeNode(12);

        System.out.println(" Max height of a tree Level Order BFS = " + minHeightofABinaryTreeBFS(root));
        System.out.println(" Max height of a tree DFS = " + minHeightofABinaryTreeDfs(root));
    }

    private static int minHeightofABinaryTreeBFS(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;
        while(!queue.isEmpty()) {

            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                if(current != null && current.left == null && current.right == null){
                    return count;
                }
                if(current != null) {
                    if(current.left != null){
                        queue.add(current.left);
                    }
                    if(current.right != null){
                        queue.add(current.right);
                    }
                }
            }
            count++;
        }
        return count;
    }

    private static int minHeightofABinaryTreeDfs(TreeNode root) {

        if(root == null){
            return 0;
        }

        if(root.left == null){
            return 1 + minHeightofABinaryTreeDfs(root.right);
        }

        if(root.right == null){
            return 1 + minHeightofABinaryTreeDfs(root.left);
        }

        int leftHeight = minHeightofABinaryTreeDfs(root.left);
        int rightHeight = minHeightofABinaryTreeDfs(root.right);


        return Math.min(leftHeight, rightHeight) + 1;
    }
}
