class Solution {
    public int maxProfit(int[] prices) {
        // at the beginning the minimum price is the first price.
        int buy_Price = prices[0];

        // at the beginning the minimum profit is zero.
        int profit = 0;

        for(int i = 1; i < prices.length; i ++){
            //if current price is less update the buy_price.
            if(prices[i] < buy_Price){
                buy_Price = prices[i];
            }else{
                // else check if we can get a better profit.
                int current_profit = prices[i] - buy_Price;
                profit = Math.max(current_profit, profit);
            }
        }
        return profit;
    }
}