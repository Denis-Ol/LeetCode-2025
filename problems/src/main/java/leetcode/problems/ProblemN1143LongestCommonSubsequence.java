package leetcode.problems;

public class ProblemN1143LongestCommonSubsequence {
    /*
    1143. Longest Common Subsequence
    Medium, Topics: String, Dynamic Programming

    Given two strings text1 and text2, return the length of their longest common subsequence.
    If there is no common subsequence, return 0.

    A subsequence of a string is a new string generated from the original string
    with some characters (can be none) deleted without changing
    the relative order of the remaining characters.

    For example, "ace" is a subsequence of "abcde".

    A common subsequence of two strings is a subsequence that is common to both strings.

    Example 1:
    Input: text1 = "abcde", text2 = "ace"
    Output: 3
    Explanation: The longest common subsequence is "ace" and its length is 3.

    Example 2:
    Input: text1 = "abc", text2 = "abc"
    Output: 3
    Explanation: The longest common subsequence is "abc" and its length is 3.

    Example 3:
    Input: text1 = "abc", text2 = "def"
    Output: 0
    Explanation: There is no such common subsequence, so the result is 0.

    Constraints:
        1 <= text1.length, text2.length <= 1000
        text1 and text2 consist of only lowercase English characters. */
    public static void main(String[] args) {
        System.out.println("Hello LeetCode #1143. Longest Common Subsequence");
        System.out.println("Solution for example 1: " + longestCommonSubsequence("abcde", "ace"));
        System.out.println("Solution for example 1 is " +
                ((longestCommonSubsequence("abcde", "ace") == 3) ? "***CORRECT***" : "!!! WRONG !!!"));

        System.out.println("Solution for example 2: " + longestCommonSubsequence("abc", "abc"));
        System.out.println("Solution for example 2 is " +
                ((longestCommonSubsequence("abc", "abc") == 3) ? "***CORRECT***" : "!!! WRONG !!!"));

        System.out.println("Solution for example 3: " + longestCommonSubsequence("abc", "def"));
        System.out.println("Solution for example 3 is " +
                ((longestCommonSubsequence("abc", "def") == 0) ? "***CORRECT***" : "!!! WRONG !!!"));

        System.out.println("Solution for test 24: " + longestCommonSubsequence("abcba", "abcbcba"));
        System.out.println("Solution for test 24 is " +
                ((longestCommonSubsequence("abcba", "abcbcba") == 5) ? "***CORRECT***" : "!!! WRONG !!!"));

    }
/*
//  top-down approach
    public static int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        int[][] memo = new int[length1][length2];
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                memo[i][j] = -1;
            }
        }
        return lCS(text1, length1 - 1, text2, length2 - 1, memo);
    }

    public static int lCS(String text1, int end1, String text2, int end2, int[][] memo) {
        if (end1 < 0 || end2 < 0) {
            return 0;
        }
        if (memo[end1][end2] != -1) {
            return memo[end1][end2];
        }
        int result;
        if (text1.charAt(end1) == text2.charAt(end2)) {
            result = 1 + lCS(text1, end1 - 1, text2, end2 - 1, memo);
        } else {
            result = Math.max(lCS(text1, end1, text2, end2 - 1, memo),
                    lCS(text1, end1 - 1, text2, end2, memo));
        }
        memo[end1][end2] = result;
        return memo[end1][end2];
    }*/

    /*
//    bottom-up dp[][] matrix
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }*/

/*
//    bottom-up 2 int[]
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[] prev = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int[] curr = new int[n + 1];
            for (int j = 1; j <= n; j++) {

                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(curr[j - 1], prev[j]);
                }
            }
            prev = curr;
        }
        return prev[n];
    }*/

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int diagonal = 0;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = diagonal + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                diagonal = temp;
            }
        }
        return dp[n];
    }

}
