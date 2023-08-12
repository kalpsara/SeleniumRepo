package dailychallenge;

public class LastWordLength8 {

	public static void main(String[] args) {
		//String s = " Hello world ";
		String s ="luffy is still joyboy";
		String[] sArray = s.split(" ");
		String lastWord = sArray[sArray.length - 1];

	//	System.out.println(lastWord);
		int size = lastWord.toCharArray().length;

		System.out.println(size);

	}

}
