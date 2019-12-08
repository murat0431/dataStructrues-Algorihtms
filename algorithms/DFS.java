package algorithms;

import java.util.Arrays;

public class DFS {

	private static final int NUM_VERTICES = 10;
	private static final int SOURCE = 5;
	public static void main(String[] args) {
		int[][] graph = initGraph(NUM_VERTICES);
		boolean[] visited = new boolean[NUM_VERTICES];
		int[] parent = new int[NUM_VERTICES];
		Arrays.fill(visited, false);
		Arrays.fill(parent, -1);
		dfs(graph, SOURCE, visited, parent);
	
	}
	
	private static void dfs(int[][] graph, int source, boolean[] visited, int[] parent) {
		System.out.println(source);
		visited[source] = true;
		int[] current = graph[source];
		for(int n: current) {
			if (!visited[n]) {
				parent[n] = source;
				dfs(graph, n, visited, parent);
			}
		}
	}

	
	
	private static int[][] initGraph(int NUM_VERTICES) {
		int[][] graph = new int[NUM_VERTICES][];
		graph[0] = new int[] {1};
		graph[1] = new int[] {0, 2, 4, 5};
		graph[2] = new int[] {1, 3};
		graph[3] = new int[] {2};
		graph[4] = new int[] {1, 8};
		graph[5] = new int[] {1, 6, 7};
		graph[6] = new int[] {5, 9};
		graph[7] = new int[] {5};
		graph[8] = new int[] {4};
		graph[9] = new int[] {6};
		
		return graph;
	}

}
