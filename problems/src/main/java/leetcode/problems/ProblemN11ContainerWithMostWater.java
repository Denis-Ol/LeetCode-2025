package leetcode.problems;

import leetcode.util.Utils;

import java.io.IOException;

public class ProblemN11ContainerWithMostWater {
/*11. Container With Most Water
Medium, Topics: Array, Two Pointers, Greedy

You are given an integer array height of length n. 
There are n vertical lines drawn such 
that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, 
such that the container contains the most water.
Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. 
In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1

Constraints:
n == height.length
2 <= n <= 10^5
0 <= height[i] <= 10^4 */

    public static void main(String[] args) throws IOException {
        System.out.println("Hello LeetCode #516. Longest Palindromic Subsequence");
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
//        System.out.println("area(1, 8, height) = " + area(1, 8, height));
//        System.out.println("Solution for example 1: " + maxArea(height));
        System.out.println("Solution for example 1 is " +
                ((maxArea(height) == 49) ? "***CORRECT***" : "!!! WRONG !!!"));

        height = new int[]{1, 1};
//        System.out.println("Solution for example 2: " + maxArea(height));
        System.out.println("Solution for example 2 is " +
                ((maxArea(height) == 1) ? "***CORRECT***" : "!!! WRONG !!!"));

        height = Utils.readCommaSeparatedInts("/11height59.txt");
//        System.out.println("Solution for test59: " + maxArea(height));
        System.out.println("Solution for test59 is " +
                ((maxArea(height) == 721777500) ? "***CORRECT***" : "!!! WRONG !!!"));
    }

    /*
//    Brute-force
    public static int maxArea(int[] height) {
        int n = height.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int area = area(i, j, height);
                if (max < area) max = area;
            }
        }
        return max;
    } */

//    private static int area(int leftIndex, int rightIndex, int[] heightArray) {
//        return (rightIndex - leftIndex) * commonHeight(leftIndex, rightIndex, heightArray);
//    }
//
//    private static int commonHeight(int left, int right, int[] height) {
//        return Math.min(height[left], height[right]);
//    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int min = Math.min(height[left], height[right]);
            max = Math.max(max, min * (right - left));
            while (height[left] <= min && left < right) left++;
            while (height[right] <= min && left < right) right--;
        }
        return max;
    }
}
