public class ProblemN151ReverseWordsInAString {
    /* 151. Reverse Words in a String
    Medium, Topics: Two Pointers, String

    Given an input string s, reverse the order of the words.
    A word is defined as a sequence of non-space characters.
    The words in s will be separated by at least one space.
    Return a string of the words in reverse order concatenated by a single space.
    Note that s may contain leading or trailing spaces or multiple spaces between two words.
    The returned string should only have a single space separating the words.
    Do not include any extra spaces.


    Example 1:
    Input: s = "the sky is blue"
    Output: "blue is sky the"

    Example 2:
    Input: s = "  hello world  "
    Output: "world hello"
    Explanation: Your reversed string should not contain leading or trailing spaces.

    Example 3:
    Input: s = "a good   example"
    Output: "example good a"
    Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

    Constraints:
        1 <= s.length <= 10^4
        s contains English letters (upper-case and lower-case), digits, and spaces ' '.
        There is at least one word in s.

    Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space? * */
    public static void main(String[] args) {
        System.out.println("Hello LeetCode #151. Reverse Words in a String");
        System.out.println("Solution for example 1: " + reverseWords("the sky is blue"));
        System.out.println("Solution for example 1 is " +
                (reverseWords("the sky is blue").equals("blue is sky the") ? "***CORRECT***" : "!!! WRONG !!!"));
        System.out.println(reverseWords("  hello world  "));
        System.out.println("Solution for example 2 is " +
                (reverseWords("  hello world  ").equals("world hello") ? "***CORRECT***" : "!!! WRONG !!!"));
        System.out.println(reverseWords("a good   example"));
        System.out.println("Solution for example 3 is " +
                (reverseWords("a good   example").equals("example good a") ? "***CORRECT***" : "!!! WRONG !!!"));
//        System.out.println("  Java   is good  -->" + "START" + removeSpaces("  Java   is good  ") + "END");
        System.out.println("reverseString(\"test string \") =" + reverseString("test string "));
        System.out.println("reverseString(\"test string \") =" + reverseString(" test string"));

    }

//    public static String reverseWords(String s) {
//        int length = s.length();
//        int left = 0, right;
//        StringBuilder reversedStringBuilder = new StringBuilder();
//        while (left < length) {
//            char c = s.charAt(left);
//            if (c != ' ') {
//                StringBuilder word = new StringBuilder("" + c);
//                right = left + 1;
//                while (right < length) {
//                    char temp = s.charAt(right++);
//                    if (temp != ' ') word.append(temp);
//                    else break;
//                }
//                word.append(' ');
//                reversedStringBuilder.insert(0, word);
//                left = right;
//            } else ++left;
//        }
//        return reversedStringBuilder.deleteCharAt(reversedStringBuilder.length() - 1).toString();
//    }

    public static String reverseWords(String s) {
        int length = s.length();
        int left = 0, right;
        StringBuilder reversedStringBuilder = new StringBuilder();
        while (left < length) {
            char c = s.charAt(left);
            if (c != ' ') {
                StringBuilder word = new StringBuilder("" + c);
                right = left + 1;
                while (right < length) {
                    char temp = s.charAt(right++);
                    if (temp != ' ') word.append(temp);
                    else break;
                }
                word.reverse();
                word.append(' ');
                reversedStringBuilder.append(word);
                left = right;
            } else ++left;
        }
        return reversedStringBuilder.reverse().deleteCharAt(0).toString();
    }

//    public static String reverseWords(String s) {
//        s = removeSpaces(s);
//        s = reverseString(s);
//        String[] strArray = s.split(" ");
//        StringBuilder sb = new StringBuilder(s.length());
//        for (String word : strArray) {
//            sb.append(reverseString(word)).append(' ');
//        }
//        return sb.deleteCharAt(sb.length() - 1).toString();
//    }

//    public static String reverseWords(String s) {
//        s = reverseString(s.trim());
//        String[] strArray = s.split("\\s+");
//        StringBuilder sb = new StringBuilder();
//        for (String word : strArray) {
//            sb.append(reverseString(word)).append(' ');
//        }
//        return sb.deleteCharAt(sb.length() - 1).toString();
//    }

//    public static String reverseString(String s) {
//        int length = s.length();
//        StringBuilder sb = new StringBuilder(s);
//        int left = 0, right = length - 1;
//        while (left < right) {
//            char leftChar = sb.charAt(left);
//            sb.setCharAt(left++, sb.charAt(right));
//            sb.setCharAt(right--, leftChar);
//        }
//        return sb.toString();
//    }

//    public static String reverseWords(String s) {
//        s = reverseString(s.trim());
//        char[] chars = new char[s.length()];
//        String[] strArray = s.split("\\s+");
//        int i = 0;
//        for (int wordCount = 0; wordCount < strArray.length; wordCount++) {
//            char[] wordChars = reverseStringToChars(strArray[wordCount]);
//            for (int j = 0; j < wordChars.length; j++) {
//                chars[i + j] = wordChars[j];
//            }
//            i += wordChars.length;
//            if (wordCount != strArray.length - 1) chars[i++] = ' ';
//        }
//        return new String(chars, 0, i);
//    }

    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char leftChar = chars[left];
            chars[left++] = chars[right];
            chars[right--] = leftChar;
        }
        return new String(chars);
    }

    public static char[] reverseStringToChars(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char leftChar = chars[left];
            chars[left++] = chars[right];
            chars[right--] = leftChar;
        }
        return chars;
    }

    public static String removeSpaces(String s) {
        int length = s.length();
        StringBuilder sb = new StringBuilder(length);
        int left = 0, right;
        while (left < length) {
            char c = s.charAt(left);
            if (c == ' ') {
                right = left + 1;
                while (right < length) {
                    char temp = s.charAt(right++);
                    if (temp != ' ') {
                        if (!sb.isEmpty()) sb.append(" ");
                        sb.append(temp);
                        break;
                    }
                }
                left = right;
            } else {
                sb.append(c);
                ++left;
            }
        }
        return sb.toString();
    }

}
