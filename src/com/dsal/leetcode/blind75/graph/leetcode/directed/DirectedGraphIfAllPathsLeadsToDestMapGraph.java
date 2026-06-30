package com.dsal.leetcode.blind75.graph.leetcode.directed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectedGraphIfAllPathsLeadsToDestMapGraph {

    public static void main(String[] args) {

        int n = 3;
        int[][] edges = {{0, 1}, {0, 2}};
        int source = 0;
        int destination = 2;
        System.out.println(leadsToDestinationMapGraph(n, edges, source, destination));

        int n1 = 4;
        int[][] edges1 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        int source1 = 0;
        int destination1 = 3;
        System.out.println(leadsToDestinationMapGraph(n1, edges1, source1, destination1));
        }

        // Correct, but worst Performance
    public static boolean leadsToDestinationMapGraph(int n, int[][] edges, int source, int destination){

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }

        int[] state = new int[n]; // always make visited or state equal to number of nodes in graph

        return leadsToDestinationHelper(graph, source, destination, state);
    }

    private static boolean leadsToDestinationHelper(Map<Integer, List<Integer>> graph, int source, int destination, int[] state) {

        if(state[source] == 1) {
            return false; // cycle is detected in directed graph, can never reach to destination
        }

        if(state[source] == 2) {
            return true; // from here all neighbours reach to destination, we have established that
        }

        if(graph.get(source) == null || graph.get(source).isEmpty()) {
            return source == destination;
        }

        for (int nbr : graph.get(source)) {
            boolean hasPath = leadsToDestinationHelper(graph, nbr, destination, state);
            if(!hasPath){
                return false;
            }
        }
        state[source] = 2;
        return true;
    }
}
