package interview;

public class MaximumSubarray53 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int max = new MaximumSubarray53().maxSubArray(nums);
		System.out.println(max);
	}
	
	public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return Integer.MIN_VALUE;
        }
        
        int pre = nums[0];
        int max = nums[0];
        
        for(int i=1; i<nums.length; i++) {
        	pre = Math.max(nums[i], nums[i] + pre);
        	max = Math.max(max, pre);
        }
        return max;
    }
	
    public int maxSubArray1(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        
        dp[0] = nums[0];
        int max = nums[0];
        
        for(int i=1; i<len; i++) {
            dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i-1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
