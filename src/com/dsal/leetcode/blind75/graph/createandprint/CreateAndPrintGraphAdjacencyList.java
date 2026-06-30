package com.dsal.leetcode.blind75.graph.createandprint;

import java.util.ArrayList;
import java.util.List;

public class CreateAndPrintGraphAdjacencyList {

    public static void main(String[] args) {

        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};

        List<List<Integer>> graph = createAndPrintGraphAdjacencyList(n, edges);

        int n1 = 3;
        int[][] edges1 = {{0, 1}, {0, 2}, {2, 1}};

        List<List<Integer>> graph1 = createAndPrintGraphAdjacencyList(n1, edges1);

        printAdjacencyListGraph(graph);
        System.out.println();
        printAdjacencyListGraph(graph1);

        System.out.println();

        printAdjacencyListGraphV2(graph);
        System.out.println();
        printAdjacencyListGraphV2(graph1);

    }

    private static List<List<Integer>> createAndPrintGraphAdjacencyList(int n, int[][] edges) {

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
        return graph;
    }

    private static void printAdjacencyListGraph(List<List<Integer>> graph) {

        for (int i = 0; i <graph.size() ; i++) {

            System.out.print(i + " -> ");

            for (int nbr : graph.get(i)){
                System.out.print(nbr + ", ");
            }
            System.out.println();
        }
    }

    private static void printAdjacencyListGraphV2(List<List<Integer>> graph) {

        for (int i = 0; i < graph.size() ; i++) {

            System.out.print(i + " -> ");

            List<Integer> neighbour = graph.get(i);

            for (int j = 0; j < neighbour.size(); j++) {

                if (j == neighbour.size() - 1) {
                    System.out.print(neighbour.get(j));
                } else {
                    System.out.print(neighbour.get(j) + ", ");
                }
            }
            System.out.println();
        }
    }
}
