class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int target = 1; target < dp.length; target++) {
            for (int c = 0; c < coins.length; c++) {
                int coinVal = coins[c];
                if (target >= coinVal) {
                    int prev = dp[target - coinVal];
                    if (prev != Integer.MAX_VALUE) {
                        dp[target] = Math.min(dp[target], prev + 1);
                    }
                    
                }
            }
        }
        return (dp[dp.length - 1] == Integer.MAX_VALUE) ? -1 : dp[dp.length - 1];
    }
}