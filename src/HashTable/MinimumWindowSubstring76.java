package HashTable;

public class MinimumWindowSubstring76 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ADOBECODEBANC";
		String t = "ABC";
		MinimumWindowSubstring76 mws = new MinimumWindowSubstring76();
		String res = mws.minWindow(s, t);
		System.out.println(res);
	}

	/**
	 * runtime = 4ms
	 * @param s
	 * @param t
	 * @return
	 */
	public String minWindow(String s, String t) {
        int[] map = new int[128];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for(char c: tc) {
        	map[c]++;
        }
        int count = t.length();
        int begin = 0;
        int end = 0;
        int len = Integer.MAX_VALUE;
        int head = 0;
        
        while(end < sc.length) {
        	if(map[sc[end++]]-- > 0) {	// in t
        		count--;
        	}
        	while(count == 0) {
        		if(end - begin < len) {
        			len = end - (head = begin);
        		}
        		if(map[sc[begin++]]++==0) {
        			count++;
        		}
        	}
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(head, head + len);
    }
	
	/**
	 * 7ms
	 * @param s
	 * @param t
	 * @return
	 */
	public String minWindow1(String s, String t) {
		int[] map = new int[128];
		for(char c: t.toCharArray()) {
			map[c]++;
		}
		int count = t.length();
		int begin = 0;
		int end = 0;
		int len = Integer.MAX_VALUE;
		int head = 0;
		
		while(end < s.length()) {
			if(map[s.charAt(end++)]-- > 0) {	// s.charAt(end) is in t
				count--;	
			}
			while(count==0)	{		// valid
				if(end - begin < len) {
					len = end - (head = begin);
				}
				if(map[s.charAt(begin++)]++==0) {
					count++;
				}
			}
		}
		return len == Integer.MAX_VALUE? "": s.substring(head, head+len);
	}

	
	/**
	 * 5ms
	 * @param s
	 * @param t
	 * @return
	 */
	public String minWindow2(String s, String t) {
		int[] map = new int[128];
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		
		for(char c: tc) {
			map[c]++;
		}
		
		int start = 0;
		int end = 0;		
		int counter = t.length();
        
		int minStart = 0;
		int minLen = Integer.MAX_VALUE;
		int slen = s.length();
		
		while(end < slen) {
			// If char in s exists in t, decrease counter
			if(map[sc[end]] > 0) {
				counter--;
			}
			// Decrease map[sc[end]]. If char does not exist in t, map[sc[end]] will be negative
			map[sc[end]]--;
			end++;
			
			// When we found a valid window, move start to find smaller window
			while(counter==0) {
				if(end - start < minLen) {
					minStart = start;
					minLen = end - start;
				}
				map[sc[start]]++;
				// when char exists in t, increase counter
				if(map[sc[start]] > 0) {
					counter++;
				}
				start++;
			}
		}
		if(minLen != Integer.MAX_VALUE) {
			return s.substring(minStart, minStart + minLen);
		} else {
			return "";
		}
	}
	
	/**
	 * 3 ms
	 * @param s
	 * @param t
	 * @return
	 */
    public String minWindow3(String s, String t) {
        int[] map = new int[128];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        // Initialize the counter
        for(char c: tc) {
            map[c]++;
        }
        
        int counter = t.length();
        int begin = 0;
        int end = 0;
        int len = Integer.MAX_VALUE;
        int slen = s.length();
        int head = 0;
        
        while(end < slen) {
            if(map[sc[end]] > 0) {  // the char in s exists in t
                counter--;
            }
            map[sc[end]]--;
            end++;
            
            while(counter==0) {
                if(end - begin < len) {
                    head = begin;
                    len = end - begin;
                }
                map[sc[begin]]++;
                if(map[sc[begin]] > 0) {
                    counter++;
                }
                begin++;
            }
        }
        
        return len == Integer.MAX_VALUE ? "" : s.substring(head, head+len);
        
    }
	
	
	
	
	
}
