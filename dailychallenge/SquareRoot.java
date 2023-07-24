package dailychallenge;

public class SquareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = 9;
		int i = 2;
		int result = 0;
		while (i <= x / 2) {

			if (x / i == i) {
				
				result = i;
				break;
				
			} else if (i * i < x && (i + 1) * (i + 1) > x) {
				
				result = i;
				break;
				
			}
			
			//result = i;
			i++;

		}

		System.out.println("Square root of the given number  " + x + " is " + result);

	}

}
