package dailychallenge;

public class NumOfWordsInSentences12 {
//java challenge 12/20
	public static void main(String[] args) {
		//String[] sentences = { "alice and bob love leetcode", "i think so too", "this is great thanks very much" };
		String[] sentences = {"please wait","continue to fight","continue to win"}; 
		int maxNumOfWords = 0;
		int numWords = 0;
		for (int i = 0; i < sentences.length; i++) {
			numWords = sentences[i].split(" ").length;
			if (numWords > maxNumOfWords) {
				maxNumOfWords = numWords;
			}
		}
		System.out.println("maximum number of words in a sentence is "+maxNumOfWords);

	}

}
