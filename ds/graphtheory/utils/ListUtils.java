package ds.graphtheory.utils;

import java.util.List;

public class ListUtils {
    public static <T> void printList(List<T[]> list) {
        list.forEach((T[] arr) -> ArrayUtils.printArr(arr));
    }
}
