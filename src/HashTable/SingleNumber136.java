package HashTable;

import java.util.Hashtable;

public class SingleNumber136 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int singleNumber(int[] nums) {
        int result = 0;
        int len = nums.length;
        for(int i=0; i<len; i++) {
        	result ^= nums[i];
        }
        return result;
    }
    
    // not very fast
    public int singleNumber1(int[] nums) {
    	Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
    	for(int i=0; i<nums.length; i++) {
    		if(! ht.containsKey(nums[i])) {
    			ht.put(nums[i], i);
    		} else {
    			ht.remove(nums[i]);
    		}
    	}
    	return (Integer)ht.keySet().toArray()[0];
    }

}
