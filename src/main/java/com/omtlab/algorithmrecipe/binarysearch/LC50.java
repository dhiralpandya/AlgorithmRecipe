package com.omtlab.algorithmrecipe.binarysearch;

/**
 * 50. Pow(x, n)
 * 
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Example 1:
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Note:
 *
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */
public class LC50 {

    public double myPow(double x, int n) {

        //Some edge cases
        if(n == 0){
            return 1.0;
        }
        
        boolean wasNegativeValue = n < 0;
        n = Math.abs(n);
        
        double ans = x;//initial value
        double oddNumberCalculation = 1;
        
        for(int i=n; i>1; i/=2){
            
            boolean isOddNumber = (i&1) == 1;
            if(isOddNumber){
                /**
                 * Lets say for n = 10 and x = 2  expected ans = 1024
                 * When we do n/2 here 10/2 = 5 and 5/2 which is 2.5 
                 * but here we'll consider only 2 instead of 2.5 
                 * it means we are missing 0.5 somewhere 
                 * We have to consider it in calculation, Thats the reason we are keep tracking it here.
                 */
                oddNumberCalculation*=ans;//This is require for input like 2,10 where 10/2 = 5
            }
            
            ans*=ans;
        }
        
        
        ans*=oddNumberCalculation;
        
        if(wasNegativeValue){
            ans=1/ans;
        }
        
        return ans;
    }
    
}
