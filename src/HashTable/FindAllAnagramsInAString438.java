package HashTable;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString438 {

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<Integer>();
		if(s==null || s.length()==0 || p==null || p.length()==0) {
			return list;
		}
		
		int[] hash = new int[256];	// Character hash
		// Record each character in p to hash
		for(char c: p.toCharArray()) {
			hash[c]++;
		}
		
		// Two pointers
		int left = 0;
		int right = 0;
		int count = p.length();	// Initialize count to p'length
		while(right < s.length()) {		// when right=s.length-1, this loop will run; when right==s.length, this loop finish
			if(hash[s.charAt(right)] >= 1) {
				count--;
			}
			hash[s.charAt(right)]--;
			right++;
			
			// when the count is down to 0, means we found the right anagram
			// then add window's left to result list
			if(count==0) {
				list.add(left);
			}
			
			// if we found the window's size equals to p, then we have to move left to find the new match window
			if(right-left == p.length()) {
				if(hash[s.charAt(left)] >= 0) {
					count++;
				}
				hash[s.charAt(left)]++;
				left++;
			}
		}
		return list;
	}
	

}
