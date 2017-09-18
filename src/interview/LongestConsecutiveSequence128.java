package interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence128 {
	
	public static void main(String[] args) {
		LongestConsecutiveSequence128 lcs = new LongestConsecutiveSequence128();
		int[] nums = {100, 4, 200, 1, 3, 2};
		int res = lcs.longestConsecutive1(nums);
		System.out.println(res);
	}
	
	public int longestConsecutive(int[] nums) {
		int res = 0;
		Set<Integer> s = new HashSet<Integer>();
		for(int num: nums) {
			s.add(num);
		}
		for(int num: nums) {
			if(s.remove(num)) {
				int pre = num - 1;
				int next = num + 1;
				while(s.remove(pre)) pre--;
				while(s.remove(next)) next++;
				res = Math.max(res, next - pre - 1);				
			}
		}
		return res;
	}
	
	public int longestConsecutive1(int[] nums) {
		int res = 0;
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for(int num: nums) {
			if(m.containsKey(num)) continue;
			int left = m.containsKey(num - 1) ? m.get(num - 1) : 0;
			int right = m.containsKey(num + 1) ? m.get(num + 1) : 0;
			int sum = left + right + 1;
			m.put(num, sum);
			res = Math.max(res, sum);
			m.put(num - left, sum);
			m.put(num + right, sum);
		}
		return res;
	}

}
