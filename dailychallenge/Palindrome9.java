package dailychallenge;

public class Palindrome9 {

	public static void main(String[] args) {
		String data = "A man, a plan,a canal: Panama";
		String lowercaseData = data.toLowerCase();
		String removedSpace = lowercaseData.replaceAll(" ", "");
		String[] texts = removedSpace.split("[:,]+");
		String s = "";
		for (String n : texts) {
			s += n;
		}

		char[] c = s.toCharArray();
		for (int i = c.length - 1; i >= 0; i--)
			System.out.print(c[i]);

	}

	

}
