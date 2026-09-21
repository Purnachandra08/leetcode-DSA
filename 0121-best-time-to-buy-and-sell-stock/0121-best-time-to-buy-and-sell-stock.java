class Solution {
    public int maxProfit(int[] prices) {
        int minProfit = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            int profit = prices[i] - minProfit;
            maxProfit = Math.max(maxProfit, profit);
            minProfit = Math.min(minProfit, prices[i]);
        }
        return maxProfit;
    }
}