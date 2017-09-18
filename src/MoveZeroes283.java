
public class MoveZeroes283 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0, 1, 0, 3, 12};
		System.out.println(nums);
		new MoveZeroes283().moveZeroes(nums);
		System.out.println(nums);
	}
	
	public void moveZeroes(int[] nums) {
		if(nums == null || nums.length == 0) {
			return;
		}
		
		// Find the first zero element
		int ptr = 0;
		while(ptr < nums.length && nums[ptr] != 0) {
			ptr++;
		}
		for(int i=ptr+1; i<nums.length; i++) {
			if(nums[i] != 0) {
				swap(nums, i, ptr++);
			}
		}
		
		
	}
	
	private void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

}
