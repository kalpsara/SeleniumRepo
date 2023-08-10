package week3.day2.assignments.assignment2;

public class ChangeOddIndexToUpperCase {
	
	public static void main(String[] args) {
		String test = "changeme";
		char[] mychar = test.toCharArray();
		String s = "";
		String word = "";
		// index starts from 0
		for (int i = 0; i < mychar.length; i++) {
			if (!(i % 2 == 0)) {
				s = mychar[i] + "";
				s = s.toUpperCase();
			} else {
				s = mychar[i] + "";
			}
			word = word + s;
		}
		System.out.println(word);

	}

}
