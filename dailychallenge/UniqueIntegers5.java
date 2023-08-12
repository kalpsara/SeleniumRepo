package dailychallenge;

public class UniqueIntegers5 {

	public static void main(String[] args) {
	int[] nums= {1,2,3,2,4,3};
	boolean isDuplicate=false;
	
	for(int i=0;i<nums.length;i++) {
		
		for(int j=i+1;j<nums.length;j++) {
			
			if(nums[i]==nums[j]) {
				isDuplicate=true;
				break;
			}
			
		}
		if(isDuplicate) {
			System.out.println(isDuplicate);
		//System.out.println(nums[i]);
		break;
		}
	}
	}

}
