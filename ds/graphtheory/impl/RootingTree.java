package ds.graphtheory.impl;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RootingTree {

    public class TreeNode {
        int id;
        List<TreeNode> children;

        public TreeNode(int id, List<TreeNode> children) {
            this.id = id;
            this.children = children;
        }

    }

    public TreeNode rootTree(Map graph, int rootId, Map isVisited) {
        TreeNode root = new TreeNode(rootId, new ArrayList<>());
        buildTree(graph, root, isVisited);
        return root;
    }

    private void buildTree(Map<Integer, List<Integer>> graph, TreeNode root, Map<Integer, Boolean> isVisited) {
        isVisited.put(root.id, true);
        for (int child : graph.get(root.id)) {
            if(!isVisited.get(child)) {
                TreeNode ch = new TreeNode(child, new ArrayList<>());
                root.children.add(ch);
                buildTree(graph, ch, isVisited);
            }
        }
    }
}
