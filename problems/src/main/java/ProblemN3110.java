public class ProblemN3110 {
    /*
    3110. Score of a String
    https://leetcode.com/problems/score-of-a-string/description/
    You are given a string s.
    The score of a string is defined as the sum of the absolute difference between the ASCII values of adjacent characters.
    Return the score of s.

    Example 1:
    Input: s = "hello"
    Output: 13
    Explanation:
    The ASCII values of the characters in s are: 'h' = 104, 'e' = 101, 'l' = 108, 'o' = 111. So, the score of s would be |104 - 101| + |101 - 108| + |108 - 108| + |108 - 111| = 3 + 7 + 0 + 3 = 13.

    Example 2:
    Input: s = "zaz"
    Output: 50
    Explanation:
    The ASCII values of the characters in s are: 'z' = 122, 'a' = 97. So, the score of s would be |122 - 97| + |97 - 122| = 25 + 25 = 50.

    Constraints:
    2 <= s.length <= 100
    s consists only of lowercase English letters.
        */

    public static void main(String[] args) {
        System.out.println("Hello LeetCode");
        String s = "hello";
        int length = s.toCharArray().length;
        System.out.println("length = " + length);

//        ProblemN3110 problemN3110 = new ProblemN3110();
        int solution = scoreOfString("hello");
        System.out.println("solution = " + solution);

        System.out.println("Solution without charArray: " + scoreOfString2("hello"));

    }

    public static int scoreOfString(String s) {
        char[] charArray = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < charArray.length - 1; i++) {
            sum += Math.abs(charArray[i] - charArray[i + 1]);
        }
        return sum;
    }

    public static int scoreOfString2(String s) {
        int score = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            score += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return score;
    }
}
