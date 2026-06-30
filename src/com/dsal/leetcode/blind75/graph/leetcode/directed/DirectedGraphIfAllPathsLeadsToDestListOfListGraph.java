package com.dsal.leetcode.blind75.graph.leetcode.directed;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraphIfAllPathsLeadsToDestListOfListGraph {

    public static void main(String[] args) {

        int n = 3;
        int[][] edges = {{0, 1}, {0, 2}};
        int source = 0;
        int destination = 2;
        System.out.println(leadsToDestinationListOfListGraph(n, edges, source, destination));

        int n1 = 4;
        int[][] edges1 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        int source1 = 0;
        int destination1 = 3;
        System.out.println(leadsToDestinationListOfListGraph(n1, edges1, source1, destination1));
    }

    // Better Performance than Map Graph, worst than Array of List Graph
    public static boolean leadsToDestinationListOfListGraph(int n, int[][] edges, int source, int destination){

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        // 0 = unvisited
        // 1 = visiting (currently in recursion stack)
        // 2 = processed (already verified good)
        int[] state = new int[n]; // always make visited or state equal to number of nodes in graph

        return leadsToDestinationListOfListGraphHelper(graph, source, destination, state);
    }

    private static boolean leadsToDestinationListOfListGraphHelper(List<List<Integer>> graph, int source, int destination, int[] state) {

        // Revisited while on current DFS path => cycle
        if(state[source] == 1) {
            return false; // cycle is detected in directed graph, can never reach to destination
        }

        // Already verified
        if(state[source] == 2) {
            return true; // from here all neighbours reach to destination, we have established that
        }
        // Terminal node
        if(graph.get(source) == null || graph.get(source).isEmpty()) {
            return source == destination;
        }

        for (int nbr : graph.get(source)) {
            boolean hasPath = leadsToDestinationListOfListGraphHelper(graph, nbr, destination, state);
            if(!hasPath){
                return false;
            }
        }
        state[source] = 2;
        return true;
    }
}
