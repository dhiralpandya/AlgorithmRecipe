package com.omtlab.algorithmrecipe.tree.topological;

import com.omtlab.algorithmrecipe.common.graph.Graph;
import com.omtlab.algorithmrecipe.common.graph.Node;

import java.util.*;

/**
 * Given a sorted dictionary of an alien language, find order of characters
 * 
 * 
 * Given a sorted dictionary (array of words) of an alien language, find order of characters in the language.
 * Examples:
 *
 * Input:  words[] = {"baa", "abcd", "abca", "cab", "cad"}
 * Output: Order of characters is 'b', 'd', 'a', 'c'
 * Note that words are sorted and in the given language "baa" 
 * comes before "abcd", therefore 'b' is before 'a' in output.
 * Similarly we can find other orders.
 *
 * Input:  words[] = {"caa", "aaa", "aab"}
 * Output: Order of characters is 'c', 'a', 'b
 * 
 * 
 * Find more details here 
 * https://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
 * 
 * Topological Sorting Video Here
 * https://www.youtube.com/watch?v=ddTC4Zovtbc
 * 
 * 
 */
public class LC269 {
    
    
    public List<Character>  orderOfChar(List<String> sortedWords){
        
        Graph graph = generateGraph(sortedWords);
        
        return runTopologicalSorting(graph);
    }

    /**
     * Topological Sorting Video Here
     * https://www.youtube.com/watch?v=ddTC4Zovtbc
     */
    public List<Character> runTopologicalSorting(Graph graph){
        List<Character> output = new ArrayList<>();
        Stack<Character> outputStack = new Stack<>();
        Set<String> visitedNodes = new HashSet<>(); 
        
       
        for(Node n : graph.getVertices()){//Visit all the parent and its children. 
            runRecursion(outputStack, visitedNodes,n);
        }
        
        while (!outputStack.isEmpty()){
            output.add(outputStack.pop());
        }
        
        return output;
    }

    /**
     * Most IMP method in Topological, Here we are making sure that 
     * we will visit all the children before adding parent in stack
     */
    public void runRecursion(Stack<Character> outputStack, Set<String> visitedNodes, Node node){
        
        if(visitedNodes.contains(node.getVertex())){
            return;
        }
        
        visitedNodes.add(node.getVertex());
        
        for(Node n:node.getAdjacent()){//Visit all the children before adding parent in stack.
            runRecursion(outputStack,visitedNodes,n);
        }
        
        outputStack.push(node.getVertex().charAt(0));//Add parent in output stack
    }
    
    
    public Graph generateGraph(List<String> words) {
        Graph graph = new Graph();


        for (int i = 0; i < words.size() - 1; i++) {
            String wordOne = words.get(i);
            String wordTwo = words.get(i + 1);

            int minLenght = Math.min(wordOne.length(), wordTwo.length());

            int index = 0;
            while (index < minLenght) {

                char c1 = wordOne.charAt(index);
                char c2 = wordTwo.charAt(index);

                if (c1 != c2) {
                    graph.put(String.valueOf(c1), String.valueOf(c2));
                }

                index++;
            }
        }
        
        return graph;
    }
    
}
