package DynamicProgramming;

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
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
