import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a set of distinct integers, nums,
 * return all possible subsets
 */
public class Subsets78 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		backtrack(subsets, new ArrayList<Integer>(), nums, 0);
		return subsets;
    }
	
	private void backtrack(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int start) {
		// if(start == nums.length-1) {
			subsets.add(new ArrayList<Integer>(subset));
		// 	return;
		// }
		for(int i=start; i<nums.length; i++) {
			subset.add(nums[i]);
			backtrack(subsets, subset, nums, i+1);
			subset.remove(subset.size()-1);
		}
	}
	
	

}
