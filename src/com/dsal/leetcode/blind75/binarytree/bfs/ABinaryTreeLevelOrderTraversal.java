package com.dsal.leetcode.blind75.binarytree.bfs;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ABinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(12);

        root.left = new TreeNode(7);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right= new TreeNode(5);
//		root.left = new TreeNode(7);
//		root.left = new TreeNode(7);

        List<List<Integer>> result = binaryTreeLevelOrderTraversal(root);
        System.out.println("Level Order Traversal = " + result);
    }

    private static List<List<Integer>> binaryTreeLevelOrderTraversal(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            List<Integer> currLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {

                TreeNode currNode = queue.poll();
                currLevel.add(currNode.val);

                if(currNode.left != null){
                    queue.add(currNode.left);
                }
                if(currNode.right != null){
                    queue.add(currNode.right);
                }

            }
            result.add(currLevel);
        }
        return result;
    }

}
