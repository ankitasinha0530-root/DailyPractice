package com.dsal.leetcode.blind75.graph.pepcoding;//package com.graph.practice;

import java.util.ArrayList;

public class graph {

	public static void main(String[] args) {

		ArrayList<Edge>[] graph = new ArrayList[7]; // graph also called as adjacency list

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		graph[0].add(new Edge(0, 1, 10));
		graph[1].add(new Edge(1, 0, 10));
		graph[2].add(new Edge(2, 3, 20));
		graph[3].add(new Edge(3, 2, 20));
		graph[2].add(new Edge(2, 4, 30));
		graph[4].add(new Edge(4, 2, 30));
		graph[3].add(new Edge(3, 1, 15));
		graph[1].add(new Edge(1, 3, 15));
		graph[4].add(new Edge(4, 5, 10));
		graph[5].add(new Edge(5, 4, 10));

	}

}
