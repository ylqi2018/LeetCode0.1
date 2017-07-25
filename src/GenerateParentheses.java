import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> generateParentheses(int n) {
		List<String> list = new ArrayList<String>();
		backtrack(list, "", 0, 0, n);
		return list;
	}
	
	public void backtrack(List<String> list, String str, int open, int close, int max) {
		if(str.length() == 2*max) {
			list.add(str);
			return;
		}
		
		if(open < max) {
			backtrack(list, str+"(", open+1, close, max);
		}
		
		if(close < open) {
			backtrack(list, str+")", open, close+1, max);
		}
	}

}
