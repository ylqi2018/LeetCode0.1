
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        Set<Character> set = new HashSet<Character>();
        int ans = 0;
        int i = 0;
        int j = 0;
        while(i<len && j<len) {
        	// Try to extend the range [i, j)
        	if(!set.contains(s.charAt(j))) {
        		set.add(s.charAt(j++));
        		ans = Math.max(ans, j-i);
        	} else {
        		set.remove(s.charAt(i++));
        	}
        }
        return ans;
    }
	
	public int lengthOfLongestSubstring1(String s) {
        int len = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        // Try to extend the map
        for(int i=0, j=0; j<len; j++) {
            if(map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            map.put(s.charAt(j), j+1);
            ans = Math.max(ans, j-i+1);
        }
        return ans;
    }

}
