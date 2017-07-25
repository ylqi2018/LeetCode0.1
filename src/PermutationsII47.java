import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a collection of numbers that might contain duplicates,
 * return all possible unique permutations.
 */

public class PermutationsII47 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		backtrack(subsets, new ArrayList<Integer>(), nums, new boolean[nums.length]);
		return subsets;
	}
	
	public void backtrack(List<List<Integer>> subsets, List<Integer> subset, int[] nums, boolean[] used) {
		if(subset.size() == nums.length) {
			subsets.add(new ArrayList<Integer>(subset));
		}
		for(int i=0; i<nums.length; i++) {
			if(used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1]) {
				continue;
			}
			used[i] = true;
			subset.add(nums[i]);
			backtrack(subsets, subset, nums, used); 
			used[i] = false;
			subset.remove(subset.size() - 1);
		}
	}

}
