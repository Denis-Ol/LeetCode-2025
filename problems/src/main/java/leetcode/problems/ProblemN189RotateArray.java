package leetcode.problems;

import java.io.IOException;
import java.util.Arrays;

public class ProblemN189RotateArray {
    /* 189. Rotate Array

Medium, Topics: Array, Math, Two Pointers

Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

Constraints:
    1 <= nums.length <= 10^5
    -2^31 <= nums[i] <= 2^31 - 1
    0 <= k <= 10^5

Follow up:
Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space? */

    public static void main(String[] args) throws IOException {
        System.out.println("Hello LeetCode #189. Rotate Array");

        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums1, 3);
        int[] nums1Ans = {5, 6, 7, 1, 2, 3, 4};
        System.out.println("Solution for example 1: " + Arrays.toString(nums1));
        System.out.println("Solution for example 1 is " +
                (Arrays.equals(nums1, nums1Ans) ? "***CORRECT***" : "!!! WRONG !!!"));

        int[] nums2 = {-1, -100, 3, 99};
        rotate(nums2, 2);
        int[] nums2Ans = {3, 99, -1, -100};
        System.out.println("Solution for example 2: " + Arrays.toString(nums2));
        System.out.println("Solution for example 2 is " +
                (Arrays.equals(nums2, nums2Ans) ? "***CORRECT***" : "!!! WRONG !!!"));


//        int[] test38 = Utils.readCommaSeparatedInts("/189test38.txt");
//        rotate(test38, 54944);
//        int[] test38Ans = {3, 99, -1, -100};
//        System.out.println("Solution for example 2: " + Arrays.toString(test38));
//        System.out.println("Solution for example 2 is " +
//                (Arrays.equals(test38, test38Ans) ? "***CORRECT***" : "!!! WRONG !!!"));

    }
/*
// Bubble method, O(k*N), O(1)
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        for (int i = 0; i < k; i++) {
            oneStep(nums);
        }
    }

    public static void oneStep(int[] a) {
        int n = a.length;
        int last = a[n - 1];
        for (int i = n - 1; i > 0; i--) {
            a[i] = a[i - 1];
        }
        a[0] = last;
    } */

    private static void reversePart(int[] a, int left, int right) {
        int temp;
        while (left < right) {
            temp = a[left];
            a[left++] = a[right];
            a[right--] = temp;
        }
    }
// Reverse method, O(N), O(1)
//    public static void rotate(int[] nums, int k) {
//        int n = nums.length;
//        k = k % n;
//        reversePart(nums, 0, n - 1);
//        reversePart(nums, 0, k - 1);
//        reversePart(nums, k, n - 1);
//    }

    //using temp array, O(N), O(N)
//    public static void rotate(int[] nums, int k) {
//        int n = nums.length;
//        int[] temp = new int[n];
//        k = k % n;
//        for (int i = 0; i < n; i++) {
//            temp[(i + k) % n] = nums[i];
//        }
//        for (int i = 0; i < n; i++) {
//            nums[i] = temp[i];
//        }
//    }

    // cyclic replacement, O(N), O(1)
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0) {
            return;
        }
        int count = 0;
        int start = 0;
        while (count < n) {
            int index = start;
            int valueToMove = nums[index];
            do {
                int newIndex = (index + k) % n;
                int temp = nums[newIndex];
                nums[newIndex] = valueToMove;
                valueToMove = temp;
                index = newIndex;
                count++;
            } while (index != start);
            start++;
        }
    }

}
