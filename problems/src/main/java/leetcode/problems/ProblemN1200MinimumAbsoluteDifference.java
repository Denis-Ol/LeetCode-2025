package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProblemN1200MinimumAbsoluteDifference {
    /* 1200. Minimum Absolute Difference
Easy, Topics: Array, Sorting

Given an array of distinct integers arr,
find all pairs of elements with the minimum absolute difference of any two elements.

Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
    a, b are from arr
    a < b
    b - a equals to the minimum absolute difference of any two elements in arr


Example 1:
Input: arr = [4,2,1,3]
Output: [[1,2],[2,3],[3,4]]
Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.

Example 2:
Input: arr = [1,3,6,10,15]
Output: [[1,3]]

Example 3:
Input: arr = [3,8,-10,23,19,-4,-14,27]
Output: [[-14,-10],[19,23],[23,27]]

Constraints:
    2 <= arr.length <= 10^5
    -10^6 <= arr[i] <= 10^6

 */

    public static void main(String[] args) {
        System.out.println("Hello LeetCode #1200. Minimum Absolute Difference");
        int[] arrEx1 = {4, 2, 1, 3};
        System.out.println("Solution for example 1: " + minimumAbsDifference(arrEx1));
        List<List<Integer>> listEx1 = new ArrayList<>();
        listEx1.add(Arrays.asList(1, 2));
        listEx1.add(Arrays.asList(2, 3));
        listEx1.add(Arrays.asList(3, 4));
        System.out.println("Solution for example 1 is " +
                (minimumAbsDifference(arrEx1).equals(listEx1) ? "***CORRECT***" : "!!! WRONG !!!"));

        int[] arrEx2 = {1, 3, 6, 10, 15};
        System.out.println("Solution for example 2: " + minimumAbsDifference(arrEx2));
        List<List<Integer>> listEx2 = new ArrayList<>();
        listEx2.add(Arrays.asList(1, 3));
        System.out.println("Solution for example 2 is " +
                (minimumAbsDifference(arrEx2).equals(listEx2) ? "***CORRECT***" : "!!! WRONG !!!"));

        int[] arrEx3 = {3, 8, -10, 23, 19, -4, -14, 27};
        System.out.println("Solution for example 3: " + minimumAbsDifference(arrEx3));
        List<List<Integer>> listEx3 = new ArrayList<>();
        listEx3.add(Arrays.asList(-14, -10));
        listEx3.add(Arrays.asList(19, 23));
        listEx3.add(Arrays.asList(23, 27));
        System.out.println("Solution for example 3 is " +
                (minimumAbsDifference(arrEx3).equals(listEx3) ? "***CORRECT***" : "!!! WRONG !!!"));

    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int dist = arr[i + 1] - arr[i];
            if (min > dist) min = dist;
        }
        List<List<Integer>> listOfPairs = new ArrayList<>();
        for (int j = 0; j < n - 1; j++) {
            if (arr[j + 1] - arr[j] == min) listOfPairs.add(Arrays.asList(arr[j], arr[j + 1]));
        }
        return listOfPairs;
    }
}
