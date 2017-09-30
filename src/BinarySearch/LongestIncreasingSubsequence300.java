package BinarySearch;

public class LongestIncreasingSubsequence300 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int lengthOfLIS(int[] nums) {
		if(nums==null || nums.length==0) {
			return 0;
		}
		
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int maxans = 1;
		
		for(int i=1; i<dp.length; i++) {
			int maxval = 0;
			for(int j=0; i<i; j++) {
				if(nums[i] > nums[j]) {
					maxval = Math.max(maxval, dp[j]);
				}
			}
			dp[i] = maxval + 1;
			maxans = Math.max(maxans, dp[i]);
		}
		return maxans;
	}
	
	/*
	 * Solution:
	 * Dynamic Programming is used to solve this question. And DP equation is
	 * if(arr[i] > arr[j]) {
	 *     T[i] = max(T[i], T[j]+1);
	 * }
	 */
	// Not work
//	public int lengthOfLIS(int[] nums) {
//		int[] T = new int[nums.length];
//		int[] actualSolution = new int[nums.length];
//		for(int i=0; i<nums.length; i++) {
//			T[i] = 1;
//			actualSolution[i] = i;
//		}
//		
//		for(int i=1; i<nums.length; i++) {
//			for(int j=0; j<i; j++) {
//				if(nums[i] > nums[j]) {
//					if(T[j] + 1 > T[i]) {
//						T[i] = T[j] + 1;
//						actualSolution[i] = j;
//					}
//				}
//			}
//		}
//		
//		// Find the index of the max number in T
//		int maxIndex = 0;
//		for(int i=0; i< T.length; i++) {
//			if(T[i] > T[maxIndex]) {
//				maxIndex = i;
//			}
//		}
//		
//		//lets print the actual solution
//		return T[maxIndex];		
//	}
	

}
