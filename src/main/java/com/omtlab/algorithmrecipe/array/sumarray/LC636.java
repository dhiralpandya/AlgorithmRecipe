package com.omtlab.algorithmrecipe.array.sumarray;

import java.util.List;
import java.util.Stack;

/**
 * 636. Exclusive Time of Functions
 * On a single threaded CPU, we execute some functions.  Each function has a unique id between 0 and N-1.
 *
 * We store logs in timestamp order that describe when a function is entered or exited.
 *
 * Each log is a string with this format: "{function_id}:{"start" | "end"}:{timestamp}".  For example, "0:start:3" 
 * means the function with id 0 started at the beginning of timestamp 3.  "1:end:2" means the function with id 1 
 * ended at the end of timestamp 2.
 *
 * A function's exclusive time is the number of units of time spent in this function.  Note that this does not 
 * include any recursive calls to child functions.
 *
 * The CPU is single threaded which means that only one function is being executed at a given time unit.
 *
 * Return the exclusive time of each function, sorted by their function id.
 *
 *Input:
 * n = 2
 * logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
 * Output: [3, 4]
 * Explanation:
 * Function 0 starts at the beginning of time 0, then it executes 2 units of time and reaches the end of time 1.
 * Now function 1 starts at the beginning of time 2, executes 4 units of time and ends at time 5.
 * Function 0 is running again at the beginning of time 6, and also ends at the end of time 6, thus executing for 1 
 * unit of time. 
 * So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 spends 4 units of total time executing.
 *
 *
 * Note:
 *
 * 1 <= n <= 100
 * Two functions won't start or end at the same time.
 * Functions will always log when they exit.
 */
public class LC636 {
    
    public int[] getExclusiveTime(int n, List<String> logs){
        int[] output = new int[n];
        
         for(int index = 0; index < logs.size(); index++){
             String log[] = logs.get(index).split(":");
             int i = Integer.parseInt(log[0]);
             String  status = log[1];
             int timestamp = Integer.parseInt(log[2]);
             
             //Identify at ZERO
             if(index == 0){
                 String logNext[] = logs.get(index+1).split(":");
                 int iNext = Integer.parseInt(logNext[0]);
                 String  statusNext = logNext[1];
                 int timestampNext = Integer.parseInt(logNext[2]);
                 output[i] = timestampNext;
                 
                 if(iNext == 0){
                     index++;
                 }
                 continue;
             }
             
             
             if(status.equalsIgnoreCase("start")){
                 String logNext[] = logs.get(index+1).split(":");
                 int iNext = Integer.parseInt(logNext[0]);
                 String  statusNext = logNext[1];
                 int timestampNext = Integer.parseInt(logNext[2]);
                 output[i] = timestampNext-timestamp;
                 if(i == iNext){
                     output[i]++;
                     index++;
                 }
             } else {
                 String logPre[] = logs.get(index-1).split(":");
                 int iPre = Integer.parseInt(logPre[0]);
                 String  statusPre = logPre[1];
                 int timestampPre = Integer.parseInt(logPre[2]);
                 output[i]+=timestamp-timestampPre;
             }
             
         }
        
        return output;
    }

    public int[] exclusiveTime(int n, List < String > logs) {
        Stack< Integer > stack = new Stack < > ();
        int[] res = new int[n];
        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int i = 1, prev = Integer.parseInt(s[2]);
        while (i < logs.size()) {
            s = logs.get(i).split(":");
            if (s[1].equals("start")) {
                if (!stack.isEmpty())
                    res[stack.peek()] += Integer.parseInt(s[2]) - prev;
                stack.push(Integer.parseInt(s[0]));
                prev = Integer.parseInt(s[2]);
            } else {
                res[stack.peek()] += Integer.parseInt(s[2]) - prev + 1;
                stack.pop();
                prev = Integer.parseInt(s[2]) + 1;
            }
            i++;
        }
        return res;
    }
}
