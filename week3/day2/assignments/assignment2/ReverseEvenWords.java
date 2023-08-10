package week3.day2.assignments.assignment2;

public class ReverseEvenWords {

	public static void main(String[] args) {
		String test = "I am a software tester";
		String[] inputStringArray = test.split(" ");

		String s = "";
		String word = "";
		

		for (int m = 0; m < inputStringArray.length; m++) {

			if ((m % 2 == 0)) {
				s = inputStringArray[m];

			} else {

				char[] inputCharArray = inputStringArray[m].toCharArray();
				char[] dest = new char[inputCharArray.length + 1];
				for (int i = 0; i < inputCharArray.length; i++) {
					dest[(inputCharArray.length) - i - 1] = inputCharArray[i];
				}

				s = String.copyValueOf(dest);
			}
			word = word + s + " ";

		}

		System.out.println(word);
	}

}
