package dailychallenge;


public class SecondOccurence11 {

	public static void main(String[] args) {
		String s = "abcabd";
		String s1 = "abcdd";
		int leastSpan = s.length();
		char resultChar = ' ';
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {

				if (s.charAt(i) == s.charAt(j) && (j - i) < leastSpan ) {
					resultChar = s.charAt(i);
					leastSpan = j - i;
				}

			}

		}

		System.out.println(resultChar);

	}

}
