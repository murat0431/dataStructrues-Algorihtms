package ds.graphtheory.utils;

public class ArrayUtils {

    public static void print(int[][] arr) {
        for (int[] a : arr) {
            for (int el : a) System.out.println(el + " ");
            System.out.println();
        }
    }
    public static <T> void printArr(T[] arr) {
            System.out.print("[ ");
            for (T el : arr) System.out.print(el+" ");
            System.out.print("]");
        System.out.print("->");
    }

    public static void printCharArray(char[][] arr) {
        for (char[] a : arr) {
            for (char el : a) System.out.println(el + " ");
            System.out.println();
        }
    }
}
