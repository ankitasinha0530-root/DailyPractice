package com.dsal.leetcode.blind75.graph.createandprint;

import java.util.ArrayList;
import java.util.List;

public class CreateAndPrintGraphArrayOfList {

    public static void main(String[] args) {

        int n = 4; // vertices: 0,1,2,3

        // Create adjacency list
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
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

    private static void addEdge(List<Integer>[] graph, int u, int v) {

        // Since graph is undirected, hence add both directions.

        graph[u].add(v);
        graph[v].add(u);
    }

    private static void printGraph(List<Integer>[] graph) {

        for (int i = 0; i < graph.length; i++) {

            System.out.print(i + " -> ");

            for (int neighbour : graph[i]) {
                System.out.print(neighbour + " ");
            }

            System.out.println();
        }
    }
}
