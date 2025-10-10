package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class ProblemN442FindAllDuplicatesInAnArray {
/*
442. Find All Duplicates in an Array
Medium, Topics: Array, Hash Table

Given an integer array nums of length n where all the integers of nums are in the range [1, n]
and each integer appears at most twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant auxiliary space,
excluding the space needed to store the output

Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]

Example 2:
Input: nums = [1,1,2]
Output: [1]

Example 3:
Input: nums = [1]
Output: []

Constraints:
    n == nums.length
    1 <= n <= 10^5
    1 <= nums[i] <= n
    Each element in nums appears once or twice. */

    public static void main(String[] args) {
        System.out.println("Hello LeetCode #442. Find All Duplicates in an Array");

        List<Integer> sol = List.of(2, 3);
        System.out.println("Solution for example 1: " + findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println("Solution for example 1 is " +
                (findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}).equals(sol) ? "***CORRECT***" : "!!! WRONG !!!"));

        sol = List.of(1);
        System.out.println("Solution for example 2: " + findDuplicates(new int[]{1, 1, 2}));
        System.out.println("Solution for example 2 is " +
                (findDuplicates(new int[]{1, 1, 2}).equals(sol) ? "***CORRECT***" : "!!! WRONG !!!"));

        sol = List.of();
        System.out.println("Solution for example 3: " + findDuplicates(new int[]{1}));
        System.out.println("Solution for example 3 is " +
                (findDuplicates(new int[]{1}).equals(sol) ? "***CORRECT***" : "!!! WRONG !!!"));

    }

//    public static List<Integer> findDuplicates(int[] nums) {
//        int n = nums.length;
//        List<Integer> res = new ArrayList<>(n);
//        for (int i = 0; i < n; i++) {
//            int src = Math.abs(nums[i]);
//            int dest = Math.abs(nums[i]) - 1;
//
//            if (nums[dest] < 0) {
//                res.add(src);
//            } else {
//                nums[dest] *= -1;
//            }
//        }
//        return res;
//    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                duplicates.add(index + 1);
            } else {
                nums[index] = -nums[index];
            }
        }
        return duplicates;
    }


}
