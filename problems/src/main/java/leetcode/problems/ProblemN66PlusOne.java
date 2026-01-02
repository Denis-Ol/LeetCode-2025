package leetcode.problems;

import java.util.Arrays;

public class ProblemN66PlusOne {
    /* 66. Plus One
Easy,Topics: Array, Math

You are given a large integer represented as an integer array digits, 
where each digits[i] is the ith digit of the integer. The digits are 
ordered from most significant to least significant in left-to-right order. 
The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

Example 1:
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].

Example 2:
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].

Example 3:
Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].

Constraints:
    1 <= digits.length <= 100
    0 <= digits[i] <= 9
    digits does not contain any leading 0's. */

    public static void main(String[] args) {
        System.out.println("Hello LeetCode #66. Plus One");
        int[] digits1 = {1, 2, 3};
        int[] res1 = plusOne(digits1);
        System.out.println("Solution for example 1: " + Arrays.toString(res1));
        System.out.println("Solution for example 1 is " +
                (Arrays.equals(res1, new int[]{1, 2, 4}) ? "***CORRECT***" : "!!! WRONG !!!"));

        int[] digits2 = {4, 3, 2, 1};

        int[] res2 = plusOne(digits2);
        System.out.println("Solution for example 2: " + Arrays.toString(res2));
        System.out.println("Solution for example 2 is " +
                (Arrays.equals(res2, new int[]{4, 3, 2, 2}) ? "***CORRECT***" : "!!! WRONG !!!"));

        int[] digits3 = {9};
        int[] res3 = plusOne(digits3);
        System.out.println("Solution for example 3: " + Arrays.toString(res3));
        System.out.println("Solution for example 3 is " +
                (Arrays.equals(res3, new int[]{1, 0}) ? "***CORRECT***" : "!!! WRONG !!!"));
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        if (digits[n - 1] < 9) {
            digits[n - 1] += 1;
            return digits;
        }
        int i = n - 2;
        while (i >= 0 && digits[i] == 9) i--;

        if (i == -1) {// all 9s => +1 digit, 10..0
            int res[] = new int[n + 1];
            res[0] = 1;
            return res;
        }
        // ends on 9s, i - last non-9
        digits[i] += 1;
        for (int j = i + 1; j < n; j++) {
            digits[j] = 0;
        }
        return digits;
    }
}
