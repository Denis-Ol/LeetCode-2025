public class ProblemN125ValidPalindrome {
    /*88. 125. Valid Palindrome
Easy, Topics: Two Pointers, String

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
and removing all non-alphanumeric characters, it reads the same forward and backward.
Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.


Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

Constraints:
    1 <= s.length <= 2 * 105
    s consists only of printable ASCII characters. */

    public static void main(String[] args) {
        System.out.println("Hello LeetCode #125. Valid Palindrome\n");
        System.out.println("Solution for example 1: " + isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("Solution for example 1 is " +
                ((isPalindrome("A man, a plan, a canal: Panama")) ? "***CORRECT***" : "!!! WRONG !!!"));


    }
    /* 0 - 48, 9 - 57
    A - 65, Z - 90
    a - 97, z - 122
    97 - 65 = 32
     */

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            while (!isCharValid(leftChar) && left < right) {
                leftChar = s.charAt(++left);
            }
            char rightChar = s.charAt(right);
            while (!isCharValid(rightChar) && left < right) {
                rightChar = s.charAt(--right);
            }
            if (left != right) {
                if ((('A' <= leftChar) && (leftChar <= 'Z'))) {
                    leftChar = (char) (leftChar + 32);
                }
                if ((('A' <= rightChar) && (rightChar <= 'Z'))) {
                    rightChar = (char) (rightChar + 32);
                }
            }
            if (leftChar != rightChar) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isCharValid(char c) {
        return (('0' <= c) && (c <= '9')) || (('A' <= c) && (c <= 'Z')) || (('a' <= c) && (c <= 'z'));
    }


}
