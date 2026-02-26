class Solution {
    int maxProfit = 0;
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, max = 0;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {

            if (min > prices[i]) {
                min = prices[i];
            } else {
                profit = prices[i] - min;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

            
        return maxProfit;
    }
}
