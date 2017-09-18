package interview;

public class BestTimetoBuyansSellStockIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxProfit(int[] prices) {
		if(prices == null ||prices.length == 0) {
			return 0;
		}
		int[] g = new int[3];
		int[] l = new int[3];
		for(int i=0; i<prices.length-1; i++) {
			int diff = prices[i+1] - prices[i];
			for(int j=2; j>=1; j--) {
				l[j] = Math.max(g[j-1] + Math.max(diff, 0), l[j]+diff);
				g[j] = Math.max(l[j], g[j]);
			}
		}
		return g[2];
	}

}
