package DynamicProgramming;

import java.util.Arrays;

public class PartitionEqualSubsetSum416 {

	public boolean canPartition(int[] nums) {
		int sum = 0;
		for(int num: nums) {
			sum += num;
		}
		
		if((sum & 1) == 1) {
			return false;
		}
		
		sum /= 2;
		
		int len = nums.length;
		
		boolean[][] dp = new boolean[len+1][sum+1];
		for(int i=0; i<dp.length; i++) {
			Arrays.fill(dp[i], false);
		}
		dp[0][0] = true;
		for(int i=1; i<len+1; i++) {
			dp[i][0] = true;
		}
		for(int j=1; j<sum+1; j++) {
			dp[0][j] = false;
		}
		
		for(int i=1; i<len+1; i++) {
			for(int j=1; j<sum+1; j++) {
				dp[i][j] = dp[i-1][j];
				if(j >= nums[i-1]) {
					dp[i][j] = (dp[i-1][j] || dp[i-1][j-nums[i-1]]);
				}
			}
		}
		return dp[len][sum];
	}
	
	public boolean canPartition1(int[] nums) {
		int sum = 0;
		for(int num: nums) {
			sum += num;
		}
		if((sum & 1) == 1) {
			return false;
		}
		sum /= 2;
		
		int len = nums.length;
		boolean[] dp = new boolean[sum+1];
		dp[0] = true;
		
		for(int num: nums) {
			for(int i=sum; i>0; i--) {
				if(i>=num) {
					dp[i] = dp[i] || dp[i-num];
				}
			}
		}
		return dp[sum];
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
