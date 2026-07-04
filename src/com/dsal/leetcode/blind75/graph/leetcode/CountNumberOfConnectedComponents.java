package com.dsal.leetcode.blind75.graph.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/description/
public class CountNumberOfConnectedComponents {

    public static void main(String[] args) {

        int n = 7;
        int[][] edges = {{0,1},{1,2},{3,4},{6,5}};
        System.out.println(countConnectedComponents(n, edges));


        int n1 = 5;
        int[][] edges1 = {{0,1},{1,2},{2,3},{3,4}};
        System.out.println(countConnectedComponents(n1, edges1));

    }

    private static int countConnectedComponents(int n, int[][] edges) {

        List<List<Integer>> graph = createGraph(n, edges);

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < graph.size(); i++) {
            if(!visited[i]) {
                countConnectedComponentsDfs(i, graph, visited);
                count++;
            }
        }
        return count;
    }

    private static void countConnectedComponentsDfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;

        for (int neighbour : graph.get(node)) {
            if(!visited[neighbour]) {
                countConnectedComponentsDfs(neighbour, graph, visited);
            }
        }
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
