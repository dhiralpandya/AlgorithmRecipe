package com.omtlab.algorithmrecipe.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.abs;

/**
 * 2013. Detect Squares
 * <p>
 * You are given a stream of points on the X-Y plane. Design an algorithm that:
 * <p>
 * Adds new points from the stream into a data structure. Duplicate points are allowed and should be treated as different points.
 * Given a query point, counts the number of ways to choose three points from the data structure such that the three points and the query point form an axis-aligned square with positive area.
 * An axis-aligned square is a square whose edges are all the same length and are either parallel or perpendicular to the x-axis and y-axis.
 * <p>
 * Implement the DetectSquares class:
 * <p>
 * DetectSquares() Initializes the object with an empty data structure.
 * void add(int[] point) Adds a new point point = [x, y] to the data structure.
 * int count(int[] point) Counts the number of ways to form axis-aligned squares with point point = [x, y] as described above.
 * <p>
 * <p>
 * Input
 * ["DetectSquares", "add", "add", "add", "count", "count", "add", "count"]
 * [[], [[3, 10]], [[11, 2]], [[3, 2]], [[11, 10]], [[14, 8]], [[11, 2]], [[11, 10]]]
 * Output
 * [null, null, null, null, 1, 0, null, 2]
 * <p>
 * Explanation
 * DetectSquares detectSquares = new DetectSquares();
 * detectSquares.add([3, 10]);
 * detectSquares.add([11, 2]);
 * detectSquares.add([3, 2]);
 * detectSquares.count([11, 10]); // return 1. You can choose:
 * //   - The first, second, and third points
 * detectSquares.count([14, 8]);  // return 0. The query point cannot form a square with any points in the data structure.
 * detectSquares.add([11, 2]);    // Adding duplicate points is allowed.
 * detectSquares.count([11, 10]); // return 2. You can choose:
 * //   - The first, second, and third points
 * //   - The first, third, and fourth points
 * <p>
 * <p>
 * Constraints:
 * <p>
 * point.length == 2
 * 0 <= x, y <= 1000
 * At most 3000 calls in total will be made to add and count.
 */
public class LC2013 {
    /**
     * Check more details in documentation/LC2013_Question.png
     * <p>
     * Check documentation/LC2013_Solution.png
     * <p>
     * Here we want to find number of square.
     * <p>
     * To compute count(p1):
     * We try all points p3 which together with p1 form the diagonal of non-empty square,
     * it means abs(p1.x-p3.x) == abs(p1.y-p3.y) && abs(p1.x-p3.x) > 0
     * Since we have 2 points p1 and p3,
     * we can form a square by computing the positions of 2 remain points p2, p4.
     * p2 = (p1.x, p3.y)
     * p4 = (p3.x, p1.y)
     * <p>
     * p1-----p2
     * |      |
     * |      |
     * p4-----p3
     */
    private Map<String, Integer> pointToCountMap = new HashMap<>();
    private List<Integer[]> listOfAllPoints = new ArrayList<>();

    public void add(Integer[] p) {
        listOfAllPoints.add(p);
        int count = pointToCountMap.getOrDefault(getPointKey(p), 0) + 1;
        pointToCountMap.put(getPointKey(p), count);
    }

    public int count(Integer[] p1) {
        int result = 0;
        int p1x = p1[0];
        int p1y = p1[1];
        for (Integer[] p3 : listOfAllPoints) {
            int p3x = p3[0];
            int p3y = p3[1];

            if (abs(p1x - p3x) > 0 && abs(p1x - p3x) == abs(p1y - p3y)) {
                Integer[] p2 = {p1x, p3y};
                Integer[] p4 = {p3x, p1y};
                result += pointToCountMap.getOrDefault(getPointKey(p2), 0)
                        * pointToCountMap.getOrDefault(getPointKey(p4), 0);
            }
        }

        return result;
    }

    private String getPointKey(Integer[] p) {
        return String.format("%s-%s", p[0], p[1]);
    }

}
