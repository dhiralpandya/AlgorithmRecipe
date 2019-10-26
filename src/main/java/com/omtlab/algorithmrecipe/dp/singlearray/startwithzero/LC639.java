package com.omtlab.algorithmrecipe.dp.singlearray.startwithzero;

/**
 * 
 * 
 * 639. Decode Ways II
 *  
 * A message containing letters from A-Z is being encoded to numbers using the following mapping way:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers
 * from 1 to 9.
 *
 * Given the encoded message containing digits and the character '*', return the total number of ways to decode it.
 *
 * Also, since the answer may be very large, you should return the output mod 109 + 7.
 *
 * Example 1:
 * Input: "*"
 * Output: 9
 * Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
 * Example 2:
 * Input: "1*"
 * Output: 9 + 9 = 18
 * Note:
 * The length of the input string will fit in range [1, 105].
 * The input string will only contain the character '*' and digits '0' - '9'.
 */
public class LC639 {

    /**
     * This is the really good algorithm to solve, 
     * Here before solving it you have to pay attention on problem definition
     * 
     * Lets say input string is 12, All possible output would be 'AB','L' only two.
     * 
     * Now lets say input is 123, All possible output would be as per below. 
     * 
     * 1-2-3 = ABC 
     * 12-3 = LC
     * 1-23 = AW
     * 
     * Three output total 
     * 
     * Lets say input is 102
     * 1-0-2 = Invalid combination 
     * 10-2 = JB
     * 1-02 = Invalid combination. 
     *
     * Only one output total 
     * 
     * So how are we using DP to store and use count. 
     * 
     * Lets say we have 123 input
     * 
     * Initial Stage
     * Input 0 1 2 3
     *       - - - -
     * DP    1 0 0 0
     * 
     * Initially we start with 0 and assign dp value for it as 1
     * 
     * Now focus on 1, Lets say we only have 1 as input, so output would be 1 only
     * 
     *  Input 0 1 2 3
     *        - - - -
     *  DP    1 1 0 0
     * 
     * 
     * Now focus on next int which is 2, 2 is > 0, 
     * It means it is valid char and it helps in contribution of previous count
     * 
     * Example : 12 = 1-2 = AB here 2 helped making 1-2 = AB 
     * Lets say instead of 2 we have 0, It would be 10 = 1-0 = Invalid not helped here
     * 
     * Above example proves that 2 is helping moving previous count further. 
     * 
     * So our DP will look like this
     * 
     * Input 0 1 2 3
     *       - - - -
     * DP    1 1 1 0
     * 
     * Now since using 2 we have added previous count, Let check two chars 1 and 2 together 
     * 
     * 12 = L it is also helping making one more count, so take value from previous previous count which is 1. 
     *
     * Input 0 1 2 3
     *       - - - -
     * DP    1 1 2 0
     *  
     * Same way we do it for 3 also, 3 is 3 > 0, 
     * it means it is also helping previous count to move to next position 
     * and 23 is also creating 'W' so take previous previous count as well 
     * 
     *Input 0 1 2 3
     *      - - - -
     *DP    1 1 2 3=(2+1)
     * 
     * 
     * Final answer is 3
     * 
     * 
     * 
     * Lets say here in case of * we should take 1-9
     * 
     * 1* means : 11, 12, 13 ... 19
     * Here 11 has 'AA' and 'K' so two output. 
     * So from 11 to 19 each will have two output = 9*2 = 18
     * 
     * Lets prove this 18 output with example 
     * 
     * Lets focus on first output from 11 to 19 
     * 
     * 11 : 
     * 
     * Input 0 1 1
     *       - - -
     * DP    1 1 2
     * 
     * Here in case of 1 at last position we have *
     * 1* = we will just do 2*9 in last position 
     * 
     * Input 0 1 *
     *       - - -
     * DP    1 1 2*9 = 18
     * 
     * 
     * Now lets say we have * at start position 
     * 
     * *1 means 11, 21, 31 ... 91
     * 
     * So here from 31 to 91 is only 1 possible answer each it means
     * 31,41,51,61,71,81,91 total 7 output
     * 
     * and 11 and 21 each can produce 2 output means total 4 outputs
     * 
     * Ans is 7+4 = 11
     * 
     * Lets take one more example 
     * 
     * *7 means 17,27,37 ... 97
     * 
     * So here 17 would be 1-7[AG] and 17[Q] so total 2 outputs
     * and from 27[BG] to 97[IG] is one each so total 8 output.
     * 
     * So Total would be 2+8 = 10
     * 
     * 
     * 
     * Lets take one more last example 
     * 
     * '**' means [1* to 2* and 3* to 9*] and *1 to *9
     * 
     * 1* as we calculated above it is 18
     * 
     * here 2* is from 21 to 26 each 2 means 12 total 
     * from 27 to 29 only 1 each means 3 total so total 12+3 = 15
     * 
     * 3* is 31 to 39 means total 9 
     * same 4* to 9* each has 9 in total 
     * so from 3* to 9* total is 7*9 = 63
     * 
     * and remaining *1 and *9 is already counted in first place at 1* 
     * 
     * 
     * 1* = 18
     * 2* = 15
     * 3* to 9* = 63
     * 
     * [18+15+63] = 96 Total
     * 
     * 
     * 
     */
    public int numDecodings(String s) {

        int[] dp = new int[s.length()+1];
        
        dp[0] = 1;
        dp[1] = s.charAt(0) =='*' ? 9:
                s.charAt(0) == '0' ? 0 : 1;
        
        
        for(int i=1;i<s.length();i++) {
            int nextDPPosition = i + 1;
            int preDPPosition = i;
            int prePreDPPosition = i - 1;

            char c = s.charAt(i);
            char preC = s.charAt(i - 1);

            if (c == '*') {
                int count = dp[preDPPosition] * 9;//This to move previous count further. 
                //Now we will check for previous previous count for two digits combination. 
                if (preC == '1') {
                    count += dp[prePreDPPosition] * 9;
                } else if (preC == '2') {
                    count += dp[prePreDPPosition] * 6;
                } else if (preC == '*') {
                    count += dp[prePreDPPosition] * (9 + 6);//1*[9] and 2*[6] 
                }
                dp[nextDPPosition] = count;

            } else {
                int count = c == '0' ? 0 : dp[preDPPosition];//This to move previous count further is current char is not zero.

                //Now we will check for previous previous count for two digits combination.
                if (preC == '1' || (preC == '2' && c < '7')) {
                    count += dp[prePreDPPosition];
                } else if (preC == '*') {
                    //Here pre is * and if current is less than 7 means 
                    // lets say 1 so *1 = 2 outputs for each one. 
                    //but if current is greater than 6 then 
                    // Lets say 7 so *7 would be 1 output each.
                    int multiply = c < '7' ? 2 : 1;
                    count += (dp[prePreDPPosition] * multiply);
                }
                
                dp[nextDPPosition] = count;

            }
        }   
        return dp[dp.length-1];
    }
    
}
