package week1.day2.assignments;

import java.util.Arrays;

public class MissingElementInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, 2, 3, 4, 7, 6, 8 };
		// int[] arr = { 11, 12, 13, 16, 18 };
		// int[] arr = { 17, 20, 33, 34,37,46};

		Arrays.sort(arr);

		int k = 0;
		int j = arr[0];
		int l = arr.length;
		
		for (int i = 0; i < arr[(l - 1)]; i++) {
			
			if (j != arr[k]) {
				
				System.out.println(j);
				j++;
				
			}else if ((j == arr[k]) && (k < l - 1)) {
				
				j++;
				k++;
				
			}

		}

	}

}
