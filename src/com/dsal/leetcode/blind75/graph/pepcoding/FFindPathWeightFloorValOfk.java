package com.dsal.leetcode.blind75.graph.pepcoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FFindPathWeightFloorValOfk {

	static String floorPath;
	static int floorPathWt = Integer.MIN_VALUE;

	static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

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

		findPathWeightfloorValOfK(graph, visited, 0, 5, 50, 0 + "", 0);
		System.out.println("floorPath = " + floorPath + ", floorPathWt = " + floorPathWt);

		System.out.println();
		floorPath = "";
		floorPathWt = Integer.MIN_VALUE;
		maxHeap = new PriorityQueue<>((a, b) -> b - a);

		findPathWeightfloorValOfK(graph, visited, 0, 5, 90, 0 + "", 0);
		System.out.println("floorPath = " + floorPath + ", floorPathWt = " + floorPathWt);
		System.out.println();

		System.out.println();
		floorPath = "";
		floorPathWt = Integer.MIN_VALUE;
		maxHeap = new PriorityQueue<>((a, b) -> b - a);

		findPathWeightfloorValOfKV2(graph, visited, 0, 5, 50, 0 + "", 0);
		System.out.println("floorPath = " + floorPath + ", floorPathWt = " + floorPathWt);

		System.out.println();
		floorPath = "";
		floorPathWt = Integer.MIN_VALUE;
		maxHeap = new PriorityQueue<>((a, b) -> b - a);

		findPathWeightfloorValOfKV2(graph, visited, 0, 5, 90, 0 + "", 0);
		System.out.println("floorPath = " + floorPath + ", floorPathWt = " + floorPathWt);
	}

	private static void findPathWeightfloorValOfK(ArrayList<Edge>[] graph, boolean[] visited, int src, int dest, int givenWt, String pathSoFar, int wtSoFar) {

		if (src == dest) {
			if(wtSoFar < givenWt) {
				maxHeap.offer(wtSoFar);
				floorPathWt = maxHeap.peek();
				System.out.println(maxHeap);
			}
			return;
		}

		visited[src] = true;
		for (Edge nbrEdge : graph[src]) {
			if(!visited[nbrEdge.nbr]) {
				findPathWeightfloorValOfK(graph, visited, nbrEdge.nbr, dest, givenWt, pathSoFar + nbrEdge.nbr, wtSoFar + nbrEdge.wt);
			}
		}
		visited[src] = false;
	}

	private static void findPathWeightfloorValOfKV2(ArrayList<Edge>[] graph, boolean[] visited, int src, int dest, int givenWt, String pathSoFar, int wtSoFar) {

		if (src == dest) {
			if(wtSoFar < givenWt) {
				if(wtSoFar > floorPathWt) {
					floorPathWt = wtSoFar;
					floorPath = pathSoFar;
				}
			}
			return;
		}

		visited[src] = true;
		for (Edge nbrEdge : graph[src]) {
			if(!visited[nbrEdge.nbr]) {
				findPathWeightfloorValOfKV2(graph, visited, nbrEdge.nbr, dest, givenWt, pathSoFar + nbrEdge.nbr, wtSoFar + nbrEdge.wt);
			}
		}
		visited[src] = false;
	}

}
