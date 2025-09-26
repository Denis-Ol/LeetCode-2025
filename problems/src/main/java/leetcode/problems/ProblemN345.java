package leetcode.problems;

public class ProblemN345 {
    /* 345. Reverse Vowels of a String

Given a string s, reverse only all the vowels in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Example 1:
Input: s = "IceCreAm"
Output: "AceCreIm"
Explanation:
The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:
Input: s = "leetcode"
Output: "leotcede"

Constraints:
    1 <= s.length <= 3 * 105
    s consist of printable ASCII characters.
     */

    public static void main(String[] args) {
        System.out.println("Hello LeetCode");
        System.out.println("Solution for example 1: " + reverseVowels("IceCreAm"));
        System.out.println("Solution for example 2: " + reverseVowels("leetcode"));
    }

    private static boolean isVowel(char c) {
        return (c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u') ||
                (c == 'A') || (c == 'E') || (c == 'I') || (c == 'O') || (c == 'U');
    }

//    public static String reverseVowels(String s) {
//        StringBuilder res = new StringBuilder(s);
//        int j = s.length() - 1;
//        for (int i = 0; i < j; i++) {
//            char left = s.charAt(i);
//            if (isVowel(left)) {
//                while (!isVowel(s.charAt(j))) {
//                    j--;
//                }
//                res.setCharAt(i, s.charAt(j));
//                res.setCharAt(j--, left);
//            }
//        }
//        return res.toString();
//    }

    //    public static String reverseVowels(String s) {
//        boolean[] vowels = new boolean[126];
//        for(char c : "aeiouAEIOU".toCharArray()) {
//            vowels[c] = true;
//        }
//        char[] cs = s.toCharArray();
//        int i = 0, j = cs.length - 1;
//        while(i < j) {
//            while(i < j && !vowels[cs[i]])
//                ++i;
//            while(i < j && !vowels[cs[j]])
//                --j;
//            if(i < j) {
//                char temp = cs[i];
//                cs[i] = cs[j];
//                cs[j] = temp;
//                ++i;
//                --j;
//            }
//        }
//        return String.valueOf(cs);
//    }
//    public static String reverseVowels(String s) {
//        boolean[] vowels = new boolean[126];
//        for(char c : "aeiouAEIOU".toCharArray()) {
//            vowels[c] = true;
//        }
//        int j = s.length() - 1;
//        char[] cs = s.toCharArray();
//        for (int i = 0; i < j; i++) {
//            char left = cs[i];
//            if (vowels[left]) {
//                while (!vowels[cs[j]]) {
//                    j--;
//                }
//                cs[i]=cs[j];
//                cs[j--]=left;
//            }
//        }
//        return String.valueOf(cs);
//    }
//        boolean[] vowels = new boolean[126];
//        for(char c : "aeiouAEIOU".toCharArray()) {
//            vowels[c] = true;
//        }
//        int j = s.length() - 1;
//        char[] cs = s.toCharArray();
//        for (int i = 0; i < j; i++) {
//            char left = cs[i];
//            if (isVowel(left)) {
//                while (!isVowel(cs[j])) {
//                    j--;
//                }
//                cs[i]=cs[j];
//                cs[j--]=left;
//            }
//        }
//        return String.valueOf(cs);
//    }
    public static String reverseVowels(String s) {
        int j = s.length() - 1;
        char[] cs = s.toCharArray();
        for (int i = 0; i < j; i++) {
            char left = cs[i];
            if ((left == 'a') || (left == 'e') || (left == 'i') || (left == 'o') || (left == 'u') ||
                    (left == 'A') || (left == 'E') || (left == 'I') || (left == 'O') || (left == 'U')) {
                while (!((cs[j] == 'a') || (cs[j] == 'e') || (cs[j] == 'i') || (cs[j] == 'o') || (cs[j] == 'u') ||
                        (cs[j] == 'A') || (cs[j] == 'E') || (cs[j] == 'I') || (cs[j] == 'O') || (cs[j] == 'U'))) {
                    j--;
                }
                cs[i] = cs[j];
                cs[j--] = left;
            }
        }
        return String.valueOf(cs);
    }
}
