package week1.day2.assignments;

import java.util.Arrays;

public class PrintDuplicatesInArray {
	
	public void withoutSorting() {}
	
	public static void main(String[] args) {

		int[] arr = { 14, 12, 13, 11, 15, 14, 18, 16, 17, 19, 18, 17, 20 };
		Arrays.sort(arr);
		int l = arr.length;
		
		for (int i = 0; i < l - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				System.out.println(arr[i]);
			}
		}

	}

}
