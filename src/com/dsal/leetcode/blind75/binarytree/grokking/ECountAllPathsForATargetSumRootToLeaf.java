 package com.dsal.leetcode.blind75.binarytree.grokking;

import java.util.ArrayList;
import java.util.List;

 public class ECountAllPathsForATargetSumRootToLeaf {
     static int count = 0;
     public static void main(String[] args) {

         //Refer Video = https://www.youtube.com/watch?v=ojxo9QjPKvA
         // refer video = https://www.youtube.com/watch?v=HyNczj2pEEY

         TreeNode root = new TreeNode(12);
         root.left = new TreeNode(7);
         root.right = new TreeNode(1);

         root.left.left = new TreeNode(9);
         root.left.right = new TreeNode(11);

         root.left.left.left = new TreeNode(20);
         root.left.left.right = new TreeNode(17);

         root.right.left = new TreeNode(10);
         root.right.right= new TreeNode(6);

         root.right.right.left= new TreeNode(4);

         System.out.println(countAllPathsForASum(root, 23));

         count = 0;
         System.out.println(countAllPathsForASumV2(root, 23));

         count = 0;
         System.out.println(countAllPathsForASum(root, 28));

         count = 0;
         System.out.println(countAllPathsForASum(root, 30));

         count = 0;
         System.out.println(countAllPathsForASumV2(root, 30));

         count = 0;
         System.out.println(countAllPathsForASum(root, 18));

         count = 0;
         System.out.println(countAllPathsForASum(root, 21));

     }

     private static int countAllPathsForASum(TreeNode root, int targetSum) {

         countAllPathsForASumHelper(root, targetSum, 0);

         return count;

     }

     private static void countAllPathsForASumHelper(TreeNode root, int targetSum, int currSum) {

         if (root == null){
             return;
         }

         currSum += root.val;

         if(root.left == null && root.right == null && targetSum == currSum){
             count++;
         }

         countAllPathsForASumHelper(root.left, targetSum, currSum);
         countAllPathsForASumHelper(root.right, targetSum, currSum);

     }

     private static int countAllPathsForASumV2(TreeNode root, int targetSum) {

         countAllPathsForASumHelperV2(root, targetSum, 0);

         return count;

     }

     private static void countAllPathsForASumHelperV2(TreeNode root, int targetSum, int currSum) {

         if (root == null){
             return;
         }

         currSum += root.val;

         if(root.left == null && root.right == null && targetSum == currSum){
             count++;
         }else {
             countAllPathsForASumHelperV2(root.left, targetSum, currSum);
             countAllPathsForASumHelperV2(root.right, targetSum, currSum);
         }

     }


 }
