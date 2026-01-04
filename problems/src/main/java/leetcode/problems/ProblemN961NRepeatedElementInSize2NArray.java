package leetcode.problems;

public class ProblemN961NRepeatedElementInSize2NArray {
/* 961. N-Repeated Element in Size 2N Array
Easy, Topics: Array, Hash Table

You are given an integer array nums with the following properties:
    nums.length == 2 * n.
    nums contains n + 1 unique elements.
    Exactly one element of nums is repeated n times.

Return the element that is repeated n times.

Example 1:
Input: nums = [1,2,3,3]
Output: 3

Example 2:
Input: nums = [2,1,2,5,3,2]
Output: 2

Example 3:
Input: nums = [5,1,5,2,5,3,5,4]
Output: 5

Constraints:
    2 <= n <= 5000
    nums.length == 2 * n
    0 <= nums[i] <= 10^4
    nums contains n + 1 unique elements and one of them is repeated exactly n times.  */

    public static void main(String[] args) {
        System.out.println("Hello LeetCode #961. N-Repeated Element in Size 2N Array");
        int[] nums1 = {1, 2, 3, 3};
        System.out.println("Solution for example 1: " + repeatedNTimes(nums1));
        System.out.println("Solution for example 1 is " +
                (repeatedNTimes(nums1) == 3 ? "***CORRECT***" : "!!! WRONG !!!"));

        int[] nums2 = {2, 1, 2, 5, 3, 2};
        System.out.println("Solution for example 2: " + repeatedNTimes(nums2));
        System.out.println("Solution for example 2 is " +
                (repeatedNTimes(nums2) == 2 ? "***CORRECT***" : "!!! WRONG !!!"));

        int[] nums3 = {5, 1, 5, 2, 5, 3, 5, 4};
        System.out.println("Solution for example 3: " + repeatedNTimes(nums3));
        System.out.println("Solution for example 3 is " +
                (repeatedNTimes(nums3) == 5 ? "***CORRECT***" : "!!! WRONG !!!"));
    }

    public static int repeatedNTimes(int[] nums) {
        int k = nums.length;
        for (int i = 1; i < k - 1; i++) {
            if (nums[i - 1] == nums[i] || nums[i - 1] == nums[i + 1]) {
                return nums[i - 1];
            }
        }
        return nums[k - 1];
    }
}


