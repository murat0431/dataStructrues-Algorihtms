package algorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BFS {
	public static void main(String[] args) {
		int[][] adj = generateAdjMatrix(6);
		printMatrix(adj);
		System.out.println();
		bfs(adj,3);
	}

	/**
	 * This method generates a square matrix of
	 * 1's and 0's that can be used as a graph
	 * @return the adjacency matrix
	 */
	public static int[][] generateAdjMatrix(int size) {
		int[][] adj = new int[size][size];
		for (int i=0;i<size;i++) {
			for (int j=0;j<size;j++) {
				if(i==j)
					adj[i][j] = 0;
				  else if(i<j)
					adj[i][j] = generateNumber();
				  else
					adj[i][j] = adj[j][i];
			}
		}
		return adj;
	}

	/**
	 * This methods generates 0 or 1 randomly
	 * @return 0 or 1
	 */
	public static int generateNumber() {
		return new Random().nextInt(2);
	}

	/**
	 * Prints the given matrix to the console
	 * @param matrix
	 */
	public static void printMatrix(int[][] matrix) {
		for (int i=0;i<matrix.length;i++) {
			for (int j=0;j<matrix[i].length;j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Performs Breadth First Search on the given graph
	 * @param graph
	 * @param source
	 */
	public static void bfs(int[][] graph, int source) {
		int size = graph.length;
		boolean[] visited = new boolean[size];
		Queue<Integer> q = new LinkedList<>();
		q.add(source);
		visited[source] = true;
		while (!q.isEmpty()) {
			int current = q.poll();
			System.out.print(current + " ");
			for (int i=0;i<graph[current].length;i++) {
				if (graph[current][i] == 1 && !visited[i]) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}


}
