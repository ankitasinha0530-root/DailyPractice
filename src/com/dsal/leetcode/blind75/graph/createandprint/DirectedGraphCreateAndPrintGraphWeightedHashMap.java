package com.dsal.leetcode.blind75.graph.createandprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectedGraphCreateAndPrintGraphWeightedHashMap {

    public static void main(String[] args) {

        int n = 4;

        int[][] edges = {
                {0, 1, 4},
                {0, 2, 2},
                {1, 3, 5},
                {2, 3, 1}
        };

        Map<Integer, List<Edge>> graph = createWeightedDirectedGraph(n, edges);

        printDirectedWeightedGraph(n, graph);
    }

    private static Map<Integer, List<Edge>> createWeightedDirectedGraph(int n, int[][] edges) {

        Map<Integer, List<Edge>> graph = new HashMap<>();

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Edge(u, v, weight));
        }

        return graph;
    }


    private static void printDirectedWeightedGraph(int n, Map<Integer, List<Edge>> graph) {

        for (int i = 0; i < graph.size(); i++) {

            System.out.print(i + " -> ");

            for (Edge edge : graph.get(i)) {
                System.out.print("(" + edge.source + ", " + edge.destination + ", " + edge.weight + ") ");
            }

            System.out.println();
        }
    }

    static class Edge {
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

}
