package ds.graphtheory.test;

import ds.graphtheory.impl.TreeCenter;

public class TreeCenterTest {
    public static void main(String[] args) {
        TreeCenter tc = new TreeCenter();
        int[][] graph = new int[][]{
                {1},
                {0, 3, 4},
                {3},
                {1, 2, 6, 7},
                {1, 5, 8},
                {4},
                {3, 9},
                {3},
                {4},
                {6}
        };
        tc.findCenter(graph).forEach(System.out::println);
    }
}
