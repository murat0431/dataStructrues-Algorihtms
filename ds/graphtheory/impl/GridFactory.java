package ds.graphtheory.impl;

import java.util.ArrayList;
import java.util.List;

public class GridFactory {
    private final int TARGET_COUNT = 1;
    private final char TARGET = 'T';
    private final char OBSTACLE = 'O';
    private final char NORMAL = 'N';
    private final int OBSTACLE_PERCENTAGE = 20;

    public char[][] initGraph(int row, int col) {
        char[][] result = new char[row][col];
        int numOfTarget = TARGET_COUNT;
        int total = row*col-numOfTarget;
        int numOfObstacles = total*OBSTACLE_PERCENTAGE/100;
        int numOfNormals = total-numOfObstacles;
        List<Character> randoms = new ArrayList<>();
        randoms.add(OBSTACLE);
        randoms.add(NORMAL);
        randoms.add(TARGET);
        result[0][0] = NORMAL;
        numOfNormals--;
        for (int i=0;i<row;i++) {
            for (int j=i==0?1:0;j<col;j++) {
                int size = randoms.size();
                int r = size==1 ? 1 : generateNumber(0, size-1);
                char current = randoms.get(r);
                if (current == OBSTACLE) {
                    result[i][j] = OBSTACLE;
                    numOfObstacles--;
                    if (numOfObstacles == 0) randoms.remove(Character.valueOf(OBSTACLE));
                } else if(current == NORMAL) {
                    result[i][j] = NORMAL;
                    numOfNormals--;
                    if (numOfNormals == 0) randoms.remove(Character.valueOf(NORMAL));
                } else if (current==TARGET){
                    result[i][j] = TARGET;
                    numOfTarget--;
                    randoms.remove(Character.valueOf(TARGET));
                }
            }
        }
        return result;
    }

    public int generateNumber(int start, int end) {
        return (int)(Math.random()*(end+1) + start);
    }
}
