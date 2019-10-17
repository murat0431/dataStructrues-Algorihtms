package programming_methods;

public class BitManipulation {
	public static void main(String[] args) {
		int x = 21;
		System.out.println(isEven(x));	
		System.out.println(occuredOddTimes(new int[]{3,5,5,3,4,5,4,2,2}));
		System.out.println(findMissing(new int[]{1,2,3,4,5,6,7,8,9,10,12}));
		swapTwoNumbersWithoutTempVar(5, 9);
		
	}
	
	/**
	 * Returns whether an integer is even or not by using Bit Manipulation
	 * @param value
	 * @return
	 */
	public static boolean isEven(int value) {
		return (value&1) == 0;
	}
	
	/**
	 * Returns the integer that occurs odd times by using B.M.
	 * @param arr
	 * @return
	 */
	public static int occuredOddTimes(int[] arr) {
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			temp = temp^arr[i];
		}
		return temp;
	}
	
	/**
	 * Returns the missing number of the array by using B.M.
	 * @param arr consists of numbers from 1 to n except the missing one
	 * @return
	 */
	
	public static int findMissing(int[] arr) {
		int first = arr[0];
		int second = 1;
		for (int i = 1; i < arr.length; i++) {
			first ^= arr[i];
		}
		for (int i = 2; i <= arr.length+1; i++) {
			second ^= i;
		}
		return first^second;
	}
	/**
	 * Swaps two integers without using any temporary variable
	 * @param x
	 * @param y
	 */
	
	public static void swapTwoNumbersWithoutTempVar(int x, int y) {
		x=x^y;
		y=x^y;
		x=x^y;
		System.out.println("x is: " + x);
		System.out.println("y is: " + y);
	}
}
