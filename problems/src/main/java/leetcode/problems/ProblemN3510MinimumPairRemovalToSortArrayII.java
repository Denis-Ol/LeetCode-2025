package leetcode.problems;

import leetcode.util.Utils;

import java.io.IOException;
import java.util.Arrays;

public class ProblemN3510MinimumPairRemovalToSortArrayII {
 /* 3510. Minimum Pair Removal to Sort Array II

Hard, Topics: Array, Hash Table, Linked List, Heap (Priority Queue),
              Simulation, Doubly-Linked List, Ordered Set

Given an array nums, you can perform the following operation any number of times:
    * Select the adjacent pair with the minimum sum in nums. 
        If multiple such pairs exist, choose the leftmost one.
    * Replace the pair with their sum.

Return the minimum number of operations needed to make the array non-decreasing.

An array is said to be non-decreasing if each element is greater than 
or equal to its previous element (if it exists).

Example 1:
Input: nums = [5,2,3,1]
Output: 2
Explanation:
    The pair (3,1) has the minimum sum of 4. After replacement, nums = [5,2,4].
    The pair (2,4) has the minimum sum of 6. After replacement, nums = [5,6].
The array nums became non-decreasing in two operations.

Example 2:
Input: nums = [1,2,2]
Output: 0
Explanation:
The array nums is already sorted.

Constraints:
    1 <= nums.length <= 10^5
    -10^9 <= nums[i] <= 10^9    */

    public static void main(String[] args) throws IOException {
        System.out.println("\nHello LeetCode #3510. Minimum Pair Removal to Sort Array II");
        int[] nums = new int[]{5, 2, 3, 1};
        int solution;
        solution = minimumPairRemoval(nums);
        System.out.println("Solution for example 1: " + solution);
        System.out.println("Solution for example 1 is " +
                ((solution == 2) ? "***CORRECT***" : "!!! WRONG !!!"));

        nums = new int[]{1, 2, 2};
        solution = minimumPairRemoval(nums);
        System.out.println("Solution for example 2: " + solution);
        System.out.println("Solution for example 2 is " +
                ((solution == 0) ? "***CORRECT***" : "!!! WRONG !!!"));

        nums = new int[]{564, 561, 543, 576, -379, 510, 54, 383, -615, 468, 431, 601, 412, -397, 421, 183, 160, 415};
        solution = minimumPairRemoval(nums);
        System.out.println("Solution for test 616: " + solution);
        System.out.println("Solution for test 616 is " +
                ((solution == 17) ? "***CORRECT***" : "!!! WRONG !!!"));

        nums = Utils.readCommaSeparatedInts("/3510nums669.txt");
        solution = minimumPairRemoval(nums);
        System.out.println("Solution for test 669: " + solution);
        System.out.println("Solution for test 669 is " +
                ((solution == 9008) ? "***CORRECT***" : "!!! WRONG !!!"));

        nums = Utils.readCommaSeparatedInts("/3510nums674.txt");
        solution = minimumPairRemoval(nums);
        System.out.println("Solution for test 674: " + solution);
        System.out.println("Solution for test 674 is " +
                ((solution == 99998) ? "***CORRECT***" : "!!! WRONG !!!"));
    }

    // inplace array action, 674 test - Time Limit Exceeded
    public static int minimumPairRemoval(int[] nums) {
        int count = 0;
        int length = nums.length;
        long[] numsLong = Arrays.stream(nums)
                .mapToLong(i -> i)
                .toArray();

        while (!isArrayNonDecreasing(numsLong, length)) {
            swapArray(numsLong, length);
            length--;
            count++;
        }
        return count;
    }

    private static boolean isArrayNonDecreasing(long[] nums, int n) {
        if (n == 1) {
            return true;
        }
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static int minSumPairIndex(long[] nums, int n) {
        if (n == 2) {
            return 0;
        }
        long sum = Long.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < n - 1; i++) {
            long currSum = nums[i] + nums[i + 1];
            if (currSum < sum) {
                index = i;
                sum = currSum;
            }
        }
        return index;
    }

    private static void swapArray(long[] nums, int n) {
        int index = minSumPairIndex(nums, n);
        nums[index] += nums[index + 1];
        for (int i = index + 1; i < n - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }
}
