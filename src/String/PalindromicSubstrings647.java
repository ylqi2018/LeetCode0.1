package String;

public class PalindromicSubstrings647 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int count=0;
	
	public int countSubstrings(String s) {
		if(s==null || s.length()==0) {
			return 0;
		}
		
		for(int i=0; i<s.length(); i++) {	// i is the mid point
			extendPalindromic(s, i, i);
			extendPalindromic(s, i, i+1);
		}
		
		return count;
	}
	
	private void extendPalindromic(String s, int left, int right) {
		while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
			count++;
			left--;
			right++;
		}
	}

}
