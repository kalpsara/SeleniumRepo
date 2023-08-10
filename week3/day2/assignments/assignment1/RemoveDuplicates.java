package week3.day2.assignments.assignment1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RemoveDuplicates {


	public static void main(String[] args) {
		String company = "PayPal India";
		String lowercaseCompany=company.toLowerCase();
		char[] companyChar = lowercaseCompany.toCharArray();
		//System.out.println(companyChar[6]);

		Set<Character> charSet = new HashSet<Character>();

		Set<Character> dupCharSet = new HashSet<Character>();

		for (char s : companyChar) {
			if (charSet.contains(s)) {
				dupCharSet.add(s);
				charSet.remove(s);
			} else {
				charSet.add(s);
			}

		}

		Iterator<Character> itr1 = dupCharSet.iterator();
		while (itr1.hasNext()) {
			for (char s : dupCharSet) {
				if (charSet.contains(s)) {
					charSet.remove(s);
				}
			}
			 itr1.next();
		}

		Iterator<Character> itr2 = charSet.iterator();
		System.out.print("Unique char is ");
		while (itr2.hasNext()) {
			System.out.print(itr2.next() + " ");
		}

	}

}
