package HashTable;

public class SingleNumberII137 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleNumberII137 sn = new SingleNumberII137();
		int[] nums = {4, 4, 4, 5, 6, 6, 6};
		int res = sn.singleNumber(nums);
		System.out.println(res);
	}
	
	public int singleNumber(int[] nums) {
		int ones = 0;
		int twos = 0;
		for(int i=0; i<nums.length; i++) {
			ones = (ones ^ nums[i]) & ~twos;
			twos = (twos ^ nums[i]) & ~ones;
		}
		return ones;
	}

}
