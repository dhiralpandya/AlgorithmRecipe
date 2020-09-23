package com.omtlab.algorithmrecipe.binarysearch;

/**
 * 69. Sqrt(x)
 * 
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is 
 * returned.
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since 
 *              the decimal part is truncated, 2 is returned.
 */
public class LC69 {

    public double mySqrt(double x) {
        double ans = 0;
        double round = 1000000000000.0d;
        double start = 0;
        double end = x;

        while (start < end){
            double mid = (start+end)/2;
            double midXmid = mid*mid;
            if(midXmid == x){
                // Math.round() which returns the closest long to the argument
                // Math.round(4567.9874f) = 4568
                return Math.round(mid*round)/round;
            } else if(midXmid < x){
                //IMP Step
                ans = Math.round(mid*round)/round;
                start = mid+0.00000000000001;
            } else {
                end = mid -0.00000000000001;
            }
        }
        
        
        
        
        return ans;
    }
}
