package String;

public class RegularExpressionMatching10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) {
            return s.isEmpty();
        }
        
        boolean firstMatch = (!s.isEmpty() && (p.charAt(0)==s.charAt(0) || p.charAt(0)=='.'));
        
        if(p.length()>=2 && p.charAt(1)=='*') {
            return (isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p)));
        } else {
            return (firstMatch && isMatch(s.substring(1), p.substring(1)));
        }       
    }
    
    public boolean isMatch1(String text, String pattern) {
    	boolean T[][] = new boolean[text.length()+1][pattern.length()+1];
    	
    	T[0][0] = true;
    	
    	for(int i=1; i<T[0].length; i++) {
    		if(pattern.charAt(i-1)=='*') {
    			T[0][i] = T[0][i-2];
    		}
    	}
    	
    	for(int i=1; i<T.length; i++) {
    		for(int j=1; j<T[0].length; j++) {
    			if(pattern.charAt(j-1)=='.' || pattern.charAt(j-1)==text.charAt(i-1)) {
    				T[i][j] = T[i-1][j-1];
    			} else if(pattern.charAt(j-1)=='*') {
    				T[i][j]=T[i][j-2];
    				if(pattern.charAt(j-2)=='.' || pattern.charAt(j-2)==text.charAt(i-1)) {
    					T[i][j] = T[i][j] | T[i-1][j];
    				}
    			} else {
    				T[i][j] = false;
    			}
    		}
    	}
    	return T[text.length()][pattern.length()];
    }
    

    
    public boolean isMatch2(String s, String p) {

        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    
}
