package com.dsal.leetcode.blind75.binarytree.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class GCurrentLevelOrderSibling {

    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/

    static class TreeNode {
        int val = 0;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        public TreeNode(int val) {
            this.val = val;
        }

        //	level order traversal using next pointer
        void printLevelOrder() {
            TreeNode nextLevelRoot = this;
            while (nextLevelRoot != null) {
                TreeNode current = nextLevelRoot;
                nextLevelRoot = null;
                while (current != null) {
                    System.out.print(current.val + " ");
                    if (nextLevelRoot == null) {
                        if (current.left != null) {
                            nextLevelRoot = current.left;
                        } else if (current.right != null) {
                            nextLevelRoot = right.left;
                        }
                    }
                    current = current.next;
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

		TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);


        traverseConnect(root);
        System.out.println("Level Order Traversal using next pointer = ");
		root.printLevelOrder();

    }

    private static TreeNode traverseConnect(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            int levelSize = queue.size();
			TreeNode prev = null;

            for (int i = 0; i < levelSize; i++) {

				TreeNode currNode = queue.poll();

                if (prev != null) {
                    prev.next = currNode;
                }
                prev = currNode;

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            prev = null;
        }

        return root;
    }

}

//class Node {
//    public int val;
//    public Node left;
//    public Node right;
//    public Node next;
//
//    public Node() {
//    }
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, Node _left, Node _right, Node _next) {
//        val = _val;
//        left = _left;
//        right = _right;
//        next = _next;
//    }

