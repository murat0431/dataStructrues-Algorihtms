package algorithms;

public class GraphRepresent {
	public static final int VERTEX = 5;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		printGraph(initGraph(VERTEX));
	}
	
	public static void printGraph(int[][] graph) {
		for (int i = 0; i < graph.length; i++) {
			System.out.print(i);
			for (int j = 0; j < graph[i].length; j++) {
				if(graph[i][j] > 0) {
					System.out.print(" -> " + j);
				}
			}
			System.out.println();
		}
	}
	
	public static int[][] initGraph(int vertex) {
		int[][] graph = new int[vertex][vertex];
		graph[0][1] = 1;
		graph[0][3] = 1;
		graph[1][0] = 1;
		graph[1][2] = 1;
		graph[2][1] = 1;
		graph[2][3] = 1;
		graph[3][0] = 1;
		graph[3][2] = 1;
		graph[3][4] = 1;
		graph[4][3] = 1;
		return graph;
	}

}
