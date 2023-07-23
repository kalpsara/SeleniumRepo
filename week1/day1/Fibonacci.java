package week1.day1;

public class Fibonacci {

	public static void main(String[] args) {
		int firstNum = 0;
		int secondNum = 1;
		int sum = 0;
		int limit=55;
		while(firstNum<=limit){
			System.out.println(firstNum);

			sum = firstNum + secondNum;
			firstNum = secondNum;
			secondNum = sum;
			
		}

	}

}
