package com.dsal.leetcode.blind75.binarytree.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class IsCousines {

    // Cousin when children at same level but different parent Nodes

    public static void main(String[] args) {

        TreeNode root = new TreeNode(12);

        root.left = new TreeNode(7);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(9);


        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);

        root.right.right.right = new TreeNode(15);


        System.out.println(isCousins(root, 7, 1)); // false

        System.out.println(isCousins(root, 9, 10)); // true

        System.out.println(isCousins(root, 17, 15)); // true

        System.out.println(isCousins(root, 17, 25)); // true

    }

    public static boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {

            int levelSize = queue.size();
            boolean foundX = false;
            boolean foundY = false;

            for (int i = 0; i < levelSize; i++) {

                TreeNode currNode = queue.poll();

                if(currNode.val == x) {
                    foundX = true;
                }
                if(currNode.val == y) {
                    foundY = true;
                }

                if(currNode.left != null) {
                    queue.add(currNode.left);
                }
                if(currNode.right != null) {
                    queue.add(currNode.right);
                }

                if(currNode.left != null && currNode.right != null) {
                    if ((currNode.left.val == x && currNode.right.val == y) || (currNode.right.val == x && currNode.left.val == y)){
                        return false;
                    }
                }
            }
            if(foundX && foundY) {
                return true;
            }
            if(foundX || foundY) {
                return false;
            }

        }
        return false;

    }
    // public boolean isCousins(TreeNode root, int x, int y) {

    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.add(root);

    //     while(!queue.isEmpty()) {

    //         int levelSize = queue.size();

    //         Set<Integer> set = new HashSet<>();

    //         for (int i = 0; i < levelSize; i++) {

    //             TreeNode currNode = queue.poll();

    //             if(currNode.left != null) {
    // 				queue.add(currNode.left);
    //                 set.add(currNode.left.val);
    // 			}
    // 			if(currNode.right != null) {
    // 				queue.add(currNode.right);
    //                 set.add(currNode.right.val);
    // 			}
    //             if(currNode.left != null && currNode.right != null && ((currNode.left.val == x && currNode.right.val == y) || (currNode.right.val == x && currNode.left.val == y))){
    //                 return false;
    //             }
    //         }
    //         System.out.println(set);
    //         if(set.contains(x) && set.contains(y)){
    //             return true;
    //         }

    //     }
    //     return false;


    // }
}
