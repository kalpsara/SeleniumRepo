package week3.day2.assignments.assignment1;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesWords {
	
	

	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";
		String[] splittedText = text.split(" ");

		Set<String> myset = new LinkedHashSet<String>();
		for (String element : splittedText) {
			myset.add(element);
		}

		Iterator<String> itr = myset.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}

	}

}
