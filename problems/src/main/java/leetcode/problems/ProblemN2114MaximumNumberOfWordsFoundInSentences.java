package leetcode.problems;

public class ProblemN2114MaximumNumberOfWordsFoundInSentences {
    /* 2114. Maximum Number of Words Found in Sentences
A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
You are given an array of strings sentences, where each sentences[i] represents a single sentence.
Return the maximum number of words that appear in a single sentence.

Example 1:
Input: sentences = ["alice and bob love leetcode", "i think so too", "this is great thanks very much"]
Output: 6
Explanation:
- The first sentence, "alice and bob love leetcode", has 5 words in total.
- The second sentence, "i think so too", has 4 words in total.
- The third sentence, "this is great thanks very much", has 6 words in total.
Thus, the maximum number of words in a single sentence comes from the third sentence, which has 6 words.

Example 2:
Input: sentences = ["please wait", "continue to fight", "continue to win"]
Output: 3
Explanation: It is possible that multiple sentences contain the same number of words.
In this example, the second and third sentences (underlined) have the same number of words.

Constraints:

    1 <= sentences.length <= 100
    1 <= sentences[i].length <= 100
    sentences[i] consists only of lowercase English letters and ' ' only.
    sentences[i] does not have leading or trailing spaces.
    All the words in sentences[i] are separated by a single space.

     */

    public static void main(String[] args) {
        System.out.println("Hello LeetCode #2114. Maximum Number of Words Found in Sentences");
        System.out.println("Solution for example 1: " + mostWordsFound(new String[]{"alice and bob love leetcode", "i think so too", "this is great thanks very much"}));
        System.out.println("Solution for example 2: " + mostWordsFound(new String[]{"please wait", "continue to fight", "continue to win"}));
    }

    //    public static int mostWordsFound(String[] sentences) {//3 ms
//        int max = 1;
//        for (String sentence:sentences) {
//            max= Math.max(sentence.split(" ").length, max);
//        }
//        return max;
//    }
//    public static int mostWordsFound(String[] sentences) {
//        int max = 1;
//        for (String sentence : sentences) {
//            int temp = 1;
//            for (char ch : sentence.toCharArray()) {
//                if (ch == ' ') {
//                    temp++;
//                }
//            }
//            max = Math.max(temp, max);
//        }
//        return max;
//    }

//    public static byte check(String t) {
//        byte cnt = 1;
//        for (char c : t.toCharArray()) {
//            if (c == ' ') {
//                cnt++;
//            }
//        }
//        return cnt;
//    }
//
//    public static int mostWordsFound(String[] sentences) {
//        int max = 1;
//        int n = sentences.length;
//        for (String t : sentences) {
//            int check = check(t);
//            if (check > max) {
//                max = check;
//            }
//        }
//        return max;
//    }

    public static byte check(String t) {
        byte cnt = 1;
        for (char c : t.toCharArray()) {
            if (c == ' ') {
                cnt++;
            }
        }
        return cnt;
    }

    public static int mostWordsFound(String[] sentences) {
        byte max = Byte.MIN_VALUE;
        for (String t : sentences) {
            byte cnt = 1;
            for (char c : t.toCharArray()) {
                if (c == ' ') {
                    cnt++;
                }
            }
            if (cnt > max) {
                max = cnt;
            }
        }
        return max;
    }
}
