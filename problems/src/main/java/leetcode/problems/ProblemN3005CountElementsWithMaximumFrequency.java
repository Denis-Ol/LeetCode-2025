package leetcode.problems;

public class ProblemN3005CountElementsWithMaximumFrequency {
/* 3005. Count Elements With Maximum Frequency
            Easy
Topics: Array, Hash Table, Counting

You are given an array nums consisting of positive integers.

Return the total frequencies of elements in nums such that
those elements all have the maximum frequency.

The frequency of an element is the number of occurrences of that element in the array.

Example 1:
Input: nums = [1,2,2,3,1,4]
Output: 4
Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum frequency in the array.
So the number of elements in the array with maximum frequency is 4.

Example 2:
Input: nums = [1,2,3,4,5]
Output: 5
Explanation: All elements of the array have a frequency of 1 which is the maximum.
So the number of elements in the array with maximum frequency is 5.

Constraints:

        1 <= nums.length <= 100
        1 <= nums[i] <= 100 */

    public static void main(String[] args) {
        System.out.println("Hello LeetCode #3005. Count Elements With Maximum Frequency");

        System.out.println("Solution for example 1: " + maxFrequencyElements(new int[]{1, 2, 2, 3, 1, 4}));
        System.out.println("Solution for example 1 is " +
                ((maxFrequencyElements(new int[]{1, 2, 2, 3, 1, 4}) == 4) ? "***CORRECT***" : "!!! WRONG !!!"));

        System.out.println("Solution for example 2: " + maxFrequencyElements(new int[]{1, 2, 3, 4, 5}));
        System.out.println("Solution for example 2 is " +
                ((maxFrequencyElements(new int[]{1, 2, 3, 4, 5}) == 5) ? "***CORRECT***" : "!!! WRONG !!!"));

    }
/*
    public static int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>(nums.length);
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for (int value: freqMap.values()){
            if (value > max) max = value;
        }
        int count = 0;
        for (int value: freqMap.values()){
            if (value == max) count+=value;
        }
        return count;
    }*/

    /*
    // Map
    public static int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>(nums.length);
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int max = 0, count = 0;
        for (int value : freqMap.values()) {
            if (value > max) {
                max = value;
                count = value;
            } else if (value == max) count += value;
        }
        return count;
    }*/
// int[] as frequency map
    public static int maxFrequencyElements(int[] nums) {
        int[] freqArray = new int[101];
        for (int num : nums) {
            freqArray[num]++;
        }
        int max = 0, count = 0;
        for (int value : freqArray) {
            if (value > max) {
                max = value;
                count = value;
            } else if (value == max) count += value;
        }
        return count;
    }

}
