

public class UniquePaths62 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int uniquePaths(int m, int n) {
		int N = m + n -1;	// how much steps need to do
		int k = m - 1;		// number of steps that need to go down
		int res = 1;
		
		// here we calculate the total possible path number
		// Combination(N, k) = N! / (k! * (N-k)!)
		// reduce the numerator and denominator and get
		for(int i=1; i<=k; i++) {
			res = res * (N - k + i) / i;
		}
		return res;
	}

}
