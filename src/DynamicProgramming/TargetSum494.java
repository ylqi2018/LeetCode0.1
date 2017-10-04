package DynamicProgramming;

import java.util.Arrays;

public class TargetSum494 {

	public int findTargetSumWays(int[] nums, int s) {
		int sum = 0;
		for(int n : nums) {
			sum += n;
		}
		
		return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s+sum)>>>1);
	}
	
	public int subsetSum(int[] nums, int s) {
		int[] dp = new int[s + 1];
		dp[0] = 1;
		for(int n : nums) {
			for(int i=s; i>=n; i--) {
				dp[i] += dp[i-n];
			}
		}
		return dp[s];
	}

	/**
	 * Brute Force
	 * Based on recursion. Try to put both the "+" and "-" symbols at every location in the given nums array
	 * and find out the assignments which lead to required result S.
	 */
	int count = 0;
	public int findTargetSumWays1(int[] nums, int S) {
		calculate(nums, 0, 0, S);
		return count;
	}
	private void calculate(int[] nums, int i, int sum, int S) {
		if(i == nums.length) {
			if(sum == S) {
				count++;
			}
		} else {
			calculate(nums, i+1, sum+nums[i], S);
			calculate(nums, i+1, sum-nums[i], S);
		}
	}

	/**
	 * Recursion with memoization
	 * @param args
	 */
	int count1 = 0;
	public int findTargetSumWays2(int[] nums, int S) {
		int[][] memo = new int[nums.length][2001];
		for(int[] row: memo) {
			Arrays.fill(row, Integer.MIN_VALUE);
		}
		return calculate1(nums, 0, 0, S, memo);
	}
	private int calculate1(int[] nums, int i, int sum, int S, int[][] memo) {
		if(i == nums.length) {
			if(sum == S) {
				return 1;
			} else {
				return 0;
			}
		} else {
			if(memo[i][sum+1000] != Integer.MIN_VALUE) {
				return memo[i][sum+1000];
			}
			int add = calculate1(nums, i+1, sum+nums[i], S, memo);
			int sub = calculate1(nums, i+1, sum-nums[i], S, memo);
			memo[i][sum+1000] = add + sub;
			return memo[i][sum+1000];
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
