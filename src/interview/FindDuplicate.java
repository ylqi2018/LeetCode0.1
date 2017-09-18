package interview;

public class FindDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 1, 3, 6, 6};
		int ans = new FindDuplicate().findDuplicate(nums);
		System.out.println(ans);
	}
	
	public int findDuplicate(int[] nums) {
		int low = 1;
		int high = nums.length - 1;
		while(low < high) {
			int mid = (int) (low + (high - low)*0.5);
			int cnt = 0;
			for(int i=0; i<nums.length; i++) {
				if(nums[i] <= mid) {
					cnt++;
				}
			}
			if(cnt <= mid) {
				low = mid + 1;
			} else {
				high = mid;
			}
			
		}
		return low;
	}

}
