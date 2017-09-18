package interview;

public class BestTimetoBuyansSellStockII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {7, 1, 5, 3, 6, 4};
		System.out.println(new BestTimetoBuyansSellStockII().maxProfit(prices));
	}
	
	public int maxProfit(int[] prices) {
		int res = 0;
		for(int i=0; i<prices.length-1; i++) {
			if(prices[i] < prices[i+1]) {
				res += prices[i+1] - prices[i];
			}
		}
		return res;
	}

}
