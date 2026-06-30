package com.dsal.leetcode.blind75.graph.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphAllPathsSourceToTargetDFS {

    public static void main(String[] args) {

        int n = 3;
        int[][] edges = {{0, 1}, {0, 2}, {2, 1}};
        int source = 0;
        int destination = 2;

        int[][] graph = createGraph(edges, n);
        System.out.println(allPathsSourceTargetDfs(graph));

        System.out.println();
        int n2 = 6;
        int[][] edges2 = {{0, 1}, {0, 2}, {2, 3}, {3, 5}, {5, 4}, {4, 3}};
        int source2 = 0;
        int destination2 = 5;
        int[][] graph2 = createGraph(edges2, n2);

        System.out.println(allPathsSourceTargetDfs(graph2));
    }

    private static int[][] createGraph(int[][] edges, int n) {

        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        int[][] graph = new int[n][];

        for (int i = 0; i < n; i++) {
            graph[i] = adj[i]
                    .stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        }
        System.out.println(Arrays.deepToString(graph));
        return graph;
    }

    //    Accepted by Leetcode, all test cases passed
    public static List<List<Integer>> allPathsSourceTargetDfs(int[][] graph) {

        int source = 0;
        int destination = graph.length - 1;
        List<List<Integer>> result = new ArrayList<>();

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
            if(state[nbr] == 0) {
                allPathsSourceTargetDfs(graph, nbr, destination, currPath, result, state);
            }
        }
        currPath.removeLast();
        state[source] = 0;

    }
}
