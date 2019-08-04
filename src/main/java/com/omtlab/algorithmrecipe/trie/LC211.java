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
        addWordInTrie(word,0,root);
    }
    
    public void addWordInTrie(String word, int index, TrieNode trieNode){
        if(word.length() == index){
            trieNode.isWord =true;
            return;
        }
        
        TrieNode nextNode = null;
        if(trieNode.childrens.containsKey(word.charAt(index))){
            nextNode = trieNode.childrens.get(word.charAt(index));
        } else {
            nextNode = new TrieNode();
            trieNode.childrens.put(word.charAt(index),nextNode);
        }
        
        addWordInTrie(word,index+1,nextNode);
        
    }
    
    public boolean search(String word){
        return searchWordInTrie(word,0,root);
    }
    
    
    public boolean searchWordInTrie(String word, int index, TrieNode trieNode){
        if(word.length() == index){
            return trieNode.isWord;
        }
        
        
        Character currentChar = word.charAt(index);
        if(skipChars.contains(currentChar)){//Skip char, Move to next one
            if(trieNode.childrens.size() > 0){
                for(TrieNode node:trieNode.childrens.values()){
                    if(searchWordInTrie(word,index+1,node)){
                       return true;
                    }
                }
            }
        } else if(trieNode.childrens.containsKey(currentChar)) {
           return searchWordInTrie(word,index+1,trieNode.childrens.get(currentChar));
        } else {
           return false; 
        }
        
        return false;
    }
    
}
