
public class SearchForRange34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5, 7, 7, 8, 8, 10};
		int[] res = new SearchForRange34().searchRange(nums, 8);
		System.out.println("" + res[0]);
		System.out.println("" + res[1]);
	}
	
	public int[] searchRange(int[] nums, int target) {
		int[] res = new int[2];
		res[0] = -1;
		res[1] = -1;
		
		if(nums == null || nums.length == 0) {
			return res;
		}
		
		res[0] = findLeftBound(nums, target, 0, nums.length - 1);
		if(res[0] < 0) {
			return res;
		}
		res[1] = findRightBound(nums, target, 0, nums.length - 1);
		return res;
	}

	private int findLeftBound(int[] nums, int target, int start, int end) {
		if(start > end) {
			return -1;
		}
		
		int mid = (start + end)/2;
		
		if(target < nums[mid]) {
			return findLeftBound(nums, target, start, mid-1);
		} else if(target > nums[mid]) {
			return findLeftBound(nums, target, mid+1, end);
		} else {
			if(mid == 0 || nums[mid-1] != target) {
				return mid;
			}
			return findLeftBound(nums, target, start, mid-1);
		}
	}
	
	private int findRightBound(int[] nums, int target, int start, int end) {
		if(start > end) {
			return -1;
		}
		
		int mid = (start + end) / 2;
		if(target < nums[mid]) {
			return findRightBound(nums, target, start, mid - 1);
		} else if(target > nums[mid]) {
			return findRightBound(nums, target, mid + 1, end);
		} else {
			if(mid == nums.length - 1 || nums[mid+1] != target) {
				return mid;
			}
			return findRightBound(nums, target, mid+1, end);
		}	
	}

}
