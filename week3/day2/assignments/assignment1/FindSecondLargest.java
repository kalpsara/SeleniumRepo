package week3.day2.assignments.assignment1;

import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class FindSecondLargest {

	public static void main(String[] args) {
		
		int[] data = { 3, 2, 11, 4, 6, 7, 2, 3, 3, 6, 7 };
		Set<Integer> setOfNumbers = new TreeSet<Integer>();
		for (int i = 0; i < data.length; i++) {
			setOfNumbers.add(data[i]);

		}

		List<Integer> listOfNumbers = new ArrayList<>(setOfNumbers);
		Collections.sort(listOfNumbers, Collections.reverseOrder());
		System.out.println("Second highest=" + listOfNumbers.get(1));

	}

}
