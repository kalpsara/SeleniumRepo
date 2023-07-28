package dailychallenge;

public class MajorityQccurence4 {

	public static void main(String[] args) {
		int input[] = { 2, 1, 1, 1,2 ,1,2,2, 2, 1, 2};
		int l = input.length;
		int count = 0;

		int maxcount = l / 2;
		for (int i = 0; i < l; i++) {

			for (int j = 0; j < l; j++) {

				if (input[i] == input[j]) {

					count++;
				}
				

			}
		//	System.out.println(count);
			if (count>=maxcount) {
				System.out.println(input[i]);
				break;
			}
		}

	}

}
