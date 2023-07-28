package dailychallenge;

public class DuplicateAndUniqueNumber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums[] = { 5,3,1,3,2};  //{ -5, 3, -1, 3, -2 }; 
	
		int l = nums.length;
		for (int i = 0; i < l; i++) {

			int orgNumber = nums[i];
			int noOnThatIndex = nums[Math.abs(orgNumber) - 1];
			if (noOnThatIndex > 0) {
				nums[Math.abs(orgNumber) - 1] = -noOnThatIndex;
			} else {	
				System.out.print(Math.abs(nums[i])+" ");
				nums[Math.abs(orgNumber) - 1] = -noOnThatIndex;
			}

		}
		System.out.println("\n"+"-------------------");
		
		for (int i = 0; i < l; i++) {
			int orgNumber = nums[i];	
			if (orgNumber < 0) {
				int uniqueNo = i+1;
				System.out.print(uniqueNo+" ");
			}
		}

	}
}