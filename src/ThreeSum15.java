import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array S of n integers, are there elements a, b, c in S 
 * such that a + b + c = 0? Find all unique triplets in the array 
 * which gives the sum of zero.
 */
/*
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum15 {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		int len = nums.length;
		int left;
		int right;
		int sum;
		for(int i=0; i<len-2; i++) {
			if(i!=0 && nums[i-1]==nums[i]) {
				continue;
			}
			left = i + 1;
			right = len - 1;
			while(left < right) {
				sum = nums[i] + nums[left] + nums[right];
				if(sum < 0) {
					left++;
				} else if(sum > 0) {
					right--;
				} else {
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));
					while(left < right && nums[left] == nums[left+1]) {
						left++;
					}
					left++;
					right--;
				}
			}	
		}
		return res;
	}
}
