package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class ProblemN3LongestSubstringWithoutRepeatingCharacters {
/* 3. Longest Substring Without Repeating Characters
Medium, Topics: Hash Table, String, Sliding Window

Given a string s, find the length of the longest substring without duplicate characters.


Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:
    0 <= s.length <= 5 * 10^4
    s consists of English letters, digits, symbols and spaces. */

    public static void main(String[] args) {
        System.out.println("Hello LeetCode #3. Longest Substring Without Repeating Characters");
        System.out.println("Solution for example 1: " + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("Solution for example 1 is " +
                ((lengthOfLongestSubstring("abcabcbb") == 3) ? "***CORRECT***" : "!!! WRONG !!!"));

        System.out.println("Solution for example 2: " + lengthOfLongestSubstring("bbbbb"));
        System.out.println("Solution for example 2 is " +
                ((lengthOfLongestSubstring("bbbbb") == 1) ? "***CORRECT***" : "!!! WRONG !!!"));

        System.out.println("Solution for example 3: " + lengthOfLongestSubstring("pwwkew"));
        System.out.println("Solution for example 3 is " +
                ((lengthOfLongestSubstring("pwwkew") == 3) ? "***CORRECT***" : "!!! WRONG !!!"));
    }

//    public static int lengthOfLongestSubstring(String s) {
//        int length = s.length();
//        if (length <= 1) {
//            return length;
//        }
//        int maxLength = 1;
//        for (int i = 0; i < length; i++) {
//            for (int j = i + 2; j <= length; j++) {
//                String substring = s.substring(i, j);
//                if (isValid(substring)) {
//                    maxLength = Math.max(maxLength, substring.length());
//                }
//            }
//        }
//        return maxLength;
//    }

    public static boolean isValid(String s) {
        Set<Character> characterSet = new HashSet<>();
        int i = 0;
        while (i < s.length() && characterSet.add(s.charAt(i))) {
            i++;
        }
        return i == s.length();
    }

    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length <= 1) {
            return length;
        }
        int maxLength = 1;
        int l = 0, r = 0;
        Set<Character> characterSet = new HashSet<>();
        while (r < length) {
            if (characterSet.add(s.charAt(r))) {
                maxLength = Math.max(maxLength, r - l + 1);
                r++;
            } else {
                characterSet.remove(s.charAt(l));
                l++;
            }
        }
        return maxLength;
    }
}
