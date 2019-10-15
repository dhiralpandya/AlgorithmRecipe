package com.omtlab.algorithmrecipe.stack;

import java.util.*;

/**
 * 71. Simplify Path
    Given an absolute path for a file (Unix-style), simplify it.
    For example,
        path = "/home/", => "/home"
        path = "/a/./b/../../c/", => "/c"
 Corner Cases:
    Did you consider the case where path = "/../"?
    In this case, you should return "/".
    Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
    In this case, you should ignore redundant slashes and return "/home/foo".

 Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.

 In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix

 Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.



 Example 1:

 Input: "/home/"
 Output: "/home"
 Explanation: Note that there is no trailing slash after the last directory name.
 Example 2:

 Input: "/../"
 Output: "/"
 Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 Example 3:

 Input: "/home//foo/"
 Output: "/home/foo"
 Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 Example 4:

 Input: "/a/./b/../../c/"
 Output: "/c"
 Example 5:

 Input: "/a/../../b/../c//.//"
 Output: "/c"
 Example 6:

 Input: "/a//b////c/d//././/.."
 Output: "/a/b/c"
 */

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
