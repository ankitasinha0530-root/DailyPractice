package com.dsal.leetcode.blind75.graph.pepcoding;

import java.util.ArrayList;

public class CFindLargestPathByWeight {

	static String largestPath;
	static int largestPathByWeight = Integer.MIN_VALUE;

	public static void main(String[] args) {

		int n = 6;

		ArrayList<Edge>[] graph = new ArrayList[n]; // graph also called as adjacency list

		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		graph[0].add(new Edge(0, 1, 10));

		graph[1].add(new Edge(1, 0, 10));
		graph[1].add(new Edge(1, 2, 5));
		graph[1].add(new Edge(1, 3, 15));

		graph[2].add(new Edge(2, 1, 5));
		graph[2].add(new Edge(2, 3, 20));
		graph[2].add(new Edge(2, 4, 30));

		graph[3].add(new Edge(3, 2, 20));
		graph[3].add(new Edge(3, 1, 15));
		graph[3].add(new Edge(3, 4, 5));
		graph[3].add(new Edge(3, 5, 105));

		graph[4].add(new Edge(4, 3, 5));
		graph[4].add(new Edge(4, 2, 30));
		graph[4].add(new Edge(4, 5, 50));

		graph[5].add(new Edge(5, 3, 105));
		graph[5].add(new Edge(5, 4, 50));

		boolean[] visited = new boolean[graph.length];
		largestWightedPath(graph, 0, 5, visited, 0 + "", 0);
		System.out.println("largestPath = " + largestPath + ", largestPathWeight = " + largestPathByWeight);

	}

	private static void largestWightedPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String pathSoFar,
			int weightSoFar) {

		if(src == dest) {
			if (weightSoFar > largestPathByWeight) { // cant do math.max here coz we are also storing pathSoFar if weight is largest
				largestPathByWeight = weightSoFar;
				largestPath = pathSoFar;
			}
			return;
		}

		visited[src] = true;

		for (Edge nbrEdge : graph[src]) {
			if (!visited[nbrEdge.nbr]) {
				largestWightedPath(graph, nbrEdge.nbr, dest, visited, pathSoFar + nbrEdge.nbr, weightSoFar + nbrEdge.wt);
			}
		}
		visited[src] = false;
	}

}
