package interview;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return 0;
        }
        
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        
        for(int i=1; i<nums.length; i++) {
        	int mx = max;
        	int mn = min;
        	max = Math.max(Math.max(nums[i], mx*nums[i]), mn*nums[i]);
        	min = Math.min(Math.min(nums[i], mn*nums[i]), mx*nums[i]);
        	res = Math.max(max, res);
        }
        return res;
    }

}
