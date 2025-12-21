package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class ProblemN1679MaxNumberOfKSumPairs {
/* 1679. Max Number of K-Sum Pairs
Medium, Topics: Array, Hash Table, Two Pointers, Sorting

You are given an integer array nums and an integer k.
In one operation, you can pick two numbers from the array
whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.

Example 1:
Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.

Example 2:
Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.

Constraints:
    1 <= nums.length <= 10^5
    1 <= nums[i] <= 10^9
    1 <= k <= 10^9 */

    public static void main(String[] args) {
        System.out.println("Hello LeetCode #1679. Max Number of K-Sum Pairs");

        int[] nums = {1, 2, 3, 4};
        int k = 5;
        System.out.println("Solution for example 1: " + maxOperations(nums, k));
        System.out.println("Solution for example 1 is " +
                (maxOperations(nums, k) == 2 ? "***CORRECT***" : "!!! WRONG !!!"));

        nums = new int[]{3, 1, 3, 4, 3};
        k = 6;
        System.out.println("Solution for example 2: " + maxOperations(nums, k));
        System.out.println("Solution for example 2 is " +
                (maxOperations(nums, k) == 1 ? "***CORRECT***" : "!!! WRONG !!!"));
    }

    // initial
 /*   public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            if (num < k) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        int countCheck;
        do {
            countCheck = count;
            List<Integer> keysToRemove = new ArrayList<>();
            for (int num : map.keySet()) {
                int target = k - num;
                if (map.containsKey(target)) {
                    if (num == target) {
                        int pair = map.get(num) / 2;
                        count += pair;
                        keysToRemove.add(num);
                        continue;
                    }
                    int min = Math.min(map.get(num), map.get(target));
                    count += min;
                    map.replace(num, map.get(num) - min);
                    map.replace(target, map.get(target) - min);
                    if (map.get(num) == 0) keysToRemove.add(num);
                    if (map.get(target) == 0) keysToRemove.add(target);
                }
            }
            for (Integer key : keysToRemove) map.remove(key);
        } while (countCheck != count);
        return count;
    }*/

    public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            if (num < k) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        for (int num : map.keySet()) {
            if (num <= k / 2) {
                int target = k - num;
                if (map.containsKey(target)) {
                    if (num == target) count += map.get(num) / 2;
                    else count += Math.min(map.get(num), map.get(target));
                }
            }
        }
        return count;
    }
}
