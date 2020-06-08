package com.omtlab.algorithmrecipe.quicksort;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 973. K Closest Points to Origin
 * <p>
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * <p>
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * <p>
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 * <p>
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 */
public class LC973 {

    /**
     * Find details about Euclidean distance in documentation/EuclideanDistance.pdf
     * √ ( x 2 − x 1 )^2 + ( y 2 − y 1 )^2
     */
    public Integer[][] kClosest(Integer[][] points, int k) {
        int start = 0;
        int end = points.length-1;
        List<List<Integer>> output = Lists.newArrayList();
        while (start < end) {
            int startPointer = quickSort(start, end, points);
            if(startPointer < k) { // Continue until we get k results.
                start = startPointer;
            } else {
                break; // Here startPointer reached at k or crossed it. It means we already got at least k points.
            }
        }

        for(int i = 0; i < points.length && k > 0; i++,k--) {
            List<Integer> selectedPoints = Lists.newArrayList();
            selectedPoints.add(points[i][0]);
            selectedPoints.add(points[i][1]);
            output.add(selectedPoints);
        }

        return output.stream()
                .map(list -> list.stream().toArray(Integer[]::new))
                .toArray(Integer[][]::new);
    }

    private int quickSort(int start, int end, Integer[][] points) {
        while (start < end) {

            Double pivote = calcualteEuclideanDistance(points[(start + end) / 2]);

            while (calcualteEuclideanDistance(points[start]) < pivote) {
                start++;
            }

            while (calcualteEuclideanDistance(points[end]) > pivote) {
                end--;
            }

            if (start < end) {
                swap(points, start, end);
                start++;
                end--;
            }
        }

        return start;
    }

    private Double calcualteEuclideanDistance(Integer[] xy) {
        return (Math.pow(xy[0], 2) + Math.pow(xy[1], 2));
    }

    private void swap(Integer[][] points, int i, int j) {
        Integer[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

}
