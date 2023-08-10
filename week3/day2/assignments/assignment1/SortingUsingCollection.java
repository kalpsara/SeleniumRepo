package week3.day2.assignments.assignment1;

import java.util.Arrays;

public class SortingUsingCollection {
			
	public static void main(String[] args) {
		
		String[] companies= {"HCL", "Wipro","Aspire Systems","CTS"};
		Arrays.sort(companies);
		for(int i=companies.length-1;i>=0;i--) {
		System.out.print(companies[i]+",");
		
		
		}
	}

}
