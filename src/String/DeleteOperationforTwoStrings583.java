package String;

public class DeleteOperationforTwoStrings583 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int minDistance(String word1, String word2) {
        
        int len1 = word1.length();
        int len2 = word2.length();
        
        if(len1 ==0 && len2 != 0){
            return len2;
        }
        if(len2 ==0 && len1 != 0){
            return len1;
        }
        
        int [][] mygrid = new int[len1+1][len2+1];
        
        for(int row =1; row <=len1; row++){
            for(int cols = 1; cols<=len2; cols++){
                if(word1.charAt(row-1)== word2.charAt(cols-1)){
                    mygrid[row][cols] = mygrid[row-1][cols-1]+1;        // Found equal char, get cell from diagonally and add 1.
                }else{
                    mygrid[row][cols] = Math.max(mygrid[row-1][cols], mygrid[row][cols-1]);     // not found char, find max(top and left)
                }
            }
        }
        
        int num_of_steps = mygrid[len1][len2]; 
        
        int final_answer = len1+len2-2*(num_of_steps);
        
        return final_answer;
    }
	
    /**
     * Time Limit Exceeded.
     * @param s1
     * @param s2
     * @return
     */
    public int minDistance1(String s1, String s2) {
    	return s1.length() + s2.length() - 2*lcs(s1, s2, s1.length(), s2.length());
    }
    
    private int lcs(String s1, String s2, int m, int n) {
    	if(m==0 || n==0) {
    		return 0;
    	}
    	
    	if(s1.charAt(m-1)==s2.charAt(n-1)) {
    		return 1 + lcs(s1, s2, m-1, n-1);
    	} else {
    		return Math.max(lcs(s1, s2, m, n-1), lcs(s1, s2, m-1, n));
    	}
    }
	
    public int minDistance2(String s1, String s2) {
        int[][] memo = new int[s1.length()+1][s2.length()+1];
        return s1.length() + s2.length() - 2*lcs(s1, s2, s1.length(), s2.length(), memo);
    } 
    private int lcs(String s1, String s2, int m, int n, int[][] memo) {
        if(m==0 || n==0) {
            return 0;
        }
        if(memo[m][n]>0) {
            return memo[m][n];
        }
        if(s1.charAt(m-1)==s2.charAt(n-1)) {
            memo[m][n] = 1 + lcs(s1, s2, m-1, n-1, memo);
        } else {
            memo[m][n] = Math.max(lcs(s1, s2, m-1, n, memo), lcs(s1, s2, m, n-1, memo));
        }
        return memo[m][n];
    }
    
    /**
     * run time: 68 ms
     * @param s1
     * @param s2
     * @return
     */
    public int minDistance3(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        
        for(int i=0; i<=s1.length(); i++) {
            for(int j=0; j<=s2.length(); j++) {
                if(i==0 || j==0) {
                    continue;
                }
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return s1.length()+s2.length()-2*dp[s1.length()][s2.length()];
    }
    
    /**
     * run time: 53s
     * @param s1
     * @param s2
     * @return
     */
    public int minDistance4(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        
        if(len1==0 && len2!= 0) {
            return len2;
        }
        if(len1!=0 && len2==0) {
            return len1;
        }
        
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        
        for(int i=1; i<=s1.length(); i++) {
            for(int j=1; j<=s2.length(); j++) {
                if(i==0 || j==0) {
                    continue;
                }
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return s1.length()+s2.length()-2*dp[s1.length()][s2.length()];
    }
    
}
