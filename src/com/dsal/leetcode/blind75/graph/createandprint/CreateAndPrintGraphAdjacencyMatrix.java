package com.dsal.leetcode.blind75.graph.createandprint;

import java.util.Arrays;

public class CreateAndPrintGraphAdjacencyMatrix {

    public static void main(String[] args) {

        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};

        int[][] graph = createAndPrintGraphAdjacencyMatrix (n, edges);

        int n1 = 3;
        int[][] edges1 = {{0, 1}, {0, 2}, {2, 1}};

        int[][] graph1 = createAndPrintGraphAdjacencyMatrix(n1, edges1);

        System.out.println(Arrays.deepToString(graph));
        System.out.println();
        System.out.println(Arrays.deepToString(graph1));

        System.out.println();
        printMatrixGraph(graph);
        System.out.println();
        printMatrixGraph(graph1);
    }

    private static int[][] createAndPrintGraphAdjacencyMatrix(int n, int[][] edges) {

        int[][] graph = new int[n][n];

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph[u][v] = 1;
            graph[v][u] = 1;

        }
        return graph;
    }

    private static void printMatrixGraph(int[][] graph) {

        for (int i = 0; i < graph.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < graph[i].length; j++) {
                if(j == graph[i].length - 1) {
                    System.out.print(graph[i][j]);
                } else {
                    System.out.print(graph[i][j] + ", ");
                }
            }
            System.out.print(" ]");
            System.out.println();

        }

    }
}
