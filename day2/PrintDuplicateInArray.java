package week1.day2;

import java.util.Arrays;

public class PrintDuplicateInArray {
	int myArray[] = { 2, 5, 7, 7, 5, 9, 2, 3 };

	public void method1() {
		for (int i = 0; i <= myArray.length - 1; i++) {
			for (int j = i + 1; j < myArray.length - 1; j++)
				if (myArray[i] == myArray[j]) {

					System.out.print(myArray[i] + ",");
				}
			System.out.println("");
		}
	}

	public void method2() {

		Arrays.sort(myArray);
		for (int i = 0; i < myArray.length - 1; i++) {

			if (myArray[i] == myArray[i + 1]) {
				System.out.println("Inside method 2");

				System.out.print(myArray[i] + ",");

			}
		}
	}

	public static void main(String[] args) {

		System.out.println("Duplicates element in array");

		PrintDuplicateInArray p = new PrintDuplicateInArray();
		p.method1();
		p.method2();

	}

}
