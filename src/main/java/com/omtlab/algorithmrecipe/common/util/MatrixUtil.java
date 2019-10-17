package com.omtlab.algorithmrecipe.common.util;

import java.util.Arrays;
import java.util.List;

public class MatrixUtil {
    
    public static void printMatrix(int[][] input){
        for(int[] i:input){
            System.out.println(Arrays.toString(i));
        }
    }
    
    public static <T> void printListOfList(List<List<T>> listOfList){
        StringBuilder sb = new StringBuilder();
        for(List l : listOfList){
            sb.append("[");
            for(Object o:l){
                sb.append(String.valueOf(o)+",");
            }
            sb.append("]\n");
        }

        System.out.println(sb.toString());
    }

    public static <T> void printListOfListNewLine(List<List<T>> listOfList){
        StringBuilder sb = new StringBuilder();
        for(List l : listOfList){
            sb.append("[\n");
            for(Object o:l){
                sb.append("\t"+String.valueOf(o)+",\n");
            }
            sb.append("]\n");
        }

        System.out.println(sb.toString());
    }
}
