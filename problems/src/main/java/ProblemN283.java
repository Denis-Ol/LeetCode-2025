import java.util.Arrays;

public class ProblemN283 {
    /*
    283. Move Zeroes
Easy, Topics: Array, Two Pointers

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]

Constraints:
    1 <= nums.length <= 10^4
    -2^31 <= nums[i] <= 2^31 - 1

Follow up: Could you minimize the total number of operations done?
*/
    public static void main(String[] args) {
        System.out.println("Hello LeetCode #283");
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println("Solution for example 1: " + Arrays.toString(nums));
        nums = new int[]{0};
        moveZeroes(nums);
        System.out.println("Solution for example 2: " + Arrays.toString(nums));
        nums = new int[]{1};
        moveZeroes(nums);
        System.out.println("Solution for example 3: " + Arrays.toString(nums));
        nums = new int[]{1, 0};
        moveZeroes(nums);
        System.out.println("Solution for example 4: " + Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int length = nums.length;
        int zero = 0;
        int nonZero = 0;
        while (nonZero < length && zero < length) {
            while (zero < length && nums[zero] != 0) {
                ++zero;
            }
            if (zero < length) {
                nonZero = zero;
                while (nonZero < length && nums[nonZero] == 0) {
                    ++nonZero;
                }
                if (nonZero < length) {
                    nums[zero++] = nums[nonZero];
                    nums[nonZero++] = 0;
                }
            }
        }
    }
}
