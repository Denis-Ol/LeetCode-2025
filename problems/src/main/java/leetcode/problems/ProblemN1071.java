package leetcode.problems;

public class ProblemN1071 {
    /* 1071. Greatest Common Divisor of Strings
For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t
(i.e., t is concatenated with itself one or more times).
Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

Example 1:
Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"

Example 2:
Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"

Example 3:
Input: str1 = "LEET", str2 = "CODE"
Output: ""


Constraints:
    1 <= str1.length, str2.length <= 1000
    str1 and str2 consist of English uppercase letters.

     */

    public static void main(String[] args) {
        System.out.println("Hello LeetCode #1071. Greatest Common Divisor of Strings");
        System.out.println("Solution for example 1: " + gcdOfStrings("AAAA", "AA"));
        System.out.println("Solution for example 1: " + gcdOfStrings("ABCABC", "ABC"));
//        System.out.println("Solution for example 2: " + mergeAlternately("ab", "pqrs"));
//        System.out.println("Solution for example 3: " + mergeAlternately("abcd", "pq"));
    }

//    public boolean isDivDividesStr(String str, String div) {
//        int strLength = str.length();
//        int divLength = div.length();
//        if (strLength % divLength != 0) return false;
//        int times = strLength/divLength;
//        StringBuilder sb = new StringBuilder(div);
//        for (int i = 1; i < times; i++) {
//            sb.append(div);
//        }
//        return str.contentEquals(sb);
//    }

    public static boolean isDivDividesStr(String str, StringBuilder div) {
        int strLength = str.length();
        int divLength = div.length();
        if (strLength % divLength != 0) return false;
        StringBuilder sb = new StringBuilder();
        sb.repeat(div, strLength / divLength);
        return str.contentEquals(sb);
    }

    public static boolean isDivDividesStr(StringBuilder str, StringBuilder div) {
        int strLength = str.length();
        int divLength = div.length();
        if (strLength % divLength != 0) return false;
        StringBuilder sb = new StringBuilder();
        sb.repeat(div, strLength / divLength);
        return str.compareTo(sb) == 0;
    }

    //    public static String gcdOfStrings(String str1, String str2) {
//        int str1length = str1.length();
//        int str2length = str2.length();
//
//        String[] str1DivArr = new String[str1length];
//        String[] str2DivArr = new String[str2length];
//        StringBuilder sb1 = new StringBuilder();
//        for (int i = 0; i < str1length; i++) {
//            str1DivArr[i] = (isDivDividesStr(str1, sb1.append(str1.charAt(i)))) ? sb1.toString() : "";
//        }
//        StringBuilder sb2 = new StringBuilder();
//        for (int j = 0; j < str2length; j++) {
//            str2DivArr[j] = isDivDividesStr(str2, sb2.append(str2.charAt(j))) ? sb2.toString() : "";
//        }
//        int min = Math.min(str1length, str2length);
//        String commonDiv = "";
//
//        for (int k = min - 1; k >= 0; k--) {
//            if (!str1DivArr[k].equals("")) {
//                if (str1DivArr[k].equals(str2DivArr[k])) {
//                    commonDiv = str1DivArr[k];
//                    break;
//                }
//            }
//        }
//        return commonDiv;
//    }
//    public static String gcdOfStrings(String str1, String str2) {
//        int str1length = str1.length();
//        int str2length = str2.length();
//        int min = Math.min(str1length, str2length);
//        String shortStr, longStr;
//        if (str1length == min) {
//            shortStr = str1;
//            longStr = str2;
//
//        } else {
//            shortStr = str2;
//            longStr = str1;
//        }
//        StringBuilder temp = new StringBuilder(shortStr);
//        for (int i = min - 1; i >= 0; i--) {
//            if (temp.isEmpty()) {
//                return "";
//            }
//            if (isDivDividesStr(longStr, temp) && isDivDividesStr(shortStr, temp)) {
//                return temp.toString();
//            }
//            temp.deleteCharAt(i);
//        }
//        return "";
//    }
    public static String gcdOfStrings(String str1, String str2) {
        int str1length = str1.length();
        int str2length = str2.length();
        int min = Math.min(str1length, str2length);
        String shortStr, longStr;
        if (str1length == min) {
            shortStr = str1;
            longStr = str2;

        } else {
            shortStr = str2;
            longStr = str1;
        }
        StringBuilder temp = new StringBuilder(shortStr);
        for (int i = min - 1; i >= 0; i--) {
            int len = temp.length();
            if (len == 0) {
                return "";
            }
            if (str1length % len == 0 && str2length % len == 0) {
                if (isDivDividesStr(longStr, temp) && isDivDividesStr(shortStr, temp)) {
                    return temp.toString();
                }
            }
            temp.deleteCharAt(i);
        }
        return "";
    }
}
