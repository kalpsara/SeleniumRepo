package week1.day2.assignments;

import java.util.Arrays;

public class FindSecondLargest {

	public static void main(String[] args) {

		// input
		int[] data = { 3, 2, 11, 4, 6, 7 };

		int length = data.length;

		Arrays.sort(data);
		System.out.println(" Second largest element in the given array is " + data[length - 2]);

	}

}
