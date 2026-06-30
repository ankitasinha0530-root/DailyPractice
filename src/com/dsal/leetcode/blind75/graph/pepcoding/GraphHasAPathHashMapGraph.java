package com.dsal.leetcode.blind75.graph.pepcoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphHasAPathHashMapGraph {

    public static void main(String[] args) {

        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        int source = 0;
        int destination = 5;

        System.out.println(checkIfGraphHasAPath(n, edges, source, destination)); // False

        int n1 = 3;
        int[][] edges1 = {{0, 1}, {0, 2}, {2, 1}};
        int source1 = 0;
        int destination1 = 2;

        System.out.println(checkIfGraphHasAPath(n1, edges1, source1, destination1)); // True
    }

    private static boolean checkIfGraphHasAPath(int n, int[][] edges, int source, int destination) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            // since undirected graph hence add in both
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        boolean[] visited = new boolean[n];
        return checkIfGraphHasAPathHelper(graph, source, destination, visited);
    }

    private static boolean checkIfGraphHasAPathHelper(Map<Integer, List<Integer>> graph, int source,
                                                      int destination, boolean[] visited) {
        if (source == destination) {
            return true;
        }

        visited[source] = true;

        List<Integer> neighbour = graph.getOrDefault(source, new ArrayList<>());

        for(int nbr : neighbour) {

            if(!visited[nbr]) {
                boolean hasPath = checkIfGraphHasAPathHelper(graph, nbr, destination, visited);

                if (hasPath) {
                    return true;
                }
            }
        }
        return false;
    }



}
