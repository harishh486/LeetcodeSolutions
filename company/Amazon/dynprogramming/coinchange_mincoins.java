class Solution {
    public int coinChange(int[] coins, int amount) {
        
        // whenever u hear fewest, highest, maximum, minimum, shortes, longest --keywords
        //better can be solved using dp
        
        // here we can solve the problemm d[i] --is them min no of coins for denomination i dollars
        
        // d[amount+1] == o index based
         int dp[] = new int[amount +1];
         //initialled filled with 0, so we will make it maximum since asked min
        Arrays.fill(dp, amount+1);
        dp[0]=0;
        for(int i=0; i<= amount; i++){
            for(int j=0; j< coins.length; j++){
                
                // now we compare if coins[j] which is acurrent coin is <= amount. wecan take that coin
                // here we calculate dp[i], we take min of dp[i], 1+ optimal sol of(i-coins[j])
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], 1+dp[i-coins[j]]);
                    
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
        
    }
}



// Input: coins = [1, 2, 5], amount = 11
// Output: 3 
// Explanation: 11 = 5 + 5 + 1
// Example 2:

// Input: coins = [2], amount = 3
// Output: -1

// T: o(m*n)
// S: o(amount)


Little optimization:
sort array of coins, so that when comparing if we have larger coins for smaller Value, we ll break and go to bigger Value


class Solution {
    public int coinChange(int[] coins, int amount) {
        
        // whenever u hear fewest, highest, maximum, minimum, shortes, longest --keywords
        //better can be solved using dp
        
        // here we can solve the problemm d[i] --is them min no of coins for denomination i dollars
        
        // d[amount+1] == o index based
         Arrays.sort(coins);
         int dp[] = new int[amount +1];
         //initialled filled with 0, so we will make it maximum since asked min
        Arrays.fill(dp, amount+1);
        dp[0]=0;
        for(int i=0; i<= amount; i++){
            for(int j=0; j< coins.length; j++){
                
                // now we compare if coins[j] which is acurrent coin is <= amount. wecan take that coin
                // here we calculate dp[i], we take min of dp[i], 1+ optimal sol of(i-coins[j])
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], 1+dp[i-coins[j]]);
                    
                }
                else {
                    break;
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
        
    }
}