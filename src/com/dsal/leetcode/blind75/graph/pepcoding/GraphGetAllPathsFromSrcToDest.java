package com.dsal.leetcode.blind75.graph.pepcoding;

import java.util.ArrayList;
import java.util.List;

public class GraphGetAllPathsFromSrcToDest {

    public static void main(String[] args) {

        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        int source = 0;
        int destination = 5;

        System.out.println(getAllPathsFromSrcToDest(n, edges, source, destination)); // False

        System.out.println();

        int n1 = 3;
        int[][] edges1 = {{0, 1}, {0, 2}, {2, 1}};
        int source1 = 0;
        int destination1 = 2;

        System.out.println(getAllPathsFromSrcToDest(n1, edges1, source1, destination1)); // True

        System.out.println();

        int n2 = 6;
        int[][] edges2 = {{0, 1}, {0, 2}, {2, 3}, {3, 5}, {5, 4}, {4, 3}};
        int source2 = 0;
        int destination2 = 5;

        System.out.println(getAllPathsFromSrcToDest(n2, edges2, source2, destination2)); // True

    }

    private static List<String> getAllPathsFromSrcToDest(int n, int[][] edges, int source,
                                               int destination) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        List<String> result = new ArrayList<>();
        getAllPathsFromSrcToDestHelper(graph, source, destination, "" + source, result, visited);

        return result;

    }

    private static void getAllPathsFromSrcToDestHelper(List<List<Integer>> graph, int source, int destination,
                                                       String currPath, List<String> result, boolean[] visited) {

        if (source == destination) {
            result.add(currPath);
            return;
        }

        visited[source] = true;

        for (int nbr : graph.get(source)) {
            if (!visited[nbr]) {
                getAllPathsFromSrcToDestHelper(graph, nbr, destination, currPath +"-"+ nbr, result, visited);
            }
        }
        visited[source] = false;
    }

}
