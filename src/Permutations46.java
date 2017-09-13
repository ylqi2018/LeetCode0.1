import java.util.ArrayList;
import java.util.List;

public class Permutations46 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3};
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list = new Permutations46().permute(nums);
	}
	
	public List<List<Integer>> permute(int[] nums) {
		   List<List<Integer>> list = new ArrayList<>();
		   // Arrays.sort(nums); // not necessary
		   backtrack(list, new ArrayList<>(), nums);
		   return list;
		}

		private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
		   if(tempList.size() == nums.length){
		      list.add(new ArrayList<>(tempList));
		   } else{
		      for(int i = 0; i < nums.length; i++){ 
		         if(tempList.contains(nums[i])) continue; // element already exists, skip
		         tempList.add(nums[i]);
		         backtrack(list, tempList, nums);
		         tempList.remove(tempList.size() - 1);
		      }
		   }
		} 

}
