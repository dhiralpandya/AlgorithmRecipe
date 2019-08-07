package com.omtlab.algorithmrecipe.dp.singlearray;

/**
 * 43. Multiply Strings
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also 
 * represented as a string.
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * Note:
 *
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class LC43 {

    /**
     * https://github.com/dhiralpandya/Leetcode/blob/master/src/main/java/com/fishercoder/solutions/_43.java
     */
    public String multiplyStrings(String s1, String s2){
        // s1 * s2
        
        int i = s2.length();
        int j = s1.length();
        int[] cache = new int[i+j];
        
        for(int bottom = 0; bottom<i;bottom++){
            for(int top = j-1; top>=0; top--){
                
                int rightMostForCurrentBottom = bottom+top+1;
                int positionForCarry = rightMostForCurrentBottom-1;
                int multiplication = Character.getNumericValue(s2.charAt(bottom))*Character.getNumericValue(s1.charAt(top));
                
                cache[rightMostForCurrentBottom] +=multiplication%10;
                
                if(cache[rightMostForCurrentBottom] >=10){
                    int temp = cache[rightMostForCurrentBottom];
                    cache[rightMostForCurrentBottom]%=10;
                    cache[positionForCarry]+=temp/10;
                }
                cache[positionForCarry]+=multiplication/10;
                
                if(cache[positionForCarry] >=10){
                    int temp = cache[positionForCarry];
                    cache[positionForCarry]%=10;
                    cache[positionForCarry-1]+=temp/10;
                }
            }
        }
        
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        int sumOfAllData = 0;
        for(int data:cache){
            if(!(index == 0 && data ==0)){
                stringBuilder.append(data);
                sumOfAllData+=data;
            }
            index++;
        }
        return sumOfAllData ==0?"0": stringBuilder.toString();
    }
    
}

