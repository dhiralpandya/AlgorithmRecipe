package com.omtlab.algorithmrecipe.dp.matrix;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Word Wrap Problem | DP-19
 * Given a sequence of words, and a limit on the number of characters that can be put in one line (line width). Put 
 * line breaks in the given sequence such that the lines are printed neatly. Assume that the length of each word is 
 * smaller than the line width.
 *
 * The word processors like MS Word do task of placing line breaks. The idea is to have balanced lines. In other 
 * words, not have few lines with lots of extra spaces and some lines with small amount of extra spaces.
 *
 * The extra spaces includes spaces put at the end of every line except the last one.  
 * The problem is to minimize the following total cost.
 *  Cost of a line = (Number of extra spaces in the line)^3
 *  Total Cost = Sum of costs for all lines
 *
 * For example, consider the following string and line width M = 15
 *  "Geeks for Geeks presents word wrap problem" 
 *
 * Following is the optimized arrangement of words in 3 lines
 * Geeks for Geeks
 * presents word
 * wrap problem 
 *
 * The total extra spaces in line 1, line 2 and line 3 are 0, 2 and 3 respectively. 
 * So optimal value of total cost is 0 + 2*2 + 3*3 = 13
 * Please note that the total cost function is not sum of extra spaces, but sum of cubes (or square is also used) of 
 * extra spaces. The idea behind this cost function is to balance the spaces among lines. For example, consider the 
 * following two arrangement of same set of words:
 *
 *
 *
 *
 *
 * 1) There are 3 lines. One line has 3 extra spaces and all other lines have 0 extra spaces. Total extra spaces = 3 
 * + 0 + 0 = 3. Total cost = 3*3*3 + 0*0*0 + 0*0*0 = 27.
 *
 * 2) There are 3 lines. Each of the 3 lines has one extra space. Total extra spaces = 1 + 1 + 1 = 3. Total cost = 
 * 1*1*1 + 1*1*1 + 1*1*1 = 3.
 *
 * Total extra spaces are 3 in both scenarios, but second arrangement should be preferred because extra spaces are 
 * balanced in all three lines. The cost function with cubic sum serves the purpose because the value of total cost 
 * in second scenario is less.
 * 
 * CHECK THIS VIDEO : https://www.youtube.com/watch?v=RORuwHiblPc&t=631s
 */
public class GFGWordWrapProblem {

    /**
     *   Find details here : documentation/GFGWordWarp.png
     */

    public List<String> fullJustify(String[] words, int maxWidth) {

        int[][] costMatrix = costMatrix(words,maxWidth);

       // MatrixUtil.printMatrix(costMatrix);
        
        int[] breakingCost = new int[words.length];
        int[] breakPoints = new int[words.length];
        
        breakingCost[words.length-1] = costMatrix[words.length-1][words.length-1];
        breakPoints[words.length-1]=words.length;
        
        int j = words.length-1;
        int i = words.length-2;
        while (i >= 0){
            
            breakingCost[i] = costMatrix[i][j]; //We will store i to j value initially here 
            breakPoints[i] = words.length;
            
            while (j > i){
                if(costMatrix[i][j-1] == Integer.MAX_VALUE){
                    j--;
                    continue;
                }
                
                int totalCost = costMatrix[i][j-1]+breakingCost[j];//MOST IMP LINE, Here we are taking i to j-1 from cost martrix and j is from previously calculated breckingCost
                
                if(totalCost < breakingCost[i]){
                    breakingCost[i] = totalCost;
                    breakPoints[i] = j == words.length-1 ? words.length:j;
                }
                j--;//Please dont forget to reduce
            }
            
            i--;
            j=words.length-1;//Rest J pointer back to last
        }

       // System.out.println(Arrays.toString(breakingCost));
        //System.out.println(Arrays.toString(breakPoints));
        
        List<String> output = Lists.newArrayList();
        
        for(int from = 0; from < words.length; from++){
            StringBuilder sb = new StringBuilder();
            int to = breakPoints[from];
            while(from < to && from < words.length){
                sb.append(words[from]+" ");
                from++;
            }
                from--;
                output.add(sb.toString());
        }
        
        return  output;
    }
    
    
    public int[][] costMatrix(String[] words, int maxWidth){
        int[][] costMatrix = new int[words.length][words.length];
        
        for(int row = 0; row < words.length; row++){
            for(int column = row; column < words.length; column++){
                int cost  = maxWidth;
                int start = row;//Start with current row and move till column
                int oneSpaceBetweenEachWord = 0;
                while (start <= column){
                    cost-=words[start].length();
                    oneSpaceBetweenEachWord++;//For one space between them;
                    start++;
                }
                
                cost-=oneSpaceBetweenEachWord-1;//Not counting last word
                
                costMatrix[row][column] = cost < 0?Integer.MAX_VALUE:(int)Math.pow(cost,2);
            }
        }
        
        return costMatrix;
    }
    
}
