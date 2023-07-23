package week1.day1;

import java.util.Scanner;

public class IsPrime {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number :");
		int num = sc.nextInt();

		if (isPrime(num) == false) {
			System.out.println("not prime");
		} else
			System.out.println("It is prime");
	}

	public static boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}
		for (int i = 2; i <=num-1; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
