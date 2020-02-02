package algorithms;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 7, 8, 9, 12, 15, 16, 19, 23};
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.binarySearch(arr, 7));
    }

    public int binarySearch(int[] arr, int target) {
        return binarySearch(arr, 0, arr.length, target);
    }

    private int binarySearch(int[] arr, int left, int right, int target) {
        while(left<right) {
            int mid = (left + right)/2;
            if(arr[mid] == target) return mid;
            if(arr[mid] < target) left = mid+1;
            if(arr[mid] > target) right = mid-1;
        }
        return -1;
    }
}
