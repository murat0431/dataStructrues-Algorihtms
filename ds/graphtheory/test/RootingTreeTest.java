package ds.graphtheory.test;

import ds.graphtheory.impl.RootingTree;

import java.util.*;

public class RootingTreeTest {
    public static void main(String[] args) {
        RootingTree rt = new RootingTree();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Boolean> isVisited = new HashMap<>();
        graph.put(0, Arrays.asList(2, 1, 5));
        isVisited.put(0, false);
        graph.put(1, Arrays.asList(0));
        isVisited.put(1, false);
        graph.put(2, Arrays.asList(3, 0));
        isVisited.put(2, false);
        graph.put(3, Collections.singletonList(2));
        isVisited.put(3, false);
        graph.put(4, Arrays.asList(5));
        isVisited.put(4, false);
        graph.put(5, Arrays.asList(4, 6, 0));
        isVisited.put(5, false);
        graph.put(6, Arrays.asList(5));
        isVisited.put(6, false);
        RootingTree.TreeNode root = rt.rootTree(graph, 0, isVisited);

    }
}
