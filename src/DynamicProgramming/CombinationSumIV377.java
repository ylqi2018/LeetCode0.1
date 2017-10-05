package DynamicProgramming;

import java.util.Arrays;

public class CombinationSumIV377 {

	/**
	 * recurrence
	 * Time limited
	 * @param args
	 */
	public int combinationSum4(int[] nums, int target) {
		if(target == 0) {
			return 1;
		}
		int res = 0;
		for(int i=0; i<nums.length; i++) {
			if(target >= nums[i]) {
				res += combinationSum4(nums, target-nums[i]);
			}
		}
		return res;
	}

	/**
	 * DP solution
	 * Time limited
	 */
	private int[] dp;
	public int combinationSum41(int[] nums, int target) {
		dp = new int[target+1];
		Arrays.fill(dp, -1);
		dp[0] = 1;
		return helper(nums, target);
	}
	private int helper(int[] nums, int target) {
		if(dp[target] != -1) {
			return dp[target];
		}
		int res = 0;
		for(int i=0; i<nums.length; i++) {
			if(target >= nums[i]) {
				res += helper(nums, target - nums[i]);
			}
		}
		return res;
	}
	
	/**
	 * top-down
	 * @param args
	 */
	public int combinationSum42(int[] nums, int target) {
		int[] comb = new int[target+1];
		comb[0] = 1;
		for(int i=1; i<comb.length; i++) {
			for(int j=0; j<nums.length; j++) {
				if(i-nums[j]>=0) {
					comb[i] += comb[i-nums[j]];
				}
			}
		}
		return comb[target];
	}
	
	
	public int combinationSum43(int[] nums, int target) {
		Arrays.sort(nums);
		int[] res = new int[target+1];
		for(int i=1; i<res.length; i++) {
			for(int num: nums) {
				if(num > i) {
					break;
				} else if(num == i) {
					res[i] += 1;
				} else {
					res[i] += res[i-num];
				}
			}
		}
		return res[target];
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSumIV377 cs = new CombinationSumIV377();
		int[] nums = new int[]{4, 1, 2};
		int target = 32;
		int res = cs.combinationSum43(nums, target);
		System.out.println(res);
	}

}
