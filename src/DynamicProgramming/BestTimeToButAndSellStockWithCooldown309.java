package DynamicProgramming;

public class BestTimeToButAndSellStockWithCooldown309 {

	public int maxProfit(int[] prices) {
		int sell = 0;
		int prev_sell = 0;
		int buy = Integer.MIN_VALUE;
		int prev_buy = 0;
		for(int price: prices) {
			prev_buy = buy;
			buy = Math.max(prev_sell - price, prev_buy);
			prev_sell = sell;
			sell = Math.max(prev_buy + price, prev_sell);
		}
		return sell;
	}
	
	
    public int maxProfit1(int[] prices) {
        int sell = 0;
        int prev_sell = 0;
        int buy = Integer.MIN_VALUE;
        int prev_buy = 0;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
