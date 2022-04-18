package com.omtlab.algorithmrecipe.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 777. Swap Adjacent in LR String
 * <p>
 * In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL",
 * a move consists of either replacing one occurrence of "XL" with "LX",
 * or replacing one occurrence of "RX" with "XR".
 * Given the starting string start and the ending string end,
 * return True if and only if there exists a sequence of moves to transform
 * one string to the other.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * Output: true
 * Explanation: We can transform start to end following these steps:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 * Example 2:
 * <p>
 * Input: start = "X", end = "L"
 * Output: false
 */
public class LC777 {
    public boolean mysolution(String start, String end) {

        if (start == null
                || end == null
                || start.length() != end.length()) {
            return false;
        }

        Map<String, String> cache = new HashMap<String, String>() {
            {
                put("XL", "LX");
                put("RX", "XR");
            }
        };
        String expecting = null;

        for (int i = 0; i < start.length(); i++) {
            Character s = start.charAt(i);
            Character e = end.charAt(i);
            if (i == start.length() - 1
                    && s != e
                    && expecting == null) {
                return false;
            }

            if (expecting != null && s == e) {
                return false;
            }

            if (expecting != null
                    && expecting.equals(s + "" + e)) {
                expecting = null;
                continue;
            }

            if (expecting != null &&
                    !expecting.equals(s + "" + e)) {
                return false;
            }

            if (expecting == null && s == e) {
                continue;
            }

            if (!cache.containsKey(s + "" + e)) {
                return false;
            }

            expecting = cache.get(s + "" + e);
        }

        return true;
    }


    public boolean canTransform(String start, String end) {
        // Just get the non-X characters and compare the positions of them.
        if (!start.replace("X", "").equals(end.replace("X", ""))) {
            return false;
        }

        int p1 = 0;
        int p2 = 0;

        while (p1 < start.length() && p2 < end.length()) {

            // get the non-X positions of 2 strings
            while (p1 < start.length() && start.charAt(p1) == 'X') {
                p1++;
            }
            while (p2 < end.length() && end.charAt(p2) == 'X') {
                p2++;
            }

            //if both of the pointers reach the end the strings are transformable
            if (p1 == start.length() && p2 == end.length()) {
                return true;
            }
            // if only one of the pointer reach the end they are not transformable
            if (p1 == start.length() || p2 == end.length()) {
                return false;
            }

            if (start.charAt(p1) != end.charAt(p2)) {
                return false;
            }
            // if the character is 'L', it can only be moved to the left. p1 should be greater or equal to p2.
            // p1 = X"L" and p2 = "L"X
            if (start.charAt(p1) == 'L' && p2 > p1) {
                return false;
            }
            // if the character is 'R', it can only be moved to the right. p2 should be greater or equal to p1.
            // p1 = "R"X and p2 = X"R"
            if (start.charAt(p1) == 'R' && p1 > p2) {
                return false;
            }
            p1++;
            p2++;
        }
        return true;
    }

}
