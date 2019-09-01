package com.omtlab.algorithmrecipe.stack;

import org.checkerframework.checker.units.qual.C;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is 
 * valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */
public class LC20 {
    
    private static final Map<Character,Character> CACHE = new HashMap<Character, Character>(){
        {
            put('{','}');
            put('[',']');
            put('(',')');
        }  
    };
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(CACHE.containsKey(c)){
                stack.push(c);
            } else {
                if(stack.empty() || CACHE.get(stack.pop()) != c){
                    return false;
                }
            }
        }
        
        return stack.empty();
    }
}
