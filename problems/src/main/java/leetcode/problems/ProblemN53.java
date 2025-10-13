package leetcode.problems;

import java.util.Arrays;

public class ProblemN53 {
    /*
    53. Maximum Subarray
    Medium, Topics: Array, Divide and Conquer, Dynamic Programming


    Given an integer array nums, find the subarray with the largest sum, and return its sum.

    Example 1:
    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: The subarray [4,-1,2,1] has the largest sum 6.

    Example 2:
    Input: nums = [1]
    Output: 1
    Explanation: The subarray [1] has the largest sum 1.

    Example 3:
    Input: nums = [5,4,-1,7,8]
    Output: 23
    Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

    Constraints:
            1 <= nums.length <= 10^5
            -10^4 <= nums[i] <= 10^4

Follow up: If you have figured out the O(n) solution,
try coding another solution using the divide and conquer approach, which is more subtle.
*/
    public static void main(String[] args) {
        System.out.println("Hello LeetCode #53. Maximum Subarray");
        System.out.println("Solution for example 1: " + maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println("Solution for example 2: " + maxSubArray(new int[]{1}));
        System.out.println("Solution for example 3: " + maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }

//    public static int maxSubArray(int[] nums) {
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            int tempSum = nums[i];
//            if (tempSum > max) max = tempSum;
//            for (int j = i+1; j < nums.length; j++) {
//                tempSum += nums[j];
//                if (tempSum > max) max = tempSum;
//            }
//        }
//        return max;
//    }

    public static int sumOfArray(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

//    public static int maxSubArray(int[] nums) {
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            int tempSum = nums[i];
//            if (tempSum > max) max = tempSum;
//            if (tempSum > 0) {
//                for (int j = i + 1; j < nums.length; j++) {
//                    tempSum += nums[j];
//                    if (nums[j] > 0) {
//                        if (tempSum > max) max = tempSum;
//                    }
//                }
//            }
//        }
//        return max;
//    }

//    public static int maxSubArray(int[] nums) {
//        int max = Integer.MIN_VALUE;
//        int currSum = nums[0];
//        if (currSum > max) max = currSum;
//        for (int i = 1; i < nums.length; i++) {
//            if ((currSum < 0) || (currSum + nums[i] < 0)) currSum = 0;
//            currSum += nums[i];
//            if (currSum > max) max = currSum;
//        }
//        return max;
//    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];

        int m = nums.length / 2;
        int[] leftArray = Arrays.copyOfRange(nums, 0, m);
        int[] rightArray = Arrays.copyOfRange(nums, m, nums.length);
        int leftMaxSubArray = maxSubArray(leftArray);
        int rightMaxSubArray = maxSubArray(rightArray);

        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = m - 1; i >= 0; i--) {
            currSum += nums[i];
            if (currSum > leftSum) leftSum = currSum;
        }
        currSum = 0;
        for (int j = m; j < nums.length; j++) {
            currSum += nums[j];
            if (currSum > rightSum) rightSum = currSum;
        }
        int crossMaxSubArray = leftSum + rightSum;
        int sideMax = (leftMaxSubArray > rightMaxSubArray) ? leftMaxSubArray : rightMaxSubArray;
        return (sideMax > crossMaxSubArray) ? sideMax : crossMaxSubArray;
    }

    private static int maxNum(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) max = num;
        }
        return max;
    }

}
