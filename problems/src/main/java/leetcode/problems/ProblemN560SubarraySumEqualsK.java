package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class ProblemN560SubarraySumEqualsK {
/* 560. Subarray Sum Equals K
Medium, Topics: Array, Hash Table, Prefix Sum


Given an array of integers nums and an integer k,
return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2:
Input: nums = [1,2,3], k = 3
Output: 2

Constraints:
    1 <= nums.length <= 2 * 10^4
    -1000 <= nums[i] <= 1000
    -10^7 <= k <= 10^7 */

    public static void main(String[] args) {
        System.out.println("Hello LeetCode #560. Subarray Sum Equals K");

        System.out.println("Solution for example 1: " + subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println("Solution for example 1 is " +
                ((subarraySum(new int[]{1, 1, 1}, 2) == 2) ? "***CORRECT***" : "!!! WRONG !!!"));

        System.out.println("Solution for example 1: " + subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println("Solution for example 1 is " +
                ((subarraySum(new int[]{1, 2, 3}, 3) == 2) ? "***CORRECT***" : "!!! WRONG !!!"));


    }

//    brute-force O(N^3), space O(1)
 /*   public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int l = i; l <= j; l++) {
                    sum += nums[l];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    } */

    // O(N^2), space O(1)
 /*   public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for (int left = 0; left < n; left++) {
            int sum = nums[left];
            int right = left;
            if (sum == k) {
                count++;
            }
            while (right < n - 1) {
                right++;
                sum += nums[right];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    } */

    // still O(N^2) but using prefixes array - a bit better, O(N) for space
 /*   public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        int[] sumArray = new int[n];
        sumArray[0] = nums[0];
        if (sumArray[0] == k) {
            count++;
        }
        for (int i = 1; i < n; i++) {
            sumArray[i] = sumArray[i - 1] + nums[i];
            if (sumArray[i] == k) {
                count++;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = i ; j < n; j++) {
                int sumij = sumArray[j] - sumArray[i] + nums[i];
                if (sumij == k) {
                    count++;
                }
            }
        }
        return count;
    }*/

    //    O(N), hashMap sum frequency, but space O(N)
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        Map<Integer, Integer> prefixSumsFreqMap = new HashMap<>(n);
        prefixSumsFreqMap.put(0, 1);
        int currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += nums[i];
            int target = currentSum - k;
            if (prefixSumsFreqMap.containsKey(target)) {
                count += prefixSumsFreqMap.get(target);
            }
            prefixSumsFreqMap.put(currentSum, prefixSumsFreqMap.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }

}
