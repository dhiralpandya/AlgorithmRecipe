package com.omtlab.algorithmrecipe.array.sumarray;

import java.util.List;
import java.util.Stack;

/**
 * 636. Exclusive Time of Functions
 * On a single threaded CPU, we execute some functions.  Each function has a unique id between 0 and N-1.
 * <p>
 * We store logs in timestamp order that describe when a function is entered or exited.
 * <p>
 * Each log is a string with this format: "{function_id}:{"start" | "end"}:{timestamp}".  For example, "0:start:3"
 * means the function with id 0 started at the beginning of timestamp 3.  "1:end:2" means the function with id 1
 * ended at the end of timestamp 2.
 * <p>
 * A function's exclusive time is the number of units of time spent in this function.  Note that this does not
 * include any recursive calls to child functions.
 * <p>
 * The CPU is single threaded which means that only one function is being executed at a given time unit.
 * <p>
 * Return the exclusive time of each function, sorted by their function id.
 * <p>
 * Input:
 * n = 2
 * logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
 * Output: [3, 4]
 * Explanation:
 * Function 0 starts at the beginning of time 0, then it executes 2 units of time and reaches the end of time 1.
 * Now function 1 starts at the beginning of time 2, executes 4 units of time and ends at time 5.
 * Function 0 is running again at the beginning of time 6, and also ends at the end of time 6, thus executing for 1
 * unit of time.
 * So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 spends 4 units of total time executing.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= n <= 100
 * Two functions won't start or end at the same time.
 * Functions will always log when they exit.
 */
public class LC636 {

    /**
     * Read problem carefully and understand it first.
     *
     * Here are some point to consider.
     * 1. It is one threaded application
     * 2. Only one function execution at a time.
     * 3. Execution starts with One function (I would say entry level function)
     * 4. Entry level function will going to call other functions (I would say child functions)
     * 5. Since it is one threaded application and one function execution at a time.
     * Here is the input we will get
     *   - [ENTRY_FN_START,
     *       CHILD_FN1_START,
     *         CHILD_FN1.1_START,
     *         CHILD_FN1.1_END,
     *       CHILD_FN1_END,
     *       CHILD_FN2_START,
     *       CHILD_FN2_END,
     *     ENTRY_FN_END]
     */

    /**
     * Before starting off with the solution,
     * let's discuss a simple idea.
     * Suppose we have three functions func_1func func_2func and func_3func
     * such that func_1func calls func_2func   and then func_2func calls func_3func  .
     * In this case, func_3func  starts at the end and ends first, func_2func  starts at 2nd position and ends at the 2nd last step.
     * Similarly, func_1func   starts first and ends at the last position.
     * Thus, we can conclude that the function which is entered at the end finishes first and the one which is entered first ends at the last position.
     */
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
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
