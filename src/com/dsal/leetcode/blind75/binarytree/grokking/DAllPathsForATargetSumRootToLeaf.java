 package com.dsal.leetcode.blind75.binarytree.grokking;

import java.util.ArrayList;
import java.util.List;

 public class DAllPathsForATargetSumRootToLeaf {

     public static void main(String[] args) {

         //Refer Video = https://www.youtube.com/watch?v=ojxo9QjPKvA
         // refer video = https://www.youtube.com/watch?v=HyNczj2pEEY

         TreeNode root = new TreeNode(12);
         root.left = new TreeNode(7);
         root.right = new TreeNode(1);

         root.left.left = new TreeNode(9);
         root.left.right = new TreeNode(4);

         root.left.left.left = new TreeNode(20);
         root.left.left.right = new TreeNode(17);

         root.right.left = new TreeNode(10);
         root.right.right= new TreeNode(6);

         root.right.right.left= new TreeNode(4);

         List<List<Integer>> result = allPathsForASumRootToLeaf(root, 23);
         System.out.println("Level Order Traversal = " + result);

         List<List<Integer>> resultV2 = allPathsForASumRootToLeafV2(root, 23);
         System.out.println("Level Order Traversal V2 = " + resultV2);

         List<List<Integer>> resultV3 = allPathsForASumRootToLeafV3(root, 23);
         System.out.println("Level Order Traversal V3 = " + resultV3);

         List<List<Integer>> result1 = allPathsForASumRootToLeaf(root, 28);
         System.out.println("Level Order Traversal = " + result1);

     }

     private static List<List<Integer>> allPathsForASumRootToLeaf(TreeNode root, int targetSum) {

         List<List<Integer>> result = new ArrayList<>();

         allPathsForASumNonDupPath(root, targetSum, 0, new ArrayList<>(), result);

         return result;
     }



     private static void allPathsForASumNonDupPath(TreeNode root, int targetSum, int currSum, List<Integer> currPath, List<List<Integer>> allPaths) {

         if (root == null) {
             return;
         }

         currSum += root.val;
         currPath.add(root.val);

         if(root.left == null && root.right == null && targetSum == currSum){
             allPaths.add(new ArrayList<>(currPath));
         }

         allPathsForASumNonDupPath(root.left, targetSum, currSum, currPath, allPaths);
         allPathsForASumNonDupPath(root.right, targetSum, currSum, currPath, allPaths);

         currPath.removeLast();

     }

     private static List<List<Integer>> allPathsForASumRootToLeafV2(TreeNode root, int targetSum) {

         List<List<Integer>> result = new ArrayList<>();

         allPathsForASumNonDupPathV2(root, targetSum, new ArrayList<>(), result);

         return result;
     }

     private static void allPathsForASumNonDupPathV2(TreeNode root, int targetSum, List<Integer> currPath, List<List<Integer>> allPaths) {

         if (root == null) {
             return;
         }

         currPath.add(root.val);

         if(root.left == null && root.right == null && targetSum == root.val){
             allPaths.add(new ArrayList<>(currPath));
         }

         allPathsForASumNonDupPathV2(root.left, targetSum - root.val, currPath, allPaths);
         allPathsForASumNonDupPathV2(root.right, targetSum - root.val, currPath, allPaths);

         currPath.removeLast(); // backtrack
     }

     private static List<List<Integer>> allPathsForASumRootToLeafV3(TreeNode root, int targetSum) {

         List<List<Integer>> result = new ArrayList<>();

         allPathsForASumNonDupPathV3(root, targetSum, new ArrayList<>(), result);

         return result;
     }

     private static void allPathsForASumNonDupPathV3(TreeNode root, int targetSum, List<Integer> currPath, List<List<Integer>> allPaths) {

         if (root == null) {
             return;
         }

         currPath.add(root.val);

         if(root.left == null && root.right == null && targetSum == root.val){
             allPaths.add(new ArrayList<>(currPath));
         }else {
             allPathsForASumNonDupPathV3(root.left, targetSum - root.val, currPath, allPaths);
             allPathsForASumNonDupPathV3(root.right, targetSum - root.val, currPath, allPaths);
         }
         currPath.removeLast(); // backtrack
     }

     // This will give correct but duplicate results
     private static void allPathsForASum(TreeNode root, int targetSum, int currSum, List<Integer> currPath, List<List<Integer>> allPaths) {

         if (root == null) {
             if(targetSum == currSum){
                 allPaths.add(new ArrayList<>(currPath));
             }
             return;
         }

         currSum += root.val;
         currPath.add(root.val);

         allPathsForASum(root.left, targetSum, currSum, currPath, allPaths);
         allPathsForASum(root.right, targetSum, currSum, currPath, allPaths);

         currPath.removeLast();

     }


 }
