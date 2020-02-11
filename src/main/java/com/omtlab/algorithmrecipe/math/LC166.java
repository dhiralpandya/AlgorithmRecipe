package com.omtlab.algorithmrecipe.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 166. Fraction to Recurring Decimal
 * 
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * Example 1:
 *
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * Example 2:
 *
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * Example 3:
 *
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 */
public class LC166 {

    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) {
            return "0";
        }
        
        if(denominator == 0) {
            throw new  IllegalArgumentException();
        }
        
        StringBuilder output = new StringBuilder();
        
        //One of them not both.
        if(numerator < 0 ^ denominator < 0) {
            
        }
        
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));

        // Result will be in long not double. Ex: 1/2 = 0 not 0.5 here
        output.append(String.valueOf(dividend/divisor)); 
        long remainder = dividend%divisor;
        if(remainder == 0) {
            return output.toString();
        }
        
        output.append(".");
        Map<Long,Integer> remainderToPositionMap = new HashMap<>();
        while (remainder!=0) {
            if(remainderToPositionMap.containsKey(remainder)) { // Same reminder will give same answer.
                output.insert(remainderToPositionMap.get(remainder), "(");
                output.append(")");
                return output.toString(); //Return the result.
            }
            remainderToPositionMap.put(remainder, output.length());
            remainder*=10;
            output.append(String.valueOf(remainder/divisor)); // Answer with this remainder
            remainder = remainder%divisor;
        }
        
        return output.toString();
    }
}
