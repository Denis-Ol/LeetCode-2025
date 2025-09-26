package leetcode.problems;

import leetcode.util.Utils;

import java.io.IOException;
import java.util.Random;

public class ProblemN215KthLargestElementInAnArray {
/* 215. Kth Largest Element in an Array

Medium, Topics: Array, Divide and Conquer, Sorting, Heap (Priority Queue), Quickselect

Given an integer array nums and an integer k,
return the kth largest element in the array.

Note that it is the kth largest element in the sorted order,
not the kth distinct element.

Can you solve it without sorting?

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

Constraints:
        1 <= k <= nums.length <= 10^5
        -10^4 <= nums[i] <= 10^4  */

    public static void main(String[] args) throws IOException {
        System.out.println("Hello LeetCode #215. Kth Largest Element in an Array");
        System.out.println("Solution for example 1: " + findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println("Solution for example 1 is " +
                ((findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2) == 5) ? "***CORRECT***" : "!!! WRONG !!!"));

        System.out.println("Solution for example 2: " + findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        System.out.println("Solution for example 2 is " +
                ((findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4) == 4) ? "***CORRECT***" : "!!! WRONG !!!"));

        int[] nums37 = Utils.readCommaSeparatedInts("/215nums37.txt");
        System.out.println("Solution for test 37: " + findKthLargest(nums37, 15952));
        System.out.println("Solution for test 37 is " +
                ((findKthLargest(nums37, 15952) == -115) ? "***CORRECT***" : "!!! WRONG !!!"));

        int[] nums43 = Utils.readCommaSeparatedInts("/215nums43.txt");
        System.out.println("Solution for test 43: " + findKthLargest(nums43, 50000));
        System.out.println("Solution for test 43 is " +
                ((findKthLargest(nums43, 50000) == 1) ? "***CORRECT***" : "!!! WRONG !!!"));

    }

// Using max-heap PriorityQueue<Integer>
//    public static int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
//        for (int element : nums) {
//            maxHeap.offer(element);
//        }
//        for (int i = 0; i < k - 1; i++) {
//            maxHeap.poll();
//        }
//        return maxHeap.poll();
//    }

// brute force O(k*n)
//    public static int findKthLargest(int[] nums, int k) {
//        int max = Integer.MIN_VALUE;
//        int maxIndex = 0;
//        for (int i = 0; i < k; i++) {
//            max = Integer.MIN_VALUE;
//            for (int j = 0; j < nums.length; j++) {
//                if (max < nums[j]) {
//                    max = nums[j];
//                    maxIndex = j;
//                }
//            }
//            nums[maxIndex] = Integer.MIN_VALUE;
//        }
//        return max;
//    }

    //min-heap impl PriorityQueue<Integer>
//    public static int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k + 1);
//        for (int element : nums) {
//            minHeap.offer(element);
//            if (minHeap.size() > k) minHeap.poll();
//        }
//        return minHeap.poll();
//    }


    //    /**
//     * Lomuto's approach - too slow for test 43
//     */
//    public static int partition(int[] nums, int start, int end, int pivotIndex) {
//        int pivot = nums[pivotIndex];
//        swap(nums, pivotIndex, end);
//
//        int i = start;
//        for (int j = start; j < end; j++) {
//            if (nums[j] < pivot) {
//                swap(nums, i, j);
//                i++;
//            }
//        }
//        swap(nums, i, end);
//        return i;
//    }
//
//    public static int findKthLargest(int[] nums, int k) {
//        int start = 0;
//        int end = nums.length - 1;
//        int targetIndex = nums.length - k;
//        while (true) {
//            if (start == end) {
//                return nums[start];
//            }
//            int pivotIndex = random.nextInt(end - start + 1) + start;
//            pivotIndex = partition(nums, start, end, pivotIndex);
//            if (pivotIndex == targetIndex) {
//                return nums[pivotIndex];
//            } else if (targetIndex < pivotIndex) {
//                end = pivotIndex - 1;
//            } else {
//                start = pivotIndex + 1;
//            }
//        }
//    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Hoare's quickselect
     */
    public static int partition(int[] nums, int start, int end, int pivotIndex) {
        int pivot = nums[pivotIndex];
        int left = start - 1;
        int right = end + 1;
        while (true) {
            do left++; while (nums[left] < pivot);
            do right--; while (nums[right] > pivot);
            if (left >= right) {
                return right;
            }
            swap(nums, left, right);
        }
    }

    private static final Random random = new Random();

    public static int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        int targetIndex = nums.length - k;
        while (start < end) {
            int pivotIndex = random.nextInt(end - start + 1) + start;
            pivotIndex = partition(nums, start, end, pivotIndex);
            if (targetIndex <= pivotIndex) {
                end = pivotIndex;
            } else {
                start = pivotIndex + 1;
            }
        }
        return nums[start];
    }

}