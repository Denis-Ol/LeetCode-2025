package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

public class ProblemN1 {
    /*
    1. Two Sum
Easy, Topics: Array, Hash TableC

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

Constraints:
    2 <= nums.length <= 10^4
    -10^9 <= nums[i] <= 10^9
    -10^9 <= target <= 10^9
    Only one valid answer exists.

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
*/
    public static void main(String[] args) {
        System.out.println("Hello LeetCode #1. Two Sum ");

        int[] result = twoSum(new int[]{2, 7, 11, 15, 1}, 9);
        System.out.println("Solution for example 1: " + result[0] + " and " + result[1]);

        result = twoSum(new int[]{3, 2, 4}, 6);
        System.out.println("Solution for example 2: " + result[0] + " and " + result[1]);

        result = twoSum(new int[]{3, 3}, 6);
        System.out.println("Solution for example 3: " + result[0] + " and " + result[1]);
    }

    //    public static int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i,j};
//                }
//            }
//        }
//        return null;
//    }
//    public static int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(nums[0],0);
//        int complement;
//        for (int i = 1; i < nums.length; i++) {
//            complement = target - nums[i];
//            if (map.containsKey(complement)) {
//                return new int[]{i, map.get(complement)};
//            }
//            map.put(nums[i], i);
//        }
//        return null;
//    }
//    public static int[] twoSum(int[] nums, int target) {
//        int[] result = new int[2];
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = i; j < nums.length; j++) {
//                if (nums[j] + nums[j - i] == target) {
//                    result[0] = j - i;
//                    result[1] = j;
//                    return result;
//                }
//            }
//
//        }
//        return result;
//    }

    public static int[] twoSum(int[] nums, int target) {
        Pair[] pairs = Pair.makePairs(nums);
        Arrays.sort(pairs, Pair.pairComparator);
        for (int i = 0; i < nums.length; i++) {
            int searchResult = Arrays.binarySearch(pairs, new Pair(target - nums[i], -1), Pair.pairComparator);
            if (searchResult >= 0) {
                int compIndex = pairs[searchResult].index;
                if (i != compIndex) return new int[]{i, compIndex};
            }
        }
        throw new IllegalArgumentException("The problem has bad input");
    }

    static class Pair {
        int value, index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        static Comparator<Pair> pairComparator = Comparator.comparingInt(p -> p.value);

        static Pair[] makePairs(int[] arr) {
            Pair[] pairs = new Pair[arr.length];
            for (int i = 0; i < arr.length; i++) {
                pairs[i] = new Pair(arr[i], i);
            }
            return pairs;
        }
    }
}
