class Solution {
    public int maxProfit(int[] prices) {
        
        // here we can check 2 cases for every price
        // maintain two variables minPrice and MaxProfit
        // do 2 things for every proce on every day
        // 1. if current price on that day which prices[i] is less than minPrice then buy it..meaning
        //     min= prices[i]
        // 2. if there is no minimum, then u could check if we sell this day could we get better profit
        //     maxProfit = Max(maxprofit, prices[i]-min)
        //                     i.e todays prices - min price that we could have bought
        //     and update maxprofit for each ietration, then max profit is the answer
                
        int maxProfit=0;
        int minPrice = Integer.MAX_VALUE;
        
        for(int i=0; i< prices.length;i++){
            if(prices[i] < minPrice){
                // buy it
                minPrice = prices[i];
            }else {
                //sell it if we get max profit , if we sell on that day
                maxProfit = Math.max(maxProfit, prices[i]-minPrice);
                    
            }
            
        }
        return maxProfit;
        
        
    }
}


// T: o(n)
// S:0(1)


// Input: [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//              Not 7-1 = 6, as selling price needs to be larger than buying price.
// Example 2:

// Input: [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transaction is done, i.e. max profit = 0.