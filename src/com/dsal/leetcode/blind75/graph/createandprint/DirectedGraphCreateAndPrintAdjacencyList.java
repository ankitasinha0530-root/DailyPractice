package com.dsal.leetcode.blind75.graph.createandprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectedGraphCreateAndPrintAdjacencyList {

    public static void main(String[] args) {

        int n = 6;

        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 3},
                {2, 3},
                {3, 4},
                {4, 5}
        };

        Map<Integer, List<Integer>> graph = createAndPrintDirectedGraph(n, edges);

        printDirectedGraph(graph, n);

    }

    private static Map<Integer, List<Integer>> createAndPrintDirectedGraph(int n, int[][] edges) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Initialize all vertices.
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Add only one direction: u -> v
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
        }

        return graph;
    }

    private static void printDirectedGraph(Map<Integer, List<Integer>> graph, int n) {

        for (int i = 0; i < n; i++) {

            System.out.print(i + " -> ");

            for (int neighbour : graph.get(i)) {
                System.out.print(neighbour + " ");
            }

            System.out.println();
        }
    }
}
