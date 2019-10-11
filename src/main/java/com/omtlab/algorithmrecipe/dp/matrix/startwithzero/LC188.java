package com.omtlab.algorithmrecipe.dp.matrix.startwithzero;

import com.omtlab.algorithmrecipe.common.util.MatrixUtil;

/**
 * 188. Best Time to Buy and Sell Stock IV
 * 
 * https://www.youtube.com/watch?v=oDhu5uGq_ic&t=1325s
 * 
 * Say you have an array for which the i-th element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [2,4,1], k = 2
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * Example 2:
 *
 * Input: [3,2,6,5,0,3], k = 2
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
 *              Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 */
public class LC188 {

    /**
     * Check this video : https://www.youtube.com/watch?v=oDhu5uGq_ic&t=1325s
     * 
     * Equation 
     * 
     * Note Here "i" is a number of times 0 to k
     * "j" is a price array 
     * 
     * Max Of One of below. 
     *   -> TRANSACTIONS[i][j-1] OR (price[j]-price[m] + TRANSACTIONS[i-1][m]) 
     *   Here is m = 0 to j-1
     */
    public int maxProfit(int k, int[] prices) {

        int[][] transactions = new int[k+1][prices.length+1];
        
        for(int i=1;i<transactions.length;i++){
            
            for(int j=1; j< transactions[i].length;j++){
                int priviousMax = transactions[i][j-1];
                int priceIndex = j-1;
                
                
                for(int m = 0; m < priceIndex; m++){
                    priviousMax = Math.max(priviousMax,(prices[priceIndex]-prices[m])+transactions[i-1][m]);
                }
                transactions[i][j] = priviousMax;
            }
        }

        MatrixUtil.printMatrix(transactions);
        return  transactions[transactions.length-1][transactions[0].length-1];
    }
    
}
