package com.dsal.leetcode.blind75.graph.leetcode.directed;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraphIfAllPathsLeadsToDestArrayOfListGraph {

    public static void main(String[] args) {

        int n = 3;
        int[][] edges = {{0, 1}, {0, 2}};
        int source = 0;
        int destination = 2;
        System.out.println(leadsToDestinationListAndArrayGraph(n, edges, source, destination));

        int n1 = 4;
        int[][] edges1 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        int source1 = 0;
        int destination1 = 3;
        System.out.println(leadsToDestinationListAndArrayGraph(n1, edges1, source1, destination1));
    }

    // Best Performance
    public static boolean leadsToDestinationListAndArrayGraph(int n, int[][] edges, int source, int destination){

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }

        // 0 = unvisited
        // 1 = visiting (currently in recursion stack)
        // 2 = processed (already verified good)
        int[] state = new int[n]; // always make visited or state equal to number of nodes in graph

        return leadsToDestinationListAndArrayGraphHelper(graph, source, destination, state);
    }

    private static boolean leadsToDestinationListAndArrayGraphHelper(List<Integer>[] graph, int source, int destination, int[] state) {

        // Revisited while on current DFS path => cycle
        if(state[source] == 1) {
            return false; // cycle is detected in directed graph, can never reach to destination
        }

        // Already verified
        if(state[source] == 2) {
            return true; // from here all neighbours reach to destination, we have established that
        }
        // Terminal node
        if(graph[source] == null || graph[source].isEmpty()) {
            return source == destination;
        }

        for (int nbr : graph[source]) {
            boolean hasPath = leadsToDestinationListAndArrayGraphHelper(graph, nbr, destination, state);
            if(!hasPath){
                return false;
            }
        }
        state[source] = 2;
        return true;
    }
}
