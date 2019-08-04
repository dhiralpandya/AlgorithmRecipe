package com.omtlab.algorithmrecipe.common.node;

import java.util.Map;
import java.util.TreeMap;

public class TrieNode {
    
    public Map<Character,TrieNode> childrens  = new TreeMap<>();
    public boolean isWord;
}
