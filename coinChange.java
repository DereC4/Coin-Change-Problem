import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        /**
         * Initialize a DP array to an array of length = (our target amount + 1)
         * Fill the array to amount + 1, leaving index 0 as 0
         */
        int counts[] = new int[amount + 1];
        Arrays.fill(counts, amount + 1);
        counts[0] = 0;

        /**
         * Searching through each index to find the OPTIMAL coin value.
         * In future indexes, use the previous OPTIMAL value and add one more coin to that
         */
        for(int i = 0; i < counts.length; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(i - coins[j] >= 0) {
                    /**
                     * So we want to find the index that is at our current index
                     * minus our current coin. Then see if comparing that to our
                     * current index's value gives a better OPTIMAL value
                     * 
                     * For example, if we are at index 6, that represents 6 cents.
                     * We find that our first coin in the coin array, is 5. 
                     * 
                     * Thus we will subtract 5 from 6 to get 1. That means we
                     * are looking at index 1, aka what the OPTIMAL value is
                     * for "1 cent"
                     */
                    counts[i] = Math.min(counts[i], counts[i - coins[j]] + 1);
                }
            }
        }
        return counts[amount] >= amount + 1 ? -1 : counts[amount];
    }
}
