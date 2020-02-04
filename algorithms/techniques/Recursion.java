package algorithms.techniques;

import java.util.Arrays;

public class Recursion {
    public static void main(String[] args) {
        //System.out.println( factorial(4));
        long start = System.currentTimeMillis();
        System.out.print(power(2,1000000000));
        long end = System. currentTimeMillis();
        System.out.print(" Time spent is: " + (end-start) + "ms");

        System.out.println();

        long start2 = System.currentTimeMillis();
        System.out.print(powerMemo(2, 1000000000));
        long end2 = System. currentTimeMillis();
        System.out.print(" Time spent is: " + (end2-start2) + "ms");
    }

    public static int factorial(int n) {
        if(n==0) return 1;
        return n*factorial(n-1);
    }

    public static int power(int x, int y) {
        if(y==0) return 1;
        if(y%2 == 1) return x * power(x, y-1);
        return power(x, y/2) * power(x, y/2);
    }

    //Memoization version of power method
    public static int powerMemo(int x, int y) {
        int[] powerArray = new int[y+1];
        Arrays.fill(powerArray, -1);
        powerArray[0] = 1;
        return powerMemoHelper(x, y, powerArray);
    }

    private static int powerMemoHelper(int x, int y, int[] powerArray) {
        if(powerArray[y] != -1) return powerArray[y];
        if(y%2 == 1)
            powerArray[y] = x * powerMemoHelper(x, y-1, powerArray);
        else
            powerArray[y] = powerMemoHelper(x, y/2, powerArray) * powerMemoHelper(x, y/2, powerArray);

        return powerArray[y];
    }
}
