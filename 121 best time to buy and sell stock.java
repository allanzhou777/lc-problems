class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int globalMax = 0;
        for (int i = 1; i < prices.length; i++) {
            globalMax = Math.max(prices[i] - min, globalMax);
            min = Math.min(min, prices[i]);
        }
        return globalMax;
    }
}