package leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class ProblemN334IncreasingTripletSubsequence {
/*  334. Increasing Triplet Subsequence
Medium,
Topics: Array, Greedy

Given an integer array nums, return true
if there exists a triple of indices (i, j, k)
such that i < j < k and nums[i] < nums[j] < nums[k].
If no such indices exists, return false.

Example 1:
Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.

Example 2:
Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.

Example 3:
Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: One of the valid triplet is (3, 4, 5),
because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.

Constraints:
    1 <= nums.length <= 5 * 10^5
    -2^31 <= nums[i] <= 2^31 - 1

Follow up: Could you implement a solution that runs in
O(n) time complexity and O(1) space complexity? */

    public static void main(String[] args) {
        System.out.println("Hello LeetCode #334 Increasing Triplet Subsequence");
        System.out.println("Solution for example 1: " + increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println("Solution for example 1 is " +
                (increasingTriplet(new int[]{1, 2, 3, 4, 5}) ? "***CORRECT***" : "!!! WRONG !!!"));

        System.out.println("Solution for example 2: " + increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        System.out.println("Solution for example 2 is " +
                (!increasingTriplet(new int[]{5, 4, 3, 2, 1}) ? "***CORRECT***" : "!!! WRONG !!!"));

        System.out.println("Solution for example 3: " + increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
        System.out.println("Solution for example 3 is " +
                (increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}) ? "***CORRECT***" : "!!! WRONG !!!"));

        System.out.println("Solution for test 78: " + increasingTriplet(new int[]{6, 7, 1, 2}));
        System.out.println("Solution for test 78 is " +
                (!increasingTriplet(new int[]{6, 7, 1, 2}) ? "***CORRECT***" : "!!! WRONG !!!"));

        int[] numsTest71 = {20, 100, 10, 12, 5, 13};
        System.out.println("Solution for test 71: " + increasingTriplet(numsTest71));
        System.out.println("Solution for test 71 is " +
                (increasingTriplet(numsTest71) ? "***CORRECT***" : "!!! WRONG !!!"));

        int[] numsTest77 = {1, 1, -2, 6};
        System.out.println("Solution for test 71: " + increasingTriplet(numsTest77));
        System.out.println("Solution for test 71 is " +
                (!increasingTriplet(numsTest77) ? "***CORRECT***" : "!!! WRONG !!!"));


    }

    // Time Complexity: O(n³), Space Complexity: O(1)
/*    public static boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] < nums[j] && nums[j] < nums[k]) {
                        return true;
                    }
                }
            }
        }
        return false;
    } */
// O(n) time complexity and O(1) space
/*    public static boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int small1 = Integer.MAX_VALUE;
        int small2 = Integer.MAX_VALUE;
        for (int element : nums) {
            if (element <= small1) {
                small1 = element;
            } else if (element <= small2) {
                small2 = element;
            } else if (element > small2) {
                return true;
            }
        }
        return false;
    } */

    //2 sub-arrays: O(n) time and space
/*    public static boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];

        leftMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }

        rightMax[n - 1] = nums[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], nums[j]);
        }

        for (int i = 1; i < n - 1; i++) {
            if (leftMin[i] < nums[i] && nums[i] < rightMax[i]) {
                return true;
            }
        }
        return false;
    } */

    //Third Approach: Single Pass with leftMin Array and a Variable.
    // time complexity of O(n) but only requires O(n) space for one array.
/*    public static boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int[] leftMin = new int[n];

        leftMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }

        int rightMax = Integer.MIN_VALUE;

        for (int j = n - 1; j >= 1; j--) {
            rightMax = Math.max(rightMax, nums[j]);
            if (leftMin[j - 1] < nums[j - 1] && nums[j - 1] < rightMax) {
                return true;
            }
        }
        return false;
    } */

    //stack, PSE, NGE. O(n) time and space
    public static boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        Deque<Integer> stack = new ArrayDeque<>(n);
        int[] pse = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) pse[i] = -1;
            else pse[i] = stack.peek();
            stack.push(i);
        }
        stack.clear();
        int[] nge = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) nge[i] = -1;
            else nge[i] = stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            if (pse[i] != -1 && nge[i] != -1) {
                return true;
            }
        }
        return false;
    }


}
