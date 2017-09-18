package interview;

public class BestTimetoBuyandSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length <=1) {
			return 0;
		}
		int min = prices[0];
		int profit = 0;
		
		for(int i=1; i<prices.length; i++) {
			// find lower buy prices
			if(prices[i] < min) {
				min = prices[i];
			} else {
				if(prices[i] - min > profit) {
					profit = prices[i] - min;
				}
			}
		}
		return profit;
	}
	
	public int maxProfit1(int[] prices) {
		int maxprofit = 0;
		for(int i=0; i<prices.length; i++) {
			for(int j=i+1; j<prices.length; j++) {
				int profit = prices[j] - prices[i];
				if(profit > maxprofit) {
					maxprofit  = profit;
				}
			}
		}
		return maxprofit;
	}
	
	public int maxProfit2(int[] prices) {
		int minprice = Integer.MAX_VALUE;
		int maxprofit = 0;
		for(int i=0; i<prices.length; i++) {
			if(prices[i] < minprice) {
				minprice = prices[i];
			} else if(prices[i] - minprice > maxprofit) {
				maxprofit = prices[i] - minprice;
			}
		}
		return maxprofit;
	}
	
	public int maxProfit3(int[] prices) {
		int res = 0;
		int buy = Integer.MAX_VALUE;
		for(int price: prices) {
			buy = Math.min(buy, price);
			res = Math.max(res, price - buy);
		}
		return res;
	}

}
