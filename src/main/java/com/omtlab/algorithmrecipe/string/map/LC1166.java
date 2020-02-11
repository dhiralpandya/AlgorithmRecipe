package com.omtlab.algorithmrecipe.string.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 1166. Design File System
 * 
 * You are asked to design a file system which provides two functions:
 *
 * createPath(path, value): Creates a new path and associates a value to it if possible and returns True. Returns 
 * False if the path already exists or its parent path doesn't exist.
 * get(path): Returns the value associated with a path or returns -1 if the path doesn't exist.
 * The format of a path is one or more concatenated strings of the form: / followed by one or more lowercase English 
 * letters. For example, /leetcode and /leetcode/problems are valid paths while an empty string and / are not.
 *
 * Implement the two functions.
 *
 * Please refer to the examples for clarifications.
 * 
 * Example 1:
 *
 * Input: 
 * ["FileSystem","createPath","get"]
 * [[],["/a",1],["/a"]]
 * Output: 
 * [null,true,1]
 * Explanation: 
 * FileSystem fileSystem = new FileSystem();
 *
 * fileSystem.createPath("/a", 1); // return true
 * fileSystem.get("/a"); // return 1
 * Example 2:
 *
 * Input: 
 * ["FileSystem","createPath","createPath","get","createPath","get"]
 * [[],["/leet",1],["/leet/code",2],["/leet/code"],["/c/d",1],["/c"]]
 * Output: 
 * [null,true,true,2,false,-1]
 * Explanation: 
 * FileSystem fileSystem = new FileSystem();
 *
 * fileSystem.createPath("/leet", 1); // return true
 * fileSystem.createPath("/leet/code", 2); // return true
 * fileSystem.get("/leet/code"); // return 2
 * fileSystem.createPath("/c/d", 1); // return false because the parent path "/c" doesn't exist.
 * fileSystem.get("/c"); // return -1 because this path doesn't exist.
 *
 *
 * Constraints:
 *
 * The number of calls to the two functions is less than or equal to 10^4 in total.
 * 2 <= path.length <= 100
 * 1 <= value <= 10^9
 * NOTE: create method has been changed on August 29, 2019 to createPath. Please reset to default code definition to 
 * get new method signature.
 */
public class LC1166 {

    /**
     * We can implement this using trie as well. 
     * 
     * What is edge case here ?
     *  - When we get the request for creating path for more than one level 
     *  at that time we have to validate each directory if its present or not. 
     */
    static class FileSystem {
        
        private Map<String,Integer> pathToValueMap = new HashMap<>(); 

        public FileSystem() {
            //Edge case 
            pathToValueMap.put("",-1);
        }

        public boolean createPath(String path, int value) {
           
            if(!pathToValueMap.containsKey(path)) {
                int lastIndex = path.lastIndexOf("/");
                String parentPath = path.substring(0,lastIndex);
                if(pathToValueMap.containsKey(parentPath)) {
                    pathToValueMap.put(path, value);
                    return true;
                }
            }
            
            return false;
        }

        public int get(String path) {
           return pathToValueMap.getOrDefault(path, -1);
        }
    }
    
    
}
