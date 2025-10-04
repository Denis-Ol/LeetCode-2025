package leetcode.problems;

import leetcode.util.Utils;

import java.io.IOException;

public class ProblemN680ValidPalindrome2 {
/* 680. Valid Palindrome II
Easy,Topics: Two Pointers, String, Greedy

Given a string s, return true if the s can be palindrome after deleting at most one character from it.

Example 1:
Input: s = "aba"
Output: true

Example 2:
Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.

Example 3:
Input: s = "abc"
Output: false

Constraints:
        1 <= s.length <= 10^5
s consists of lowercase English letters. */

    public static void main(String[] args) throws IOException {
        System.out.println("Hello LeetCode #9. Palindrome Number");
        System.out.println("Solution for example 1: " + validPalindrome("aba"));
        System.out.println("Solution for example 1 is " +
                (validPalindrome("aba") ? "***CORRECT***" : "!!! WRONG !!!"));

        System.out.println("Solution for example 2: " + validPalindrome("abca"));
        System.out.println("Solution for example 2 is " +
                (validPalindrome("abca") ? "***CORRECT***" : "!!! WRONG !!!"));

        System.out.println("Solution for example 3: " + validPalindrome("abc"));
        System.out.println("Solution for example 3 is " +
                (!validPalindrome("abc") ? "***CORRECT***" : "!!! WRONG !!!"));

        String s = Utils.readFileToString("/680test427.txt");
        System.out.println("Solution for test 427: " + validPalindrome(s));
    }

    /*
//    Brute-force
    public static boolean validPalindrome(String s) {
        if (isPalindrome(s)) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            String newString = s.substring(0, i) + s.substring(i + 1);
            if (isPalindrome(newString)) {
                return true;
            }
        }
        return false;
    }
*/
    private static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                String subWithoutI = s.substring(i + 1, j + 1);
                String subWithoutJ = s.substring(i, j);
                if (isPalindrome(subWithoutI) || isPalindrome(subWithoutJ)) {
                    return true;
                } else {
                    return false;
                }
            }
            i++;
            j--;
        }
        return true;
    }

}
