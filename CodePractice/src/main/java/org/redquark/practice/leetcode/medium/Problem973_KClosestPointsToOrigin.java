package org.redquark.practice.leetcode.medium;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Anirudh Sharma
 * <p>
 * We have a list of points on the plane. Find the K closest points to the origin (0, 0).
 * <p>
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * <p>
 * You may return the answer in any order.
 * The answer is guaranteed to be unique (except for the order that it is in.)
 * <p>
 * Note:
 * <p>
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */
public class Problem973_KClosestPointsToOrigin {

    private static int[][] kClosest(int[][] points, int K) {
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1])));
        Collections.addAll(minHeap, points);
        int[][] result = new int[K][2];
        int index = 0;
        while (K > 0) {
            int[] current = minHeap.remove();
            result[index][0] = current[0];
            result[index][1] = current[1];
            K--;
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{1, 3}, {-2, 2}};
        int k = 1;
        int[][] result = kClosest(points, k);
        System.out.println(k + " closest point(s) to origin : ");
        for (int[] ints : result) {
            System.out.print("[" + ints[0] + ", " + ints[1] + "]");
            System.out.println();
        }
    }
}
