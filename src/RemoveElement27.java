
public class RemoveElement27 {
	
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums == null) {
            return 0;
        }
        int i=0;
        for(int j=1; j<nums.length; j++) {
            if(nums[i] != nums[j]) {
                
                nums[++i] = nums[j];

            }
        }
        return i+1;
    }

}
