package com.omtlab.algorithmrecipe.tree.bfs;

import com.google.common.collect.Lists;
import com.omtlab.algorithmrecipe.common.util.Pair;

import java.util.*;

/**
 * 127. Word Ladder
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation 
 * sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformat
 */
public class LC127 {

    /**
     * READ LC127.pdf for more details about the solution
     */

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String,List<String>> allCombinationWordMap = new HashMap<>();
        
        for(String word:wordList){
            for(String pattern : getAllCombinations(word)){
                if(allCombinationWordMap.containsKey(pattern)){
                    allCombinationWordMap.get(pattern).add(word);
                } else {
                    allCombinationWordMap.put(pattern, Lists.newArrayList(word));
                }
            }
        }


        Set<String> visited = new TreeSet<>();
        Queue<Pair<String,Integer>> queue = new LinkedList<>();
        
        queue.add(new Pair<>(beginWord,1));
        
        while (!queue.isEmpty()){
            Pair<String, Integer> wordWithLevel = queue.poll();
            int level = wordWithLevel.getValue();
            String word = wordWithLevel.getKey();
            visited.add(word);
            
            for(String pattern : getAllCombinations(word)){
                
                if(allCombinationWordMap.get(pattern) == null){
                    continue;
                }
                
                for(String w:allCombinationWordMap.get(pattern)){
                    if(w.equals(endWord)){
                        return level+1;
                    } else if(!visited.contains(w)){
                        queue.add(new Pair<>(w,level+1));
                    }
                }
            }
        }
        
        return 0;
    }

    /**
     * For eg. While doing BFS if we have to find the adjacent nodes for 
     * Dug we can first find all the generic states
     * for Dug.
     *
     * Dug => *ug
     * Dug => D*g
     * Dug => Du*
     */
    public List<String> getAllCombinations(String word){
        List<String> list = new ArrayList<>();
        int size = word.length();
        
        for(int i=0; i <size; i++){
            String pattern = word.substring(0,i)+"*"+word.substring(i+1,size);
            list.add(pattern);
        }
        
        return list;
    }
    
}
