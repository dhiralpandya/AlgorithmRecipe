package com.omtlab.algorithmrecipe.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 * <p>
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * <p>
 * Note:
 * <p>
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 * Example 1:
 * <p>
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 * <p>
 * Input: ["4", "13", "5", "/", "+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 * <p>
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22
 * Explanation:
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class LC150 {

    Map<String, Evaluator> operatorToEvaluatorFunction = new HashMap<String, Evaluator>() {
        {
            put("*", (int a, int b) -> a * b);
            put("/", (int a, int b) -> a / b);
            put("-", (int a, int b) -> a - b);
            put("+", (int a, int b) -> a + b);
        }
    };

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String value : tokens) {
            if (operatorToEvaluatorFunction.containsKey(value)) {
                int a = stack.pop();
                int b = stack.pop();
                //IMP b , a not a , b because stack will pop last first (Order matter for division)
                int result = operatorToEvaluatorFunction.get(value).evaluate(b, a);
                stack.push(result);
                continue;
            }
            stack.push(Integer.valueOf(value));
        }

        return stack.pop();
    }

    @FunctionalInterface
    private interface Evaluator {
        int evaluate(int a, int b);
    }
}
