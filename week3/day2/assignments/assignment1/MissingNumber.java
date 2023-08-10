package week3.day2.assignments.assignment1;

import java.util.Iterator;
import java.util.TreeSet;

public class MissingNumber {

	public static void main(String[] args) {
		int[] data = { 1,2, 4, 10 };

		TreeSet<Integer> uniqueData = new TreeSet<Integer>();
		for (int i = 0; i < data.length; i++) {
			uniqueData.add(data[i]);
		}
		System.out.println(uniqueData);

		Iterator<Integer> itr = uniqueData.iterator();

		int previousNumber = 0;

		while (itr.hasNext()) {

			int currentNumber = itr.next();

			if ((currentNumber - previousNumber) > 1) {

				for (int i = 1; i < (currentNumber - previousNumber); i++) {
					System.out.println(previousNumber + i);
				}

			}
			previousNumber = currentNumber;
		}

	}

}
