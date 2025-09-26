package leetcode.problems;

public class ProblemN704 {
    /*
    704. Binary Search
Easy, Topics: Array, Binary Search

Given an array of integers nums which is sorted in ascending order, and an integer target,
write a function to search target in nums.
If target exists, then return its index.
Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.



Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

Constraints:
    1 <= nums.length <= 10^4
    -10^4 < nums[i], target < 10^4
    All the integers in nums are unique.
    nums is sorted in ascending order.

*/
    public static void main(String[] args) {
        ProblemN704 problemN704 = new ProblemN704();
        System.out.println("Hello LeetCode #704. Binary Search");
        System.out.println("Solution for example 1: " + problemN704.search(new int[]{-1, 0, 3, 5, 9, 12}, 9) + ", expected - \"4\"");
        System.out.println("Solution for example 2: " + problemN704.search(new int[]{-1, 0, 3, 5, 9, 12}, 2) + ", expected - \"-1\"");
        System.out.println("Solution for example 3: " + problemN704.search(new int[]{-1, 0, 5}, 2) + ", expected - \"-1\"");
        System.out.println("Solution for example 4: " + problemN704.search(new int[]{2, 5}, 0) + ", expected - \"-1\"");
        System.out.println("Solution for example 5: " + problemN704.search(new int[]{2}, 0) + ", expected - \"-1\"");
        System.out.println("Solution for example 6: " + problemN704.search(new int[]{2}, 2) + ", expected - \"0\"");

    }

    //    public int search(int[] nums, int target) {
//        if (nums.length == 1) {
//            return (nums[0] == target) ? 0 : -1;
//        } else {
//            int mid = nums.length / 2;
//            if (target < nums[mid]) {
//                return search2(nums, target,0,mid-1);
//            } else if (nums[mid] < target) {
//                return search2(nums, target,mid+1, nums.length-1);
//            } else return mid;
//        }
//    }

//    public int search(int[] nums, int target) {
//        return search2(nums, target, 0, nums.length - 1);
//    }

//    public int search(int[] nums, int target) {
//        int result = Arrays.binarySearch(nums, target);
//        return result < -1 ? -1 : result;
//    }

    public int search(int[] nums, int target) {
//        if (nums.length == 1) {
//            return (nums[0] == target) ? 0 : -1;
//        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) right = mid - 1;
            else if (nums[mid] < target) left = mid + 1;
            else return mid;
        }
        return -1;
    }

    private static int search2(int[] nums, int target, int left, int right) {
        if (left == right) return (nums[left] == target) ? left : -1;
        else if (left > right) {
            return -1;
        } else {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                return search2(nums, target, left, mid - 1);
            } else if (nums[mid] < target) {
                return search2(nums, target, mid + 1, right);
            } else return mid;
        }
    }
}
