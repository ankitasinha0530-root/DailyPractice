package com.dsal.leetcode.blind75.graph.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphHasAPathAdjacencyListBFS {

    public static void main(String[] args) {

        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        int source = 0;
        int destination = 5;

        System.out.println(checkIfGraphHasAPath(n, edges, source, destination)); // False

        int n1 = 3;
        int[][] edges1 = {{0, 1}, {0, 2}, {2, 1}};
        int source1 = 0;
        int destination1 = 2;

        System.out.println(checkIfGraphHasAPath(n1, edges1, source1, destination1)); // True
    }

    private static boolean checkIfGraphHasAPath(int n, int[][] edges, int source, int destination) {

        // Create Graph Using Adjacency List
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            // since undirected graph hence add in both
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(source);
        visited[source] = true;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            if(current == destination) {
                return true;
            }

            for (int nbr : graph.get(current)) {
                if(!visited[nbr]) {
                    queue.offer(nbr);
                    visited[nbr] = true;
                }
            }
        }
        return visited[destination];
    }
}
