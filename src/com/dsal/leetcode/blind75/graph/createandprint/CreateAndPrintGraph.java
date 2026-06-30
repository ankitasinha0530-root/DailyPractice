package com.dsal.leetcode.blind75.graph.createandprint;

import java.util.ArrayList;
import java.util.List;

public class CreateAndPrintGraph {

    public static void main(String[] args) {

        int n = 4; // vertices: 0,1,2,3

        // Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        System.out.println(graph);

        // Add undirected edges
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 3);

        // Print graph
        printGraph(graph);
    }

    private static void addEdge(List<List<Integer>> graph, int u, int v) {

        // Since graph is undirected,
        // add both directions.

        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    private static void printGraph(List<List<Integer>> graph) {

        for (int i = 0; i < graph.size(); i++) {

            System.out.print(i + " -> ");

            for (int neighbour : graph.get(i)) {
                System.out.print(neighbour + " ");
            }

            System.out.println();
        }
    }
}
