package HashTable;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cbaebabacd";
		String p = "abc";
		FindAllAnagramsInAString fa = new FindAllAnagramsInAString();
		List<Integer> res = fa.findAnagrams(s, p);
		System.out.println(res);
	}
	
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
		
		// Two points, initialize count to p's length
		int left = 0;
		int right = 0;
		int count = p.length();
		while(right < s.length()) {
			//move right everytime, if the character exists in p's hash, decrease the count
			//current hash value >=1 means the charater is existing in p
			if(hash[s.charAt(right++)]-- >= 1) count--;
			
			//when count is down to 0, means we found the right anagram
			if(count==0) list.add(left);
			
			//if we find the window's size equals to p, then we have to move left (narrow the window
			// to find the new match window, ++ to reset the hash because we kicked out the left
			// only increase the count if the charcter is in p
			// the count >= 0 indicate it wwas original in the hash, cuz it won't below 0
			if(right-left == p.length() && hash[s.charAt(left++)]++>=0) count++;
		}
		return list;
	}

}
