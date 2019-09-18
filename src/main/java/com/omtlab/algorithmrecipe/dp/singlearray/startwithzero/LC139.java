package com.omtlab.algorithmrecipe.dp.singlearray.startwithzero;

import java.util.List;

/**
 * https://www.youtube.com/watch?v=RPeTFTKwjps&t=829s
 * https://github.com/dhiralpandya/Leetcode/blob/master/src/main/java/com/fishercoder/solutions/_139.java
 * 139. Word Break
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be 
 * segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
public class LC139 {


    /**
     * Bottom up approach 
     * let input is 
     * 
     * omtlab , [omt, lab]
     * 
     * We are solving this using DP so we will consider first step as empty strign then string with lenght 1 and 2 and so on
     * 
     * For empty string we will take True
     * 
     * Lets take array of n+1, n is length of input string
     * Length       0|1|2|3|4|5|6
     *              -------------
     *              0|o|m|t|l|a|b
     *              -------------
     * Current Val  T|F|F|F|F|F|F            
     * Char Index   -------------
     *              -|0|1|2|3|4|5
     *              
     *  
     *  For empty string we have True
     *  
     *  Lets start with length 1 
     *  which is 'o' and we will mark it as F
     *  
     *  Now lets start with length 2
     *  At length 2 we will identify both below possibilities
     *  'om'
     *  'o' and 'm'
     *  
     *  For Length 3
     *  
     *  At length 3 we will identify all below possibilities
     *  
     *  'om' and 't' : IMP Note > We dont need to consider this if 'om' is false then no need to identify for 't'
     *  'o' and 'mt'  : IMP Note > We dont need to consider this if 'o' is false then no need to identify for 'mt'
     *  'omt' = T : Here empty '' string is true so we will check for 'omt'
     *  
     *  Now our array will look like this
     *  
     *      * Length       0|1|2|3|4|5|6
     *      *              -------------
     *      *              0|o|m|t|l|a|b
     *      *              -------------
     *      * Current Val  T|F|F|T|F|F|F            
     *      * Char Index   -------------
     *      *              -|0|1|2|3|4|5
     * 
     * NOTE : CHECK SIMPLE WAY METHOD :  wordBreakMyStyle
     * 
     */
    public boolean wordBreak(String input, List<String> words){
        
        //Identify word with MaxLength so our length should not go above that.
        int maxLenght = -1;
        
        for(String word :words){
            maxLenght = Math.max(word.length(),maxLenght);
        }
        
        boolean cache[] = new boolean[input.length()+1];
        cache[0] = true;//for zero length
        for(int length = 1; length <= input.length();length++){
            for(int rightToLeft=1; rightToLeft <= length && rightToLeft<=maxLenght; rightToLeft++){
                int currentCacheIndex = length;
                int previousCacheIndex = length-rightToLeft;
                if(cache[previousCacheIndex]){
                    int subStringStart = previousCacheIndex;
                    int subStringEnd =  length;
                    String wordToCheck = input.substring(subStringStart,subStringEnd);
                    if(words.contains(wordToCheck)){
                        cache[currentCacheIndex]=true;
                        break;
                    }
                }
            }
        }
        
        return cache[input.length()];
    }


    /**
     * Same above algorithm but much much simple way
     * @param input
     * @param words
     * @return
     */
    public boolean wordBreakMyStyle(String input, List<String> words){
        
        boolean cache[] = new boolean[input.length()+1];
        cache[0] = true;//for zero length
        for(int length = 1; length <= input.length();length++){
            for(int j=length; j >= 0 ;j--){
                if(cache[j]){
                    String wordToCheck = input.substring(j,length);
                    if(words.contains(wordToCheck)){
                        cache[length]=true;
                        break;
                    }
                }
            }
        }

        return cache[input.length()];
    }
    

}
