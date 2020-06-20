package ds.graphtheory.impl;

import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.util.*;

public class ShortestPath {
    public List<Integer[]> findPath(char[][] graph) {
        if (graph.length<1) return new ArrayList<>();
        int gridRow = graph.length;
        int gridCol = graph[0].length;
        int shortestPathLength = 0;
        int[] dirX = new int[]{0,0,1,-1};
        int[] dirY = new int[]{1,-1,0,0};
        Queue<Integer> qX = new LinkedList<>();
        Queue<Integer> qY = new LinkedList<>();
        boolean[][] visited = new boolean[gridRow][gridCol];
        int[][] parentX = new int[gridRow][gridCol];
        int[][] parentY = new int[gridRow][gridCol];
        parentX[0][0] = -1;
        parentY[0][0] = -1;
        qX.offer(0);
        qY.offer(0);
        boolean isFound = false;
        int termX=0;
        int termY=0;
        while (!qX.isEmpty() && !qY.isEmpty() && !isFound) {
            int x = qX.poll();
            int y = qY.poll();
            visited[x][y] =true;
            for (int i=0;i<4;i++) {
                int newX = x+dirX[i];
                int newY = y+dirY[i];
                if (newX <0 || newX >=gridRow || newY<0 || newY>=gridCol
                        || graph[newX][newY] == 'O' ||visited[newX][newY]) continue;
                parentX[newX][newY] = x;
                parentY[newX][newY] = y;
                qX.offer(newX);
                qY.offer(newY);
                if (graph[newX][newY] == 'T') {
                    isFound = true;
                    termX=newX;
                    termY=newY;
                    break;
                }
            }
        }
        int currX = termX;
        int currY = termY;
        Stack<Integer[]> st = new Stack<>();
        List<Integer[]> res = new ArrayList<>();
        while(currX != -1 && currY != -1) {
            st.push(new Integer[]{currX, currY});
            int tempX = currX;
            int tempY = currY;
            currX = parentX[tempX][tempY];
            currY = parentY[tempX][tempY];
        }
        while(!st.isEmpty()) res.add(st.pop());
        return res;
    }

}

/*
*   '1' '1' '1' '1'
*   '1' '1' '0' '1'
*   '0' '1' '1' '1'
*   '1' '0' 'T' '1'
* */