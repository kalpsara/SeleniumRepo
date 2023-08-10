package week3.day2.assignments.assignment1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PrintUniqueCharacter {
	
	public static void main(String[] args) {
		String myName = "kalpana";
		char[] name = myName.toCharArray();
		Set<Character> nameSet = new HashSet<Character>();
		Set<Character> duplicateSet = new HashSet<Character>();
		for (char s : name) {
			if (nameSet.contains(s)) {
				duplicateSet.add(s);
				nameSet.remove(s);
			} else {
				nameSet.add(s);
			}

		}

		Iterator<Character> itr1 = duplicateSet.iterator();
		while (itr1.hasNext()) {
			for (char s : duplicateSet) {
				if (nameSet.contains(s)) {
					nameSet.remove(s);
				}
			}
			System.out.println("Repetitive char is " + itr1.next() + " ");
		}
		
		
		Iterator<Character> itr2 = nameSet.iterator();
		System.out.print("Unique char is ");
		while (itr2.hasNext()) {
			System.out.print(itr2.next() + " ");
		}

	}

}
