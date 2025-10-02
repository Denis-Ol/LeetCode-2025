package leetcode.problems;

public class ProblemN516LongestPalindromicSubsequence {
    /* 516. Longest Palindromic Subsequence
Medium, Topics: String, Dynamic Programming

Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence
by deleting some or no elements without changing the order of the remaining elements.

Example 1:
Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".

Example 2:
Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".

Constraints:
    1 <= s.length <= 1000
    s consists only of lowercase English letters. */

    public static void main(String[] args) {
        System.out.println("Hello LeetCode #516. Longest Palindromic Subsequence");
        System.out.println("Solution for example 1: " + longestPalindromeSubseq("bbbab"));
        System.out.println("Solution for example 1 is " +
                ((longestPalindromeSubseq("bbbab") == 4) ? "***CORRECT***" : "!!! WRONG !!!"));

        System.out.println("Solution for example 2: " + longestPalindromeSubseq("cbbd"));
        System.out.println("Solution for example 2 is " +
                ((longestPalindromeSubseq("cbbd") == 2) ? "***CORRECT***" : "!!! WRONG !!!"));

    }

//    public static int longestPalindromeSubseq(String s) {
//        int n = s.length();
//        int[][] dp = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            dp[i][i] = 1;
//        }
//        for (int len = 2; len <= n; len++) {
//            for (int i = 0; i <= n - len; i++) {
//                int j = len + i - 1;
//                if (s.charAt(i) == s.charAt(j)) {
//                    dp[i][j] = 2 + dp[i + 1][j - 1];
//                } else {
//                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
//                }
//            }
//        }
//        return dp[0][n - 1];
//    }


//    public static int longestPalindromeSubseq(String s) {
//        int n = s.length();
//        if (n == 1) {
//            return 1;
//        }
//        int[] first = new int[n];
//        int[] second = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            first[i] = 1;
//        }
//
//        for (int i = 0; i < n - 1; i++) {
//            if (s.charAt(i) == s.charAt(i + 1)) {
//                second[i] = 2;
//            } else {
//                second[i] = 1;
//            }
//        }
//
//        for (int len = 3; len <= n; len++) {
//            int[] current = new int[n];
//            for (int i = 0; i <= n - len; i++) {
//                int j = i + len - 1;
//
//                if (s.charAt(i) == s.charAt(j)) {
//                    current[i] = 2 + first[i + 1];
//                } else {
//                    current[i] = Math.max(second[i], second[i + 1]);
//                }
//
//            }
//            first = second.clone();
//            second = current.clone();
//        }
//        return second[0];
//    }


/*
    public static int longestPalindromeSubseq(String s) {
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            String candidate = queue.poll();
            int length = candidate.length();
            if (isPalindrome(candidate)) {
                return length;
            }
            for (int i = 0; i < length; i++) {
                String nextSubseq = candidate.substring(0, i) + candidate.substring(i + 1);
                if (!visited.contains(nextSubseq)) {
                    queue.offer(nextSubseq);
                    visited.add(nextSubseq);
                }
            }
        }
        return 0;
    }

    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
 */

    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        if (n == 1) {
            return 1;
        }
        int[][] memo = new int[n][n];
        return findLPS(s, 0, n - 1, memo);
    }

    private static int findLPS(String s, int i, int j, int[][] memo) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int result;
        if (s.charAt(i) == s.charAt(j)) {
            result = 2 + findLPS(s, i + 1, j - 1, memo);
        } else {
            result = Math.max(findLPS(s, i + 1, j, memo), findLPS(s, i, j - 1, memo));
        }
        memo[i][j] = result;
        return result;
    }
}
