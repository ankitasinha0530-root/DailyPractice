package com.dsal.leetcode.blind75.graph.leetcode.directed;

import java.util.*;

public class DirectedGraphAllPathsSourceToTarget {

    public static void main(String[] args) {

        int[][] graph = {{4,3,1}, {3,2,4}, {3}, {4}, {}};
        System.out.println(allPathsSourceTargetBfs(graph));
    }

    public static List<List<Integer>> allPathsSourceTargetBfs(int[][] graph) {

        List<List<Integer>> result = new ArrayList<>();

        int source = 0;
        int destination = graph.length - 1;

        int[] visited = new int[graph.length];

        List<Integer> currPath = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(source);
        visited[source] = 1;

        while (!queue.isEmpty()) {

            int curr = queue.poll();
            System.out.println("curr = " + curr);
            currPath.add(curr);

            if(curr == destination) {
                System.out.println("In result Base case");
                result.add(new ArrayList<>(currPath));
                currPath.removeLast();
                visited[curr] = 0;
                System.out.println("Visited in result  = " + Arrays.toString(visited));
                continue;
            }
            System.out.println("graph of Curr = " + Arrays.toString(graph[curr]));
            for(int nbr : graph[curr]) {
                if(visited[nbr] == 0) {
                    queue.offer(nbr);
                    visited[nbr] = 1;
                }
            }
            System.out.println("currPath = "+ currPath);
            System.out.println("queue = " + queue);
            System.out.println("Result in while = " + result);
            System.out.println("visited = " + Arrays.toString(visited));
            System.out.println();
        }
        System.out.println("Result = " + result);
        return result;
    }
}
