package dailychallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfOccurenceUnique7 {
//Java challenge 7/20
	public static void main(String[] args) {
		int[] orgArray = { 2, 3, 1, 1, 3,3,3, 1, 2 };
		List<Integer> elementList = new ArrayList<>();
		List<Integer> occurrenceList = new ArrayList<>();
		boolean uniqueOccurrence = true;

		for (int i = 0; i < orgArray.length; i++) {
			int occurrenceCount = 1;
			
			//skips the iteration if elementList contains orgArray
			if (elementList.contains(orgArray[i])) {
				continue;
			}

			for (int j = i + 1; j < orgArray.length; j++) {
				if (orgArray[i] == orgArray[j]) {
					occurrenceCount++;
				}
			}

			if (occurrenceList.contains(occurrenceCount)) {
				uniqueOccurrence = false;
				break;
			}

			elementList.add(orgArray[i]);
			occurrenceList.add(occurrenceCount);

		}
		System.out.println(occurrenceList);

		System.out.println(uniqueOccurrence);

	}

}
