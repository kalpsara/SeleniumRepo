package dailychallenge;

public class FirstUniqueCharacter10 {

	public static void main(String[] args) {
		String input = "aabc";
		// String input = "loveleetcode";

		for (int i = 0; i < input.length(); i++) {
			boolean isUnique = true;

			for (int j = 0; j < input.length(); j++) {
				if ((input.charAt(i) == input.charAt(j) && i != j)) {
					isUnique = false;
					break;
				}
			}

			if (isUnique) {
				System.out.println(i);
				System.out.println(input.charAt(i));
				break;
			}

		}

	}

}
