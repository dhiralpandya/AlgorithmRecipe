package com.omtlab.algorithmrecipe.dp.singlearray.hardtounderstand;

/**
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 * 
 * Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and
 * a non-negative integer fee representing a transaction fee.
 *
 * You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. 
 * You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)
 *
 * Return the maximum profit you can make.
 *
 * Example 1:
 * Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * Buying at prices[0] = 1
 * Selling at prices[3] = 8
 * Buying at prices[4] = 4
 * Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * Note:
 *
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 */
public class LC714 {

    /**
     * Approach #1: Dynamic Programming [Accepted]
     * Intuition and Algorithm
     *
     * At the end of the i-th day, we maintain cash, the maximum profit we could have if we did not have a share of 
     * stock, and hold, the maximum profit we could have if we owned a share of stock.
     *
     * To transition from the i-th day to the i+1-th day, we either sell our stock cash = max(cash, hold + prices[i] 
     * - fee) or buy a stock hold = max(hold, cash - prices[i]). At the end, we want to return cash. We can transform
     * cash first without using temporary variables because selling and buying on the same day can't be better than 
     * just continuing to hold the stock.
     */


    /**
     * I added some notes below to help me understand it:
     *
     *   1. Only 1 share of the stock can be bought or sold;
     *   2. A stock can be bought or sold for multiple times in one day, but it has to be sold before being bought 
     *   again;
     *   3. The service fee is only charged when stock is sold;
     *   4. Cash(i): the cash in hand, if you are not holding the stock at the end of day(i):
     *       You might be not holding the stock at the end of day(i-1), and do nothing in day(i): a = cash(i-1); or
     *       You might be holding the stock at the end of day(i-1), and sell it at the end of day(i):
     *         b = hold(i-1) + prices[i] - fee;
     *       Choose the greatest one as the value of cash(i) to get the greater potential profit:
     *         cash(i) = max(a, b) = max(cash(i-1), hold(i-1) + prices[i] - fee);
     *   5. Hold(i): the cash in hand, if you are holding the stock at the end of day(i):
     *       You might be holding the stock at the end of day(i-1), and do nothing in day(i): a = hold(i-1); or
     *       You might be not holding the stock at the end of day(i-1), and buy it at the end of day(i): b = cash
     *       (i-1) - prices[i]; or
     *       You might be holding the stock at the end of day(i-1), sell it on day(i), and buy it again at the end of
     *       day(i):
     *         c = (hold(i-1) + prices[i] - fee) - prices[i];
     *       Choose the greatest one as the value of hold(i) to get the greater potential profit:
     *         hold(i) = max(a,b,c)
     *         Because max(b, c) = max(cash(i-1), hold(i-1) + prices[i] - fee) - prices[i] = cash(i) - prices[i],
     *         so hold(i) = max(hold(i-1), cash(i) - prices[i]);
     *   6. There is another way to calculate hold(i), which is more straight forward:
     *       You might be holding the stock at the end of day(i-1), and do nothing in day(i): a = hold(i-1); or
     *       You might be not holding the stock at the end of day(i-1), and buy it at the end of day(i): b = cash
     *       (i-1) - prices[i]; or
     *       You might be holding the stock at the end of day(i-1), sell it on day(i), and buy it again at the end of
     *       day(i):
     *         c = (hold(i-1) + prices[i] - fee) - prices[i] = hold(i-1) - fee;
     *       Obviously, a > c, so max(a, c) = a, hold(i) = max(a, b, c) = max(a, b) = max(hold(i-1), cash(i-1) - 
     *       prices[i])
     *   7. The target is to find the maximum profit at the end of day(N): cash(N);
     */
    
    /*
    class Solution {
    public int maxProfit(int[] prices, int fee) {
        // In day(0), cash(0) (stands for initial profit) is 0, hold(0) is -prices[0]
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // cash(i) = max(cash(i-1), hold(i-1) + prices[i] - fee)
            // cash(i-1) => not holding stock at the end of day(i-1), and do nothing on day(i)
            // hold(i-1) + prices[i] - fee => hold the stock at the end of day(i-1), sell it on day(i)
            // NOTE: so cash(i) >= cash(i-1)
            cash = Math.max(cash, hold + prices[i] - fee);

            // hold(i) = max(hold(i-1), cash(i) - prices[i])
            // hold(i-1) => holding stock at the end of day(i-1), and do nothing on day(i)
            // cash(i) - prices[i] => because cash(i) >= cash(i-1), if selling stock on day(i) results in more cash in hand than cash(i-1), 
            // it makes sense to sell it on day(i) and buy it back instead of selling it on day(i-1) and buy it on day(i).
            // Take the following case as an example:
            // service fee: 1
            // prices: [5, 10, 15, ...]
            // cash[0, 4, 9, ...]
            // hold[-5, -5, ?, ...]
            // Now consider all possible values of hold(2):
            // 1. Do nothing: a = hold(1) = -5
            // 2. Sell on day(1), buy on day(2): b = cash(1) - price(2) = 4 - 15 = -9
            // 3. Sell on day(2), and buy again: c = hold(1) + p(2) - fee - p(2) = -5 + 15 - 1 - 15 = -6
            // c > b, so buying on day(2) results in more profit.
            // However, since a = -5, which is a better choice, finally, hold(2) is resolved to "-5", which is obvious because the price is keeping
            // rising, so the best choice would be buy it on day(0) and hold it.
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}
     */

    /**
     * One more explanation 
     * 
     * For future readers:
     * If I am holding a share after today, then either I am just continuing holding the share I had yesterday, or 
     * that I held no share yesterday, but bought in one share today: hold = max(hold, cash - prices[i])
     * If I am not holding a share after today, then either I did not hold a share yesterday, or that I held a share 
     * yesterday but I decided to sell it out today: cash = max(cash, hold + prices[i] - fee).
     * Make sure fee is only incurred once.
     */

    /**
     * The following concepts may help:
     * cash = profit, should always be positive
     * hold = balance, can be negative or positive.
     * on i-th day,
     *
     * If you do not have a share, your profit is the same as previous day's profit.
     * If you hold a share already, you can always get more money when you sell (the prices[i]). But can you earn 
     * profit? it depends the balance, so profit = balance + prices[i] - fee when you sell a share on i-th day.
     * So on i-th day, max profit = max (profit, balance + prices[i] - fee) (not sell or sell)
     * now, we need to know how to calculate balance.
     * on i-th day
     *
     * If you already have a share, you cannot buy another share, the balance is the same as previous day's balance.
     * If you have no share, so you must have profit (may be 0) and we can use profit to buy a share at cost of 
     * prices[i]. After buying a share, balance = profit - prices[i]
     * So on i-th day, max balance = max(balance, profit - prices[i]. We need maximize balance since we can get more 
     * profit when we sell a share.
     * 
     * Note:
     *
     * On a specific day, you either hold a share or not. When you hold a share, we talk about balance. Since you 
     * haven't sell you share, we cannot talk about profit.
     * When you have no share, you must have profit (cash) since you have sold your share.
     * Why we need calculate profit and balance both each day? Because we don't know the status of each day. To get 
     * max profit, we need take account of both situation for each day.
     * On day one, profit=0 since we have no share to sell. balance = -prices[0] since we need buy a share and we 
     * only talk about balance when we have a share.
     * In the loop, since we calculate profit based on previous balance, so we need calculate today's profit first, 
     * then update the balance of today.
     */


    public int maxProfit(int[] prices, int fee) {
        int cost = 0;
        int hold = cost - prices[0];
        
        for(int i=1; i < prices.length; i++){
            cost = Math.max(cost, hold+prices[i]-fee);
            hold = Math.max(hold,cost-prices[i]);
        }
        
        return cost;
    }
}
