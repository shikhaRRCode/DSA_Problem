class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        //at the beginning the first price is the minimum price
        int buy_price = prices[0];
        //at the beginning the maximum profit is zero
        int maxProfit = 0;

        for(int i = 1 ; i < n ; i++)
        {
            //if the current price is less than buy price
            if(prices[i] < buy_price){
                buy_price = prices[i];
            }
            else{
                //check if we can get a better profit
                int curr_profit = prices[i] - buy_price;
                maxProfit = Math.max(maxProfit , curr_profit);
            }
        }
        return maxProfit;
    }
}