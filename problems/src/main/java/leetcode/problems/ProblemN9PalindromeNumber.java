package leetcode.problems;

public class ProblemN9PalindromeNumber {
    /*9. Palindrome Number
Easy, Topics: Math,

Given an integer x, return true if x is a palindrome, and false otherwise.
An integer is a palindrome when it reads the same forward and backward.
For example, 121 is a palindrome while 123 is not.

        Example 1:
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

        Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-.
Therefore it is not a palindrome.

Example 3:
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Constraints:-2^31 <= x <= 2^31 - 1

Follow up: Could you solve it without converting the integer to a string?  */

    public static void main(String[] args) {
        System.out.println("Hello LeetCode #9. Palindrome Number");
        System.out.println("Solution for example 1: " + isPalindrome(121));
        System.out.println("Solution for example 1 is " +
                (isPalindrome(121) ? "***CORRECT***" : "!!! WRONG !!!"));

        System.out.println("Solution for example 2: " + isPalindrome(-121));
        System.out.println("Solution for example 2 is " +
                (!isPalindrome(-121) ? "***CORRECT***" : "!!! WRONG !!!"));

        System.out.println("Solution for example 3: " + isPalindrome(10));
        System.out.println("Solution for example 3 is " +
                (!isPalindrome(10) ? "***CORRECT***" : "!!! WRONG !!!"));
        System.out.println("22 =" + isPalindrome(22));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int dim = 2;
        int rem = x / 10;
        while (rem > 9) {
            rem /= 10;
            dim += 1;
        }

        int first = rem;
        int last = x % 10;

        while (dim > 1) {
            if (first != last) {
                return false;
            }
            x = (int) (x % Math.pow(10, dim - 1));
            x /= 10;
            dim = dim - 2;
            first = (int) (x / Math.pow(10, dim - 1));
            last = x % 10;
        }
        return true;
    }
}
