package com.dsal.leetcode.blind75.graph.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/count-the-number-of-complete-components/

public class CountNumberOfCompleteGraphs2 {

    // Complete graph = all the nodes are connected to each other in graph no leaf nodes or disconnected nodes

    public static void main(String[] args) {

        int n = 6;

        int[][] edges = {{0,1},{0,2},{1,2},{3,4},{3,5}};
        System.out.println(countNumberOfCompleteGraphs(n, edges));

        int[][] edges2 = {{0,1},{0,2},{1,2},{3,4}};
        System.out.println(countNumberOfCompleteGraphs(n, edges2));

    }

    private static int countNumberOfCompleteGraphs(int n, int[][] edges) {

        List<Integer>[] graph = createGraph(n, edges);

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < graph.length; i++) {
            List<Integer> graphComponent = new ArrayList<>();
            if(!visited[i]) {
                getGraphComponentsDfs(i, graph, graphComponent, visited);
                if(isCompleteGraph(graph, graphComponent)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void getGraphComponentsDfs(int source, List<Integer>[] graph, List<Integer> graphComponent, boolean[] visited) {

        graphComponent.add(source);
        visited[source] = true;

        for (int neighbour : graph[source]) {
            if(!visited[neighbour]) {
                getGraphComponentsDfs(neighbour, graph, graphComponent, visited);
            }
        }
    }

    private static boolean isCompleteGraph(List<Integer>[] graph, List<Integer> graphComponent) {

        for(int comp : graphComponent) {
            if(graph[comp].size() != graphComponent.size() - 1){
                return false;
            }
        }

        return true;
    }

    private static  List<Integer>[] createGraph(int n, int[][] edges) {

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return graph;
    }
}
