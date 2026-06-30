package com.dsal.leetcode.blind75.graph.createandprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateAndPrintGraphWeightedUnDirectedHashMap {

    public static void main(String[] args) {

        int n = 4;

        int[][] edges = {
                {0, 1, 15},
                {0, 2, 16},
                {1, 3, 14},
                {2, 3, 20}
        };

        Map<Integer, List<Edge>> graph = createWeightedUnDirectedGraph(n, edges);

        printUnDirectedWeightedGraph(n, graph);
    }

    private static Map<Integer, List<Edge>> createWeightedUnDirectedGraph(int n, int[][] edges) {

        Map<Integer, List<Edge>> graph = new HashMap<>();

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Edge(u, v, weight));
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Edge(v, u, weight));
        }

        return graph;
    }


    private static void printUnDirectedWeightedGraph(int n, Map<Integer, List<Edge>> graph) {

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
