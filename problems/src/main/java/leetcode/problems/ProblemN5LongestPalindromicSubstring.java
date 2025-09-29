package leetcode.problems;

import java.io.IOException;


public class ProblemN5LongestPalindromicSubstring {
/* 5. Longest Palindromic Substring
Medium, Topics: Two Pointers, String, Dynamic Programming

Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters. */

    public static void main(String[] args) throws IOException {
        System.out.println("Hello LeetCode #5. Longest Palindromic Substring");
//        System.out.println("Solution for example 1: " + longestPalindrome("babad"));
        System.out.println("Solution for example 1 is " +
                ((longestPalindrome("babad").equals("bab") || (longestPalindrome("babad").equals("aba"))
                        ? "***CORRECT***" : "!!! WRONG !!!")));

//        System.out.println("Solution for example 2: " + longestPalindrome("cbbd"));
        System.out.println("Solution for example 2 is " +
                ((longestPalindrome("cbbd").equals("bb")) ? "***CORRECT***" : "!!! WRONG !!!"));

//        System.out.println("Solution for example 3: " + longestPalindrome("ac"));
        System.out.println("Solution for example 3 is " +
                ((longestPalindrome("ac").equals("a") || longestPalindrome("ac").equals("c")) ? "***CORRECT***" : "!!! WRONG !!!"));

//        System.out.println("Solution for example 4: " + longestPalindrome("ccc"));
        System.out.println("Solution for example 4 is " +
                ((longestPalindrome("ccc").equals("ccc")) ? "***CORRECT***" : "!!! WRONG !!!"));

//        System.out.println("Solution for test 26: " + longestPalindrome("abcba"));
        System.out.println("Solution for test 26 is " +
                ((longestPalindrome("abcba").equals("abcba")) ? "***CORRECT***" : "!!! WRONG !!!"));

        String s92 = "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        System.out.println("Solution for test 92 is " +
                ((longestPalindrome(s92).equals(s92) ? "***CORRECT***" : "!!! WRONG !!!")));

//        String s95 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
//                "bcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//        System.out.println("Solution for test 95: " + longestPalindrome(s95));
    }

    //
//
//    public static String longestPalindrome(String s) {
//        int length = s.length();
//        if (length == 1) {
//            return s;
//        }
//        for (int maxLength = length; maxLength > 0; maxLength--) {
//            for (int start = 0; start + maxLength <= length; start++) {
//                String sub = s.substring(start, start + maxLength);

    /// /                if (isPalindrome(sub)) {
    /// /                    return sub;
    /// /                }
//                if (isPalindrome(s, start, start + maxLength)) {
//                    return sub;
//                }
//            }
//        }
//        return "";
//    }
//    public static String longestPalindrome(String s) {
//        int length = s.length();
//        if (length == 1) {
//            return s;
//        }
//
//        // Create the badMatrix with the correct size here
//        boolean[][] badMatrix = new boolean[length][length];
//
//        for (int maxLength = length; maxLength > 0; maxLength--) {
//            for (int start = 0; start + maxLength <= length; start++) {
//                String sub = s.substring(start, start + maxLength);
//                if (isPalindrome(s, start, start + maxLength, badMatrix)) {
//                    return sub;
//                }
//            }
//        }
//        return "";
//    }

    /**
     * Expand from center
     * public static String longestPalindrome(String s) {
     * int length = s.length();
     * if (length == 1) {
     * return s;
     * }
     * String longest = "";
     * for (int i = 0; i < length; i++) {
     * String oddPal = expandFromCenter(s, i, i);
     * if (longest.length() < oddPal.length()) longest = oddPal;
     * String evenPal = expandFromCenter(s, i, i + 1);
     * if (longest.length() < evenPal.length()) longest = evenPal;
     * }
     * return longest;
     * }
     * <p>
     * private static String expandFromCenter(String s, int left, int right) {
     * while (0 <= left && right < s.length() && (s.charAt(left) == s.charAt(right))) {
     * left--;
     * right++;
     * }
     * return s.substring(left + 1, right);
     * }
     */

//    public static String longestPalindrome(String s) {
//        int length = s.length();
//        if (length == 1) {
//            return s;
//        }
//        int max = 0;
//        String solution = String.valueOf(s.charAt(0));
//        for (int start = 0; start < length; start++) {
//            for (int end = start; end <= length; end++) {
//                String sub = s.substring(start, end);
//                if (isPalindrome(sub)) {
//                    if (max < sub.length()) {
//                        max = sub.length();
//                        solution = sub;
//                    }
//                }
//            }
//        }
//        return solution;
//    }

//    static Set<String> palindromes = new HashSet<>();
//    static boolean[][] badMatrix = new boolean[1000][1000];

//    private static boolean isPalindrome(String s) {
//        if (s == null) {
//            return true;
//        }
//        if (palindromes.contains(s)) {
//            return true;
//        }
//        if (bad.contains(s)) {
//            return false;
//        }
//        int length = s.length();
//        if (length <= 1) {
//            palindromes.add(s);
//            return true;
//        }
//        if (s.charAt(0) != s.charAt(length - 1)) {
//            bad.add(s);
//            return false;
//        }
//        String subString = s.substring(1, length - 1);
//        if (isPalindrome(subString)) {
//            palindromes.add(s);
//            return true;
//        }
//        return false;
//    }
//    private static boolean isPalindrome(String s, int start, int end, boolean[][] badMatrix) {
//        // Base cases for recursion
//        if (start >= end) {
//            return true;
//        }
//        // Check memoization for non-palindromic substrings
//        if (badMatrix[start][end - 1]) {
//            return false;
//        }
//
//        // Check if the outer characters match
//        if (s.charAt(start) != s.charAt(end - 1)) {
//            badMatrix[start][end - 1] = true;
//            return false;
//        }
//        // Recursive call for the inner substring
//        if (isPalindrome(s, start + 1, end - 1, badMatrix)) {
//            return true;
//        }
//        // If the inner part isn't a palindrome, mark the whole as bad
//        badMatrix[start][end - 1] = true;
//        return false;
//    }

/*
    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (palindromes.contains(s.substring(left, right + 1))) {
                return true;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        palindromes.add(s);
        return true;
    }
*/
    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }

        boolean[][] dp = new boolean[n][n];
        String longestPalindrome = "";

        // All single-character substrings are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            longestPalindrome = s.substring(i, i + 1);
        }

        // Check for palindromes of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                longestPalindrome = s.substring(i, i + 2);
            }
        }

        // Check for palindromes of length 3 and greater
        boolean foundPalindromeForCurrentLength;
        boolean consecutiveNoPalindromes = false;

        for (int length = 3; length <= n; length++) {
            foundPalindromeForCurrentLength = false;
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    foundPalindromeForCurrentLength = true;
                    if (length > longestPalindrome.length()) {
                        longestPalindrome = s.substring(i, j + 1);
                    }
                }
            }
            if (!foundPalindromeForCurrentLength) {
                if (consecutiveNoPalindromes) {
                    break; // Stop searching if two consecutive levels had no new palindromes
                }
                consecutiveNoPalindromes = true;
            } else {
                consecutiveNoPalindromes = false;
            }
        }
        return longestPalindrome;
    }

//    public static String longestPalindrome(String s) {
//        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
//        Pair<Integer, Integer> best = null;
//
//        int length = s.length();
//        for (int i = 0; i < length; ++i) {
//            queue.offer(new ImmutablePair<>(i, i));
//        }
//
//        for (int i = 0; i < length - 1; ++i) {
//            if (s.charAt(i) == s.charAt(i + 1)) {
//                queue.offer(new ImmutablePair<>(i, i + 1));
//            }
//        }
//
//        while (!queue.isEmpty()) {
//            Pair<Integer, Integer> pair = queue.poll();
//            best = pair;
//            int left = pair.getKey();
//            int right = pair.getValue();
//            if (left == 0 || right == length - 1) {
//                continue;
//            }
//
//            if (s.charAt(left - 1) != s.charAt(right + 1)) {
//                continue;
//            }
//
//            queue.offer(new ImmutablePair<>(left - 1, right + 1));
//        }
//        return s.substring(best.getKey(), best.getValue() + 1);
//    }

//    // A record to represent a pair of integers
//    public record IntPair(int left, int right) {
//    }
//
//    public static String longestPalindrome(String s) {
//        Queue<IntPair> queue = new ArrayDeque<>();
//        IntPair best = null;
//        int length = s.length();
//        for (int i = 0; i < length; ++i) {
//            queue.offer(new IntPair(i, i));
//        }
//        for (int i = 0; i < length - 1; ++i) {
//            if (s.charAt(i) == s.charAt(i + 1)) {
//                queue.offer(new IntPair(i, i + 1));
//            }
//        }
//        while (!queue.isEmpty()) {
//            IntPair pair = queue.poll();
//            best = pair;
//            int left = pair.left();
//            int right = pair.right();
//            if (left == 0 || right == length - 1) {
//                continue;
//            }
//            if (s.charAt(left - 1) != s.charAt(right + 1)) {
//                continue;
//            }
//            queue.offer(new IntPair(left - 1, right + 1));
//        }
//        return s.substring(best.left(), best.right() + 1);
//    }

}
