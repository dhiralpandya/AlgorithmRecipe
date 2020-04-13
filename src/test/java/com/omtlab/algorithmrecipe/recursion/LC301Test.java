package com.omtlab.algorithmrecipe.recursion;
import org.junit.Test;

import java.util.Set;

public class LC301Test {

    LC301 lc301 = new LC301();

    @Test
    public void testRemoveInvalidParentheses() {
        String s1 = "()())()";
        output(lc301.removeInvalidParentheses(s1));
        System.out.println("------------------");
        String s2 = "(()()";
        output(lc301.removeInvalidParentheses(s2));
        System.out.println("------------------");
        String s3 = ")(";
        output(lc301.removeInvalidParentheses(s3));
        System.out.println("------------------");
        String s4 = "(a)())()";
        output(lc301.removeInvalidParentheses(s4));
    }

    private void output(Set<String> set) {
        set.forEach(System.out::println);
    }
}
