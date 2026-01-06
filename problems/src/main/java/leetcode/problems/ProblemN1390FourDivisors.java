package leetcode.problems;

public class ProblemN1390FourDivisors {

    /* 1390. Four Divisors
    Medium, Topics: Array, Math

    Given an integer array nums, return the sum of divisors of the integers in that array
    that have exactly four divisors.
    If there is no such integer in the array, return 0.

    Example 1:
    Input: nums = [21,4,7]
    Output: 32
    Explanation:
    21 has 4 divisors: 1, 3, 7, 21
    4 has 3 divisors: 1, 2, 4
    7 has 2 divisors: 1, 7
    The answer is the sum of divisors of 21 only.

    Example 2:
    Input: nums = [21,21]
    Output: 64

    Example 3:
    Input: nums = [1,2,3,4,5]
    Output: 0

    Constraints:
        1 <= nums.length <= 104
        1 <= nums[i] <= 105


     */
    public static void main(String[] args) {
        System.out.println("Hello LeetCode #1390. Four Divisors");
        int[] nums1 = {21, 4, 7};
        System.out.println("Solution for example 1: " + sumFourDivisors(nums1));
        System.out.println("Solution for example 1 is " +
                (sumFourDivisors(nums1) == 32 ? "***CORRECT***" : "!!! WRONG !!!"));

        int[] nums2 = {21, 21};
        System.out.println("Solution for example 2: " + sumFourDivisors(nums2));
        System.out.println("Solution for example 2 is " +
                (sumFourDivisors(nums2) == 64 ? "***CORRECT***" : "!!! WRONG !!!"));

        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println("Solution for example 3: " + sumFourDivisors(nums3));
        System.out.println("Solution for example 3 is " +
                (sumFourDivisors(nums3) == 0 ? "***CORRECT***" : "!!! WRONG !!!"));
    }

    // 1 and n are divisors.
    // brute force, but smart: adding both divisors, checking count number
    /*public static int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            int temp = 1 + num;
            int count = 2;
            for (int i = 2; i * i <= num && count <= 4; i++) {
                if (num % i == 0) {
                    temp += i;
                    count++;
                    if (num != i * i) {
                        temp += num / i;
                        count++;
                    }
                }
            }
            if (count == 4) {
                sum += temp;
            }
        }
        return sum;
    }*/

    // adding memoization, hashmap
   /* public static int sumFourDivisors(int[] nums) {
        int sum = 0;
        var map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                sum += map.get(num);
                continue;
            }
            int temp = 1 + num;
            int count = 2;
            for (int i = 2; i * i <= num && count <= 4; i++) {
                if (num % i == 0) {
                    temp += i;
                    count++;
                    if (num != i * i) {
                        temp += num / i;
                        count++;
                    }
                }
            }
            if (count == 4) {
                sum += temp;
                map.put(num, temp);
            } else map.put(num, 0);
        }
        return sum;
    }*/

    // adding memoization, int[100001]
    public static int sumFourDivisors(int[] nums) {
        int sum = 0;
        int[] cache = new int[100001];
        for (int num : nums) {
            int val = cache[num];
            if (val != 0) {
                if (val > 0) sum += val;
                continue;
            }
            int temp = 1 + num;
            int count = 2;
            for (int i = 2; i * i <= num && count <= 4; i++) {
                if (num % i == 0) {
                    temp += i;
                    count++;
                    if (num != i * i) {
                        temp += num / i;
                        count++;
                    }
                }
            }
            if (count == 4) {
                sum += temp;
                cache[num] = temp;
            } else cache[num] = -1;
        }
        return sum;
    }
}



