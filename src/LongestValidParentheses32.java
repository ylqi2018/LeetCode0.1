import java.util.Stack;

public class LongestValidParentheses32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LongestValidParentheses32().longestValidParentheses("()"));
	}
	
	// method 1
	public int longestValidParentheses(String s) {
		int maxlen = 0;
		for(int i=0; i<s.length(); i++) {
			for(int j=i+2; j<=s.length(); j+=2) {
				if(isValid(s.substring(i, j))) {
					maxlen = Math.max(maxlen, j-i);
				}
			}
		}
		return maxlen;	
	}
	
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='(') {
				stack.push('(');
			} else if(!stack.empty() && stack.peek()=='(') {
				stack.pop();
			} else {
				return false;
			}
		}
		return stack.empty();
	}
	
	public int longestValidParentheses1(String s) {
		int maxans = 0;
		int[] dp = new int[s.length()];
		for(int i=1; i<s.length(); i++) {
			if(s.charAt(i)==')') {
				if(s.charAt(i-1)=='(') {
					dp[i] = (i>=2 ? dp[i-2] : 0) + 2;
				} else if(i-dp[i-1]> 0 && s.charAt(i-dp[i-1]-1)=='(') {
					dp[i] = dp[i-1] + ((i-dp[i-1]) >= 2 ? dp[i-dp[i-1]-2]:0) + 2;
				}
				maxans = Math.max(maxans, dp[i]);
			}
		}
		return maxans;
	}
	
	public int longestValidParentheses2(String s) {
		int maxans = 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='(') {
				stack.push(i);
			} else {
				stack.pop();
				if(stack.empty()) {
					stack.push(i);
				} else {
					maxans = Math.max(maxans, i-stack.peek());
				}
			}
		}
		return maxans;
	}
	
	public int longestValidParentheses3(String s) {
		int left = 0;
		int right = 0;
		int maxLength = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='(') {
				left++;
			} else {
				right++;
			}
			if(left == right) {
				maxLength = Math.max(maxLength, 2*right);
			} else if(right > left) {
				left = 0;
				right = 0;
			}
		}
		left = 0;
		right = 0;
		for(int i=s.length()-1; i>=0; i--) {
			if(s.charAt(i)=='(') {
				left++;
			} else {
				right++;
			}
			if(left == right) {
				maxLength = Math.max(maxLength, 2*left);
			} else if(left > right) {
				left = 0;
				right = 0;
			}
		}
		return maxLength;
	}

}
