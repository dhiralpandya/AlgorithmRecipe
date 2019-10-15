package com.omtlab.algorithmrecipe.stack;

import java.util.*;

/**
 * WORKING FOR ALL INPUT SOLUTION
 */
class Solution1 {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skipSet = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!skipSet.contains(dir)) {
                stack.push(dir);
            }
        }
        String result = "";
        for (String dir : stack) {
            result = "/" + dir + result;
        }
        return result.isEmpty() ? "/" : result;
    }
}

/**
 * Below is a mine solution - NOT WORKING FOR ALL INPUT
 */
public class LC71 {
    
    Set<Character> SPECIAL_CHAR = new HashSet<Character>(){
        {
            add('/');
            add('.');
        }
    }; 

    public String simplifyPath(String path) {

        Stack<Character> stack = new Stack<>();
        
        
        for(Character c:path.toCharArray()){
            if(SPECIAL_CHAR.contains(c)){
                if(c == '.' && isPreviousDot(stack)){
                    removePreviousDirectory(stack);
                } else if(c == '/' && isPreviousSlash(stack)){
                    continue;
                } else if(c == '/' && isPreviousDot(stack)){
                    removeCurrentDirectoryDots(stack);
                    stack.push('/'); //IMP Step
                } else {
                    stack.push(c);
                }
            } else{
                stack.push(c);
            }
        }
        
        removeLastSlashOrDot(stack); //IMP Step
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        return sb.length() == 0? "/":sb.reverse().toString();
    }
    
    
    
    
    public void removeCurrentDirectoryDots(Stack<Character> stack){
            stack.pop();
            stack.pop();
    }
    
    public void removePreviousDirectory(Stack<Character> stack){
        removeCurrentDirectoryDots(stack);
        if(stack.size() > 1){
            stack.pop();
            stack.pop();
        }
    }
    
    public boolean isPreviousDot(Stack<Character> stack){
        return stack.size() > 0 && stack.peek() =='.';
    }

    public boolean isPreviousSlash(Stack<Character> stack){
        return stack.size() > 0 && stack.peek() == '/';
    }
    
    public void removeLastSlashOrDot(Stack<Character> stack){
        if(stack.size() > 1){
            if(stack.peek() == '/' || stack.peek() == '.') {
                stack.pop();   
            }
        }
    }
    
}
