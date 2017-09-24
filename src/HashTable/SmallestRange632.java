package HashTable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRange632 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(4);
		list1.add(10);
		list1.add(15);
		list1.add(24);
		list1.add(26);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(0);
		list2.add(9);
		list2.add(15);
		list2.add(20);
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(5);
		list3.add(18);
		list3.add(22);
		list3.add(30);
		List<List<Integer>> nums = new ArrayList<List<Integer>>();
		
		SmallestRange632 sr = new SmallestRange632();
		int[] res = sr.smallestRange(nums);
		System.out.println(res);
	}
	
	public int[] smallestRange(List<List<Integer>> nums) {
		// An unbounded priority queue based on a priority heap. 
		// The elements of the priority queue are ordered according to their natural ordering, 
		// or by a Comparator provided at queue construction time, depending on which constructor is used.
		PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(nums.size(), new Comparator<int[]>(){
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		int max = nums.get(0).get(0);
		// Add every first num to the minHeap
		// update the max
		for(int i=0; i<nums.size(); i++) {
			minHeap.add(new int[]{nums.get(i).get(0), i, 0});	//¾²Ì¬³õÊ¼»¯ http://blog.csdn.net/u014199097/article/details/50551731
			max = Math.max(max, nums.get(i).get(0));
		}
		
		int minRange = Integer.MAX_VALUE;
		int start = -1;
		while(minHeap.size() == nums.size()) {
			int[] t = minHeap.poll();
			if(max - t[0] < minRange) {
				minRange = max - t[0];
				start = t[0];
			}
			
			if(t[2]+1 < nums.get(t[1]).size()) {
				t[0] = nums.get(t[1]).get(t[2]+1);
				t[2]++;
				minHeap.add(t);
				max = Math.max(max, t[0]);
			}
		}
		return new int[]{start, start+minRange};
	}
	
	public int[] smallestRange1(List<List<Integer>> nums) {
		PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(nums.size(), new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		int max = nums.get(0).get(0);	// Initialize the max as the first num of nums[0]
		
		for(int i=0; i<nums.size(); i++) {
			minHeap.add(new int[]{nums.get(i).get(0), i, 0});	// the value in the List, the no. of List, the index
			max = Math.max(max, nums.get(i).get(0));
		}
		
		int minRange = Integer.MAX_VALUE;
		int start = -1;
		
		while(minHeap.size() == nums.size()) {
			int[] t = minHeap.poll();
			if(max - t[0] < minRange) {
				minRange = max - t[0];
				start = t[0];
			}
			
			if(t[2]+1 < nums.get(t[1]).size()) {
				t[0] = nums.get(t[1]).get(t[2]+1);
				t[2]++;
				minHeap.add(t);
				max = Math.max(max, t[0]);
			}
		}
		return new int[]{start, start+minRange};
	}
	

}
