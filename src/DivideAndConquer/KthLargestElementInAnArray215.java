package DivideAndConquer;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray215 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findKthLargest(int[] nums, int k) {
		int N = nums.length;
		Arrays.sort(nums);
		return nums[N-k];
	}
	
	public int findKthLargest1(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int val: nums) {
			pq.offer(val);
			
			if(pq.size() > k) {
				pq.poll();
			}
		}
		return pq.peek();
	}

}
