package com.omtlab.algorithmrecipe.trie;

import com.google.common.collect.Lists;
import com.omtlab.algorithmrecipe.common.node.TreeNode;
import com.omtlab.algorithmrecipe.common.node.TrieNode;

import java.util.*;

/**
 * 642. Design Search Autocomplete System
 *
 * Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with a special character '#'). For each character they type except '#', you need to return the top 3 historical hot sentences that have prefix the same as the part of sentence already typed. Here are the specific rules:
 The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
 The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences have the same degree of hot, you need to use ASCII-code order (smaller one appears first).
 If less than 3 hot sentences exist, then just return as many as you can.
 When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.
 Your job is to implement the following functions:
 The constructor function:
 AutocompleteSystem(String[] sentences, int[] times): This is the constructor. The input is historical data. Sentences is a string array consists of previously typed sentences. Times is the corresponding times a sentence has been typed. Your system should record these historical data.
 Now, the user wants to input a new sentence. The following function will provide the next character the user types:
 List<String> input(char c): The input c is the next character typed by the user. The character will only be lower-case letters ('a' to 'z'), blank space (' ') or a special character ('#'). Also, the previously typed sentence should be recorded in your system. The output will be the top 3 historical hot sentences that have prefix the same as the part of sentence already typed.
 Example:
 Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2])
 The system have already tracked down the following sentences and their corresponding times:
 "i love you" : 5 times
 "island" : 3 times
 "ironman" : 2 times
 "i love leetcode" : 2 times
 Now, the user begins another search:
 Operation: input('i')
 Output: ["i love you", "island","i love leetcode"]
 Explanation:
 There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
 Operation: input(' ')
 Output: ["i love you","i love leetcode"]
 Explanation:
 There are only two sentences that have prefix "i ".
 Operation: input('a')
 Output: []
 Explanation:
 There are no sentences that have prefix "i a".
 Operation: input('#')
 Output: []
 Explanation:
 The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.
 Note:
 The input sentence will always start with a letter and end with '#', and only one blank space will exist between two words.
 The number of complete sentences that to be searched won't exceed 100. The length of each sentence including those in the historical data won't exceed 100.
 Please use double-quote instead of single-quote when you write test cases even for a character input.
 Please remember to RESET your class variables declared in class AutocompleteSystem, as static/class variables are persisted across multiple test cases. Please see here for more details.
 */
public class LC642 {

    /**
     * For more detail about autocomplete approach that we took here
     * https://www.youtube.com/watch?v=xrYTjaK5QVM
     */
    
    TrieNodeWithAutoComplete root = new TrieNodeWithAutoComplete();
    TrieNodeWithAutoComplete lastSearchedNode = root;
    
    public LC642(String[] sentences, int[] times) {
        int i = 0;
        for(String s:sentences){
            addWord(new Word(s,times[i++]));
        }
    }


    
    public List<String> keyPressed(Character c){
        return autoComplete(c);
    }

    //ADD WORD IN TRIE 
    
    public void addWord(Word word){
        root.autoComplete.add(word);
        addWordRe(word,0,root);
    }


    public void addWordRe(Word word, int index, TrieNodeWithAutoComplete nextNode){
        if(index == word.length()){
            nextNode.isWord = true;
            return;
        }
        
        Character c = word.charAt(index);
        TrieNodeWithAutoComplete nextNextNode = null;
        if(nextNode.childrens.containsKey(c)){
            nextNextNode = nextNode.childrens.get(c);
        } else {
            nextNextNode = new TrieNodeWithAutoComplete();
            nextNode.childrens.put(c,nextNextNode);
        }
        nextNextNode.autoComplete.add(word);
        addWordRe(word,index+1,nextNextNode);
        
    }
    
    
    
    //SEARCH WORD IN TRIE
    public List<String> autoComplete(Character c){
        if(lastSearchedNode == null){
            return Lists.newArrayList();
        }
        
        if(lastSearchedNode.childrens.containsKey(c)){
            lastSearchedNode = lastSearchedNode.childrens.get(c);
            int totalSuggestions = 3;
            Iterator<Word> iterator = lastSearchedNode.autoComplete.iterator();
            List<String> suggessions = new ArrayList<>();
            
            while (totalSuggestions > 0 && iterator.hasNext()){
                suggessions.add(iterator.next().string);
                totalSuggestions--;
            }
            return suggessions;
        } else {
            lastSearchedNode = null;
            return Lists.newArrayList();
        }
    }
    
    
    
    
    
    
    
    //ALL CLASSES USED IN THIS ALGORITHM

    public static class TrieNodeWithAutoComplete {
        public Map<Character,TrieNodeWithAutoComplete> childrens  = new TreeMap<>();
        public boolean isWord;
        public Set<Word> autoComplete = new TreeSet<>(); 
    }
    
    public static class Word implements Comparable<Word>{
        String string;
        int times;
        
        Word(String s, int times){
            this.string = s ;
            this.times = times;
        }
        
        
        public int length(){
            return this.string.length();
        }
        
        public Character charAt(int i){
            return this.string.charAt(i);
        }
        

        @Override
        public int compareTo(Word o) {
            int timeDiff =  o.times-this.times; //This is IMP Step: Bigger first not smaller
            
            if(timeDiff != 0 ){
                return timeDiff;
            }
            
            int minLenght = Math.min(this.string.length(),o.string.length());
            for(int i =0; i < minLenght; i++){
                if(this.string.charAt(i) !=  o.string.charAt(i)){
                    return this.string.charAt(i) - o.string.charAt(i); // Here smaller ASCII first not bigger  
                }
            }
            
            return this.string.length() - o.string.length();
        }

//        @Override
//        public int compare(Word o1, Word o2) {
//            int timeDiff = o1.times - o2.times;
//
//            if(timeDiff != 0 ){
//                return timeDiff;
//            }
//
//            int minLenght = Math.min(o1.string.length(),o2.string.length());
//            for(int i =0; i < minLenght; i++){
//                if(o1.string.charAt(i) !=  o2.string.charAt(i)){
//                    return o1.string.charAt(i) - o2.string.charAt(i);
//                }
//            }
//
//            return o1.string.length() - o2.string.length();
//        }
    }
}
