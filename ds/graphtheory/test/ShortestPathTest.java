package ds.graphtheory.test;

import ds.graphtheory.impl.ShortestPath;
import ds.graphtheory.utils.ArrayUtils;
import ds.graphtheory.utils.ListUtils;

import java.util.List;

public class ShortestPathTest {
    public static void main(String[] args) {
        ShortestPath sp = new ShortestPath();
        char[][] graph = new char[][]{
                {'N', 'N', 'N', 'O'},
                {'N', 'N', 'N', 'N'},
                {'O', 'O', 'N', 'N'},
                {'T', 'N', 'N', 'N'}
        };
        List<Integer[]> res= sp.findPath(graph);
        ListUtils.printList(res);
        System.out.println("SUCCESS");
    }
}
/**
    '1' '1' '1' '1'
    '1' '1' '0' '1'
    '0' '1' '1' '1'
    '1' '0' 'T' '1'
 */
