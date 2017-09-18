package interview;

public class JumpGame55 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 3, 1, 1, 4};
		//int[] nums = {3, 2, 1, 0, 4};
		boolean canJump = new JumpGame55().canJump1(nums);
		System.out.println(canJump);
	}
	
	//backward
	public boolean canJump(int[] nums) {
		int last = nums.length - 1;
		for(int i= nums.length - 2; i>=0; i--) {
			if(i+nums[i]>=last) {
				last = i;
			}
		}
		return (last <= 0);
	}
	
	public boolean canJump1(int[] nums) {
		int reach = 0;
		int i = 0;
		for(; i<nums.length && i<=reach; i++) {
			reach = Math.max(i+nums[i], reach);
		}
		return (i==nums.length);
	}

}
