package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

public class ProblemN283MoveZeroes {
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
        System.out.println("Hello LeetCode #283 Move Zeroes");
    }

//    public static void moveZeroes(int[] nums) {
//        Integer[] numsInteger = Arrays.stream(nums)
//                .boxed()
//                .toArray(Integer[]::new);
//
//        Arrays.sort(numsInteger, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer p1, Integer p2) {
//                if (p1 == 0 || p2 == 0) {
//                    return Integer.compare(Math.abs(p2), Math.abs(p1));
//                }
//                return 0;
//            }
//        });
//
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = numsInteger[i];
//        }
//    }

    public static void moveZeroes(int[] nums) {
        Integer[] numsInteger = Arrays.stream(nums)
                .boxed()
                .toArray(Integer[]::new);

        Arrays.sort(numsInteger, Comparator.comparing(x -> x == 0));

        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsInteger[i];
        }
    }


//    static {
//        for (int i = 0; i < 100; i++)
//            moveZeroes(new int[]{0, 0});
//    }

//    public static void moveZeroes(int[] nums) {
//        int length = nums.length;
//        int zero = 0;
//        int nonZero = 0;
//        while (nonZero < length && zero < length) {
//            while (zero < length && nums[zero] != 0) {
//                ++zero;
//            }
//            if (zero < length) {
//                nonZero = zero;
//                while (nonZero < length && nums[nonZero] == 0) {
//                    ++nonZero;
//                }
//                if (nonZero < length) {
//                    nums[zero++] = nums[nonZero];
//                    nums[nonZero++] = 0;
//                }
//            }
//        }
//    }


//    public static void moveZeroes(int[] nums) {
//        int left = 0; // Pointer for placing non-zero elements
//
//// Iterate with right pointer
//        for (int right = 0; right < nums.length; right++) {
//            if (nums[right] != 0) {

    /// / Swap elements if right pointer finds a non-zero
//                if (left != right) {
//                    nums[left] = nums[right];
//                    nums[right] = 0;
//                }
//                left++; // Move left pointer forward
//            }
//        }
//
//
//    }

//    public static void moveZeroes(int[] nums) {
//        int left = 0; // Pointer for placing non-zero elements
//        int right = 0; // Pointer for iterating through the array
//
//        // Iterate with right pointer
//        // The loop continues as long as the right pointer is within the array bounds
//        while (right < nums.length) {
//            if (nums[right] != 0) {
//                // If the element at 'right' is non-zero, it needs to be moved to the 'left' position.
//                // We only perform the assignments if 'left' and 'right' pointers are not at the same position.
//                // This avoids unnecessary self-assignments when the non-zero element is already in its correct sorted place.
//                if (left != right) {
//                    nums[left] = nums[right]; // Move non-zero element to the 'left' pointer's position
//                    nums[right] = 0;          // Set the 'right' pointer's original position to zero
//                }
//                left++; // Increment 'left' pointer to indicate the next position for a non-zero element
//            }
//            right++; // Always increment 'right' pointer to move to the next element
//        }
//    }
//    public static void moveZeroes(int[] nums) {
//        int n = nums.length;
//        int i = 0, j = 0;
//        while (i < n) {
//            if (nums[i] != 0) {
//                nums[j] = nums[i];
//                j++;
//            }
//            i++;
//        }
//
//        while (j < n) {
//            nums[j] = 0;
//            j++;
//        }
//    }

}
/**
 * --------------------------------------------------------------------
 * *Why the Code Appears Faster After Static Block Execution**
 * <p>
 * This summary explains why invoking the `findMaxConsecutiveOnes()` method multiple times in a static block makes subsequent executions of the method faster.
 * <p>
 * ---
 * <p>
 * ### 1. JIT Warm-up (Just-In-Time Compilation)
 * <p>
 * The JVM uses a Just-In-Time (JIT) compiler to optimize frequently used methods ("hot" code paths).
 * Repeatedly calling `findMaxConsecutiveOnes()` during class loading warms up the JIT.
 * Once the method is JIT-compiled, future calls execute faster.
 * Without this warm-up, the method runs in interpreted mode, which is slower.
 * <p>
 * ---
 * <p>
 * ### 2. CPU Cache Warming
 * <p>
 * Repetitive execution of the method helps warm up CPU instruction caches (I-cache).
 * This leads to better cache hits and reduced latency when the method is actually benchmarked or tested.
 * <p>
 * ---
 * <p>
 * ### 3. Memory Allocation Stabilization
 * <p>
 * Initial executions may involve overhead from garbage collection (GC), object allocation, or class loading.
 * By warming up in advance, these overheads are minimized during actual measurement.
 * <p>
 * ---
 * <p>
 * *Conclusion**: The perceived speedup isn't due to algorithmic improvements but rather JVM and CPU-level optimizations triggered by early repeated executions.
 * -------------------------------------------------------------------------------
 */