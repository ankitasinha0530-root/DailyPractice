package com.dsal.leetcode.blind75.binarytree;

import com.sun.source.tree.Tree;

import java.util.*;

public class AllNodesAtKdistanceFromTargetNodeLevelOrder {
    // https://www.youtube.com/watch?v=i9ORlEy6EsI
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode target = root.left;
        int k = 2;

        System.out.println(allNodesAtKdistanceFromTargetNode(root, target, k));

    }

    private static List<Integer> allNodesAtKdistanceFromTargetNode(TreeNode root, TreeNode target, int k) {

        // First Create Child Parent relationship
        Map<Integer, TreeNode> parent = createAndGetChildVsParentMpap(root);

        Map<TreeNode, Boolean> visited = new HashMap<>();

        List<Integer> result = new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        
        while(!queue.isEmpty() && k > 0) {
            
            int levelSize = queue.size();
            k--;

            for (int i = 0; i < levelSize; i++) {

                TreeNode currNode = queue.poll();

                visited.put(currNode, true);

                if(parent.get(currNode.val) != null && visited.get(parent.get(currNode.val)) == null){ //check in visited if parent to currNode is visited
                    queue.add(parent.get(currNode.val));
                }
                if(currNode.left != null && visited.get(currNode.left) == null){ // check in visited if left is visited
                    queue.add(currNode.left);
                }
                if(currNode.right != null && visited.get(currNode.right) == null){ // check in visited if right is visited
                    queue.add(currNode.right);
                }
                
            }
        }
        System.out.println("queue : " + queue);
        while (!queue.isEmpty()){
            result.add(queue.poll().val);
        }

        return result;
    }

    private static Map<Integer, TreeNode> createAndGetChildVsParentMpap(TreeNode root) {

        Map<Integer, TreeNode> childParent = new HashMap<>();
        childParent.put(root.val, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {

                TreeNode currNode = queue.poll();

                if (currNode.left != null) {
                    queue.add(currNode.left);
                    childParent.put(currNode.left.val, currNode);
                }

                if (currNode.right != null) {
                    queue.add(currNode.right);
                    childParent.put(currNode.right.val, currNode);
                }
            }
        }
        System.out.println(childParent);
        return childParent;
    }

}
