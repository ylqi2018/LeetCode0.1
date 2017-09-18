package interview;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK560 {
	
	public static void main(String[] args) {
		int[] nums = {1, 1, 1};
		SubarraySumEqualsK560 sub = new SubarraySumEqualsK560();
		int res = sub.subarraySum1(nums, 2);
		System.out.println(res);
	}

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        int[] sums = nums;
        for(int i=1; i<n; i++) {
        	sums[i] = sums[i-1] + nums[i];
        }
        
        for(int i=0; i<n; i++) {
        	if(sums[i] == k) res++;
        	for(int j = i-1; j>=0; j--) {
        		if(sums[i] - sums[j] == k) {
        			res++;
        		}
        	}
         }
        return res;
    }
    
    
    public int subarraySum1(int[] nums, int k) {
    	int res = 0;
    	int sum = 0;
    	int n = nums.length;
    	Map<Integer, Integer> m = new HashMap<Integer, Integer>();
    	m.put(0, 1);
    	for(int i=0; i<n; i++) {
    		sum += nums[i];
    		if(m.containsKey(sum-k)) {
    			res += m.get(sum-k);
    		}   		
    		m.put(sum, m.getOrDefault(sum, 0)+1);
    	}
    	return res;
    }
}
