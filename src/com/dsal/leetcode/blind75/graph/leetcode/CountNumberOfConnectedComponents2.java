package com.dsal.leetcode.blind75.graph.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/description/
public class CountNumberOfConnectedComponents2 {

    public static void main(String[] args) {

        int n = 7;
        int[][] edges = {{0,1},{1,2},{3,4},{6,5}};
        System.out.println(countConnectedComponents(n, edges));


        int n1 = 5;
        int[][] edges1 = {{0,1},{1,2},{2,3},{3,4}};
        System.out.println(countConnectedComponents(n1, edges1));

    }

    private static int countConnectedComponents(int n, int[][] edges) {

        List<Integer>[] graph = createGraph(n, edges);

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < graph.length; i++) {
            if(!visited[i]) {
                countConnectedComponentsDfs(i, graph, visited);
                count++;
            }
        }
        return count;
    }

    private static void countConnectedComponentsDfs(int node, List<Integer>[] graph, boolean[] visited) {
        visited[node] = true;

        for (int neighbour : graph[node]) {
            if(!visited[neighbour]) {
                countConnectedComponentsDfs(neighbour, graph, visited);
            }
        }
    }

    private static List<Integer>[] createGraph(int n, int[][] edges) {

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
