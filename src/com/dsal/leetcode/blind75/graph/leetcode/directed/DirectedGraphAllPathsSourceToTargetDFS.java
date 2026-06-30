package com.dsal.leetcode.blind75.graph.leetcode.directed;

import java.util.*;

public class DirectedGraphAllPathsSourceToTargetDFS {

    public static void main(String[] args) {

        int[][] graph = {{4,3,1}, {3,2,4}, {3}, {4}, {}};
        System.out.println(allPathsSourceTargetDfs(graph));
    }

//    Accepted by Leetcode, all test cases passed
    public static List<List<Integer>> allPathsSourceTargetDfs(int[][] graph) {

        int source = 0;
        int destination = graph.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();

        int[] state = new int[graph.length];

        allPathsSourceTargetDfs(graph, source, destination, new ArrayList<>(), result, state);

        return result;


    }

    public static void allPathsSourceTargetDfs(int[][] graph, int source, int destination, List<Integer> currPath, List<List<Integer>> result, int[] state) {


        state[source] = 1;

        currPath.add(source);

        if(source == destination){
            System.out.println("result = " +  result);
            result.add(new ArrayList<>(currPath));
            currPath.removeLast(); // since we are returning from here hence remove the source as it has no child nodes
            state[source] = 0;
            return;
        }

        for (int nbr : graph[source]) {
            allPathsSourceTargetDfs(graph, nbr, destination, currPath, result, state);
        }
        currPath.removeLast();
        state[source] = 0;

    }
}
