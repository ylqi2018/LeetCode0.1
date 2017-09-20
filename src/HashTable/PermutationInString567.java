package HashTable;

public class PermutationInString567 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationInString567 pi = new PermutationInString567();
		String s1 = "ab";
		String s2 = "eidbaooo";
		boolean res = pi.checkInclusion1(s1, s2);
		System.out.println(res);
	}
	
	public boolean checkInclusion(String s1, String s2) {
		if(s1.length() > s2.length()) {
			return false;
		}
		
		int[] s1map = new int[26];
		int[] s2map = new int[26];
		
		for(int i=0; i<s1.length(); i++) {
			s1map[s1.charAt(i)-'a']++;	// Count the times the character has appeared
			s2map[s2.charAt(i)-'a']++;
		}
		
		for(int i=0; i<s2.length()-s1.length(); i++) {
			if(matches(s1map, s2map)) {
				return true;
			}
			s2map[s2.charAt(i+s1.length())-'a']++;
			s2map[s2.charAt(i)-'a']--;
		}
		return matches(s1map, s2map);
		
	}
	
	public boolean matches(int[] s1map, int[] s2map) {
		for(int i=0; i<26; i++) {
			if(s1map[i] != s2map[i]) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkInclusion1(String s1, String s2) {
		if(s1.length() > s2.length()) {
			return false;
		}
		
		int[] s1map = new int[26];
		int[] s2map = new int[26];
		for(int i=0; i<s1.length(); i++) {
			s1map[s1.charAt(i)-'a']++;
			s2map[s2.charAt(i)-'a']++;
		}
		
		int count = 0;		
		for(int i=0; i<26; i++) {
			if(s1map[i] == s2map[i]) {
				count++;
			}
		}
		
		for(int i=0; i<s2.length()-s1.length(); i++) {
			int r = s2.charAt(i+s1.length()) - 'a';
			int l = s2.charAt(i) - 'a';
			if(count==26) {
				return true;
			}
			s2map[r]++;
			if(s2map[r] == s1map[r]) {
				count++;
			} else if(s2map[r] == s1map[r] + 1) {
				count--;
			}
			s2map[l]--;
			if(s2map[l] == s1map[l]) {
				count++;
			} else if(s2map[l] == s1map[l] - 1) {
				count--;
			}
		}
		return count == 26;
	}
	

}
