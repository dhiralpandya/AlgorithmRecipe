package com.omtlab.algorithmrecipe.trie;

import com.omtlab.algorithmrecipe.common.node.TrieNode;

import java.util.Set;
import java.util.TreeSet;

/**
 * 211. Add and Search Word - Data structure design
 * 
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means 
 * it can represent any one letter.
 *
 * Example:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */
public class LC211 {
    TrieNode root = new TrieNode();
    Set<Character> skipChars = new TreeSet<Character>(){
        {
            add('.');
        }
    };
    
    public void addWord(String word){
        
    }
    
    public boolean search(String word){
        
    }
    
}
