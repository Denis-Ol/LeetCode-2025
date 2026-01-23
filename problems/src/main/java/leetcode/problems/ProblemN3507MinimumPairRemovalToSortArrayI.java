package leetcode.problems;

public class ProblemN3507MinimumPairRemovalToSortArrayI {
 /* 3507. Minimum Pair Removal to Sort Array I
Easy, Topics: Array, Hash Table, Linked List, Heap (Priority Queue), 
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
    1 <= nums.length <= 50
    -1000 <= nums[i] <= 1000     */

    public static void main(String[] args) {
        System.out.println("\nHello LeetCode #3507. Minimum Pair Removal to Sort Array I");
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
    }

    // 8 ms - 9%
    public static int minimumPairRemoval(int[] nums) {
        int count = 0;
        while (!isArrayNonDecreasing(nums)) {
            int[] newArr = swapArray(nums);
            nums = newArr;
            count++;
        }
        return count;
    }

    private static boolean isArrayNonDecreasing(int[] nums) {
        int n = nums.length;
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

    private static int minSumPairIndex(int[] nums) {
        int n = nums.length;
        if (n == 2) {
            return 0;
        }
        int sum = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < n - 1; i++) {
            int currSum = nums[i] + nums[i + 1];
            if (currSum < sum) {
                index = i;
                sum = currSum;
            }
        }
        return index;
    }

    private static int[] swapArray(int[] nums) {
        int n = nums.length;
        int[] newArr = new int[n - 1];
        int index = minSumPairIndex(nums);
        for (int i = 0; i < index; i++) {
            newArr[i] = nums[i];
        }
        newArr[index] = nums[index] + nums[index + 1];
        for (int i = index + 1; i < n - 1; i++) {
            newArr[i] = nums[i + 1];
        }
        return newArr;
    }
}
