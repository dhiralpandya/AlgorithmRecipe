package com.omtlab.algorithmrecipe.binarysearch;

/**
 * 875. Koko Eating Bananas
 * 
 * 
 * Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i] bananas.  The guards have 
 * gone and will come back in H hours.
 *
 * Koko can decide her bananas-per-hour eating speed of K.  Each hour, she chooses some pile of bananas, and eats K 
 * bananas from that pile.  If the pile has less than K bananas, she eats all of them instead, and won't eat any more
 * bananas during this hour.
 *
 * Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.
 *
 * Return the minimum integer K such that she can eat all the bananas within H hours.
 *
 *
 *
 * Example 1:
 *
 * Input: piles = [3,6,7,11], H = 8
 * Output: 4
 * Example 2:
 *
 * Input: piles = [30,11,23,4,20], H = 5
 * Output: 30
 * Example 3:
 *
 * Input: piles = [30,11,23,4,20], H = 6
 * Output: 23
 *
 *
 * Note:
 *
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 * 
 */
public class LC875 {


    public int minEatingSpeed(int[] piles, int H) {
        int output = 0;
        
        int start = 1;
        int end = getSum(piles);
        
        while(start <= end){
            int mid = (start+end)/2;
            int totalHr = getTotalHrTakesForCurrentMid(mid,piles,H);
            if(totalHr > H){ //Here H is too small, Eating speed is too low.
                start = mid+1;
            } else { // H is bigger, Easting speed too fast.
                end = mid-1;
                output=mid;
            }
        }
        
        
        return output;
        
    }
    
    
    public int getTotalHrTakesForCurrentMid(int mid, int[] piles, int H){
        int totalHr = 0;
        
        for(int pile:piles) {
            totalHr+= (pile/mid);
            if(pile%mid != 0) {
                totalHr++;
            }
        }
        
        return totalHr;
    }
    
    
    public int getSum(int[] piles){
        int sum = 0;
        
        for(int p : piles){
            sum+=p;        
        }
            
        return sum;
    }
    
}
