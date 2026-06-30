package com.dsal.leetcode.blind75.graph.createandprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateAndPrintGraphHashMap {

    public static void main(String[] args) {

        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};

        Map<Integer, List<Integer>> graph = createAndPrintGraphHashMap(n, edges);

        int n1 = 3;
        int[][] edges1 = {{0, 1}, {0, 2}, {2, 1}};

        Map<Integer, List<Integer>> graph1 = createAndPrintGraphHashMap(n1, edges1);

        printMapGraph(graph);
        System.out.println();
        printMapGraph(graph1);

        System.out.println();
        printMapGraphV2(graph);
        System.out.println();
        printMapGraphV2(graph1);
    }

    private static Map<Integer, List<Integer>> createAndPrintGraphHashMap(int n, int[][] edges) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        return graph;
    }


    private static void printMapGraph(Map<Integer, List<Integer>> graph) {

        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + " -> ");

            for (int neighbour : graph.get(i)){

                System.out.print(neighbour + ", ");
            }
            System.out.println();
        }
    }

    private static void printMapGraphV2(Map<Integer, List<Integer>> graph) {

        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + " -> ");

            List<Integer> neighbour = graph.get(i);
            for (int j = 0; j < neighbour.size(); j++) {

                if(j == neighbour.size() - 1){
                    System.out.print(neighbour.get(j));
                }else {
                    System.out.print(neighbour.get(j) + ", ");
                }
            }

            System.out.println();
        }

    }

}
