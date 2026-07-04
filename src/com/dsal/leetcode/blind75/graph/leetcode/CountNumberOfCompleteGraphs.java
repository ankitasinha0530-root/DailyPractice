package com.dsal.leetcode.blind75.graph.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/count-the-number-of-complete-components/

public class CountNumberOfCompleteGraphs {

    // Complete graph = all the nodes are connected to each other in graph no leaf nodes or disconnected nodes

    public static void main(String[] args) {

        int n = 6;

        int[][] edges = {{0,1},{0,2},{1,2},{3,4},{3,5}};
        System.out.println(countNumberOfCompleteGraphs(n, edges));

        int[][] edges2 = {{0,1},{0,2},{1,2},{3,4}};
        System.out.println(countNumberOfCompleteGraphs(n, edges2));

    }

    private static int countNumberOfCompleteGraphs(int n, int[][] edges) {

        List<List<Integer>> graph = createGraph(n, edges);

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < graph.size(); i++) {

            if(!visited[i]) {
                List<Integer> graphComponents = new ArrayList<>();
                getGraphComponentsDfs(i, graph, graphComponents, visited);
                if(completeGraphComponents(graphComponents, graph)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void getGraphComponentsDfs(int source, List<List<Integer>> graph, List<Integer> graphComponents, boolean[] visited) {

        graphComponents.add(source);
        visited[source] = true;

        for (int neighbour : graph.get(source)) {
            if(!visited[neighbour]) {
                getGraphComponentsDfs(neighbour, graph, graphComponents, visited);
            }
        }
    }

    private static boolean completeGraphComponents(List<Integer> graphComponents, List<List<Integer>> graph) {

        for (int component : graphComponents) {
            if(graph.get(component).size() != graphComponents.size() - 1) {
                return false;
            }
        }
        return true;
    }

    private static List<List<Integer>> createGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}
