package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class ProblemN2461 {
    /*
    2461. Maximum Sum of Distinct Subarrays With Length K (Medium)

You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:

    The length of the subarray is k, and
    All the elements of the subarray are distinct.

Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

A subarray is a contiguous non-empty sequence of elements within an array.


Example 1:
Input: nums = [1,5,4,2,9,9,9], k = 3
Output: 15
Explanation: The subarrays of nums with length 3 are:
- [1,5,4] which meets the requirements and has a sum of 10.
- [5,4,2] which meets the requirements and has a sum of 11.
- [4,2,9] which meets the requirements and has a sum of 15.
- [2,9,9] which does not meet the requirements because the element 9 is repeated.
- [9,9,9] which does not meet the requirements because the element 9 is repeated.
We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions

Example 2:
Input: nums = [4,4,4], k = 3
Output: 0
Explanation: The subarrays of nums with length 3 are:
- [4,4,4] which does not meet the requirements because the element 4 is repeated.
We return 0 because no subarrays meet the conditions.

Constraints:
    1 <= k <= nums.length <= 105
    1 <= nums[i] <= 105
     */

    public static void main(String[] args) {
        System.out.println("Hello LeetCode");
        System.out.println("Solution for example 1: " + maximumSubarraySumNoDistinct(new int[]{2, 3, 5, 1, 3}, 3));
//        System.out.println("Solution for example 2: " + maximumSubarraySum("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb"));
    }

//    public static long maximumSubarraySum(int[] nums, int k) {
//        int max = Integer.MIN_VALUE;
//        int length = nums.length;
//        for (int i = 0; i <= length - k; i++) {
//            int sum = 0;
//            for (int j = 0; j < k; j++) {
//                sum += nums[i + j];
//            }
//            if (max < sum) {
//                max = sum;
//            }
//        }
//        return max;
//    }

    public static long maximumSubarraySumNoDistinct(int[] nums, int k) {
        int sum = 0;
        for (int j = 0; j < k; j++) {
            sum += nums[j];
        }
        int max = sum;

        for (int i = 0; i < nums.length - k; i++) {
            sum = sum - nums[i] + nums[i + k];

            if (max < sum) max = sum;
        }
        return max;
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        long max = sum;
        Map<Integer, Integer> map = new HashMap<>();

        for (int j = 0; j < k; j++) {
            int num = nums[j];
            addNumberToMap(map, num);
            sum += num;
        }
        max = updateMaxIfNoRepeats(max, sum, map, k);

        for (int i = 0; i < nums.length - k; i++) {
            removeNumberFromMap(map, nums[i]);
            addNumberToMap(map, nums[i + k]);
            sum = sum - nums[i] + nums[i + k];

            max = updateMaxIfNoRepeats(max, sum, map, k);
        }
        return max;
    }

    private static long updateMaxIfNoRepeats(long max, long sum, Map<Integer, Integer> map, int k) {
        if (map.size() == k) {
            if (max < sum) max = sum;
        }
        return max;
    }

    private static void removeNumberFromMap(Map<Integer, Integer> map, Integer number) {
        map.computeIfPresent(number, (k, v) -> {
            if (v > 1) return --v;
            else return null;
        });
    }

    private static void addNumberToMap(Map<Integer, Integer> map, Integer number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }


}
