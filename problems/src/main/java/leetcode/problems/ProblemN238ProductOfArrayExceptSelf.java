package leetcode.problems;

import java.util.Arrays;

public class ProblemN238ProductOfArrayExceptSelf {
/* 238. Product of Array Except Self
Medium, Topics: Array, Prefix Sum

Given an integer array nums, return an array answer such
that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Constraints:
        2 <= nums.length <= 10^5
        -30 <= nums[i] <= 30
The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.

Follow up: Can you solve the problem in O(1) extra space complexity?
(The output array does not count as extra space for space complexity analysis.) */

    public static void main(String[] args) {
        System.out.println("Hello LeetCode #238. Product of Array Except Self");

        int[] nums1 = {1, 2, 3, 4};
        int[] ans1 = productExceptSelf(nums1);
        int[] nums1Ans = {24, 12, 8, 6};
        System.out.println("Solution for example 1: " + Arrays.toString(ans1));
        System.out.println("Solution for example 1 is " +
                (Arrays.equals(ans1, nums1Ans) ? "***CORRECT***" : "!!! WRONG !!!"));

        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] ans2 = productExceptSelf(nums2);
        int[] nums2Ans = {0, 0, 9, 0, 0};
        System.out.println("Solution for example 2: " + Arrays.toString(ans2));
        System.out.println("Solution for example 2 is " +
                (Arrays.equals(ans2, nums2Ans) ? "***CORRECT***" : "!!! WRONG !!!"));
    }

    // brute-force O(N^2) time, O(N) space
/*    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) prod *= nums[j];
            }
            answer[i] = prod;
        }
        return answer;
    } */

    /* space O(N)
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }
        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }
        answer[0] = suffix[1];
        answer[n - 1] = prefix[n - 2];
        for (int i = 1; i < n - 1; i++) {
            answer[i] = prefix[i - 1] * suffix[i + 1];
        }
        return answer;
    } */

    // extra space O(1)
 /*   public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        answer[0] = nums[0];//prefix
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            nums[i] = nums[i + 1] * nums[i];
        }
        answer[n - 1] = answer[n - 2];
        for (int i = n - 2; i > 0; i--) {
            answer[i] = answer[i - 1] * nums[i + 1];
        }
        answer[0] = nums[1];
        return answer;
    } */

    // no extra space, 2 passes
/*    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        answer[0] = nums[0];
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i];
        }
        int suf = 1;
        answer[n - 1] = answer[n - 2];
        for (int i = n - 2; i > 0; i--) {
            suf *= nums[i + 1];
            answer[i] = answer[i - 1] * suf;
        }
        answer[0] = suf * nums[1];
        return answer;
    } */

    // change definitions prefix and suffix - all but element now
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int pref = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = pref;
            pref *= nums[i];
        }
        int suf = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suf;
            suf *= nums[i];
        }
        return answer;
    }

}
