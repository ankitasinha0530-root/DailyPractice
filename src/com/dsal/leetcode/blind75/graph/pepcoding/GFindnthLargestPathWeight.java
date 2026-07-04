package com.dsal.leetcode.blind75.graph.pepcoding;


import java.util.ArrayList;
import java.util.PriorityQueue;

public class GFindnthLargestPathWeight {

	// [45, 55, 60, 90, 130, 140, 155]

	static String nthLargePath;
	static int nthLargePathWt = Integer.MIN_VALUE;

	static PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a-b);
	
//	static PriorityQueue<Integer> minHeap1 = new PriorityQueue<>((a, b) -> a-b);

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

		System.out.println();
		findKthLargestPathWeight(graph, visited, 0, 5, 3, 0 + "", 0);
		System.out.println("nthLargePath = " + nthLargePath + ", nthLargePathWt = " + nthLargePathWt);

		System.out.println();
		nthLargePath = "";
		nthLargePathWt = Integer.MAX_VALUE;
		minHeap = new PriorityQueue<>();
		findKthLargestPathWeight(graph, visited, 0, 5, 4, 0 + "", 0);
		System.out.println("nthLargePath = " + nthLargePath + ", nthLargePathWt = " + nthLargePathWt);

		System.out.println();
		nthLargePath = "";
		nthLargePathWt = Integer.MAX_VALUE;
		minHeap = new PriorityQueue<>();
		findKthLargestPathWeight(graph, visited, 0, 5, 2, 0 + "", 0);
		System.out.println("nthLargePath = " + nthLargePath + ", nthLargePathWt = " + nthLargePathWt);
	}

	private static void findKthLargestPathWeight(ArrayList<Edge>[] graph, boolean[] visited, int src, int dest, int k, String pathSoFar, int wtSoFar) {

		if(src == dest) {
			if (minHeap.size() == k) {
				if(minHeap.peek() < wtSoFar){
					minHeap.poll();
					minHeap.offer(wtSoFar);
				}
			}else {
				minHeap.offer(wtSoFar);
			}
			nthLargePathWt = minHeap.peek();
			return;
		}

		visited[src] = true;

		for (Edge nbrEdge : graph[src]) {
			if(!visited[nbrEdge.nbr]) {
				findKthLargestPathWeight(graph, visited, nbrEdge.nbr, dest, k, pathSoFar + nbrEdge.nbr, wtSoFar + nbrEdge.wt);
			}
		}
		visited[src] = false;
	}
}
