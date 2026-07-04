package com.dsal.leetcode.blind75.graph.pepcoding;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class EFindPathWeightCielValOfk {
	
	static String ceilPath;
	static int ceilPathWt = Integer.MAX_VALUE;

	static PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

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
		graph[4].add(new Edge(4, 5, 15));

		graph[5].add(new Edge(5, 3, 105));
		graph[5].add(new Edge(5, 4, 15));

		boolean[] visited = new boolean[n];

		findPathWeightCeilValOfK(graph, visited, 0, 5, 45, 0 + "", 0);
		System.out.println("ceilPath = " + ceilPath + ", ceilPathWt = " + ceilPathWt);

		System.out.println();
		ceilPath = "";
		ceilPathWt = Integer.MAX_VALUE;
		minHeap = new PriorityQueue<>();

		findPathWeightCeilValOfK(graph, visited, 0, 5, 90, 0 + "", 0);
		System.out.println("ceilPath = " + ceilPath + ", ceilPathWt = " + ceilPathWt);
		System.out.println();

		System.out.println();
		ceilPath = "";
		ceilPathWt = Integer.MAX_VALUE;
		minHeap = new PriorityQueue<>();

		findPathWeightCeilValOfKV2(graph, visited, 0, 5, 45, 0 + "", 0);
		System.out.println("ceilPath = " + ceilPath + ", ceilPathWt = " + ceilPathWt);

		System.out.println();
		ceilPath = "";
		ceilPathWt = Integer.MAX_VALUE;
		minHeap = new PriorityQueue<>();

		findPathWeightCeilValOfKV2(graph, visited, 0, 5, 90, 0 + "", 0);
		System.out.println("ceilPath = " + ceilPath + ", ceilPathWt = " + ceilPathWt);
}

	private static void findPathWeightCeilValOfK(ArrayList<Edge>[] graph, boolean[] visited, int src, int dest, int givenWt, String pathSoFar, int wtSoFar) {

		if (src == dest) {
			if(wtSoFar > givenWt) {
				minHeap.offer(wtSoFar);
				ceilPathWt = minHeap.peek();
				System.out.println(minHeap);
			}
			return;
		}
		visited[src] = true;
		for (Edge nbrEdge : graph[src]) {
			if (!visited[nbrEdge.nbr]) {
				findPathWeightCeilValOfK(graph, visited, nbrEdge.nbr, dest, givenWt, pathSoFar + nbrEdge.nbr, wtSoFar + nbrEdge.wt);
			}
		}
		visited[src] = false;
	}

	private static void findPathWeightCeilValOfKV2(ArrayList<Edge>[] graph, boolean[] visited, int src, int dest, int givenWt, String pathSoFar, int wtSoFar) {

		if (src == dest) {
			if(wtSoFar > givenWt) {
				if (wtSoFar < ceilPathWt) {
					ceilPathWt = wtSoFar;
					ceilPath = pathSoFar;
				}
			}
			return;
		}
		visited[src] = true;
		for (Edge nbrEdge : graph[src]) {
			if (!visited[nbrEdge.nbr]) {
				findPathWeightCeilValOfKV2(graph, visited, nbrEdge.nbr, dest, givenWt, pathSoFar + nbrEdge.nbr, wtSoFar + nbrEdge.wt);
			}
		}
		visited[src] = false;
	}
}
