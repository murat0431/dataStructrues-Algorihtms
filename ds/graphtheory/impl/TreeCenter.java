package ds.graphtheory.impl;

import java.util.*;

public class TreeCenter {

    public List<Integer> findCenter(final int[][] graph) {
        int size = graph.length;
        int[] connections = new int[size];
        for (int i=0;i<size;i++) connections[i] = graph[i].length;
        int count =0;
        while (count < size-2) {
            for (int i=0;i<size;i++) {
                if (connections[i] == 1) {
                    connections[i]--;
                    count++;
                    for(int j : graph[i]) {
                        connections[j]--;
                        if(connections[j] == 0) count++;
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i=0;i<size;i++) {
            if (connections[i]>0) result.add(i);
        }
        if (result.size() == 2) {
            if(result.get(0) == result.get(1)) return result;
            result.remove((Integer) Math.min(result.get(0), result.get(1)));
        }
        return result;
    }
}
