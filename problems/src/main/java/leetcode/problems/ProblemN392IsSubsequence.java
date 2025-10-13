package leetcode.problems;

public class ProblemN392IsSubsequence {
    /*  392. Is Subsequence
Easy,
Topics: Two Pointers, String, Dynamic Programming

Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string
by deleting some (can be none) of the characters without disturbing the relative positions
 of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).



Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false

Constraints:
    0 <= s.length <= 100
    0 <= t.length <= 10^4
    s and t consist only of lowercase English letters.


Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 10^9,
and you want to check one by one to see if t has its subsequence.
In this scenario, how would you change your code?  */

    public static void main(String[] args) {

        System.out.println("Hello LeetCode #605");
        String s = "abc", t = "ahbgdc";

        System.out.println("Solution for example 1: " + isSubsequence(s, t));
        System.out.println("Solution for example 1 is " +
                (isSubsequence(s, t) ? "***CORRECT***" : "!!! WRONG !!!"));

        s = "axc";
        t = "ahbgdc";
        System.out.println("Solution for example 2: " + isSubsequence(s, t));
        System.out.println("Solution for example 2 is " +
                (!isSubsequence(s, t) ? "***CORRECT***" : "!!! WRONG !!!"));

        s = "twn";
        t = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxtxxxxxxxxxxxxxxxxxxxxwxxxxxxxxxxxxxxxxxxxxxxxxxn";
        System.out.println("Solution for test 16: " + isSubsequence(s, t));
        System.out.println("Solution for test 16 is " +
                (isSubsequence(s, t) ? "***CORRECT***" : "!!! WRONG !!!"));

        s = "";
        t = "";
        System.out.println("Solution for test 17: " + isSubsequence(s, t));
        System.out.println("Solution for test 17 is " +
                (isSubsequence(s, t) ? "***CORRECT***" : "!!! WRONG !!!"));

        s = "aaaaaa";
        t = "bbaaaa";
        System.out.println("Solution for test 18: " + isSubsequence(s, t));
        System.out.println("Solution for test 18 is " +
                (!isSubsequence(s, t) ? "***CORRECT***" : "!!! WRONG !!!"));
    }

    // O(2^tn⋅tn) bitmasking
/*    public static boolean isSubsequence(String s, String t) {
        int sn = s.length();
        int tn = t.length();
        if (sn > tn) {
            return false;
        }
        for (int mask = 0; mask < (1 << tn); mask++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < tn; j++) {
                if (((1 << j) & mask) != 0) {
                    sb.append(t.charAt(j));
                }
            }
            if (sb.toString().equals(s)){
                return true;
            }
        }
        return false;
    } */

    /* // O(tn) - time, O(1) - space
    public static boolean isSubsequence(String s, String t) {
        int sn = s.length();
        int tn = t.length();
        if (sn > tn) {
            return false;
        }
        int left = 0, right = 0;
        while (left < sn && right < tn) {
            char sc = s.charAt(left);
            while (right < tn && sc != t.charAt(right)) right++;
            if (right == tn) {
                return false;
            }
            left++;
            right++;
        }
        return left == sn;
    }
     */

    public static boolean isSubsequence(String s, String t) {
        int sn = s.length();
        int tn = t.length();
        if (sn > tn) {
            return false;
        }
        int left = 0, right = 0;
        while (left < sn && right < tn) {
            if (s.charAt(left) == t.charAt(right)) left++;
            right++;
        }
        return left == sn;
    }


}
