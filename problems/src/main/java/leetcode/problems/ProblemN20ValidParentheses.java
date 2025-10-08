package leetcode.problems;

public class ProblemN20ValidParentheses {
    /* 20. Valid Parentheses
Easy, Topics: String, Stack

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true

Example 5:
Input: s = "([)]"
Output: false


Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'. */
    public static void main(String[] args) {
        System.out.println("Hello LeetCode #605");
        System.out.println("Solution for example 1: " + isValid("()"));
        System.out.println("Solution for example 1 is " +
                (isValid("()") ? "***CORRECT***" : "!!! WRONG !!!"));

        System.out.println("Solution for example 2: " + isValid("()[]{}"));
        System.out.println("Solution for example 2 is " +
                (isValid("()[]{}") ? "***CORRECT***" : "!!! WRONG !!!"));

        System.out.println("Solution for example 3: " + isValid("(]"));
        System.out.println("Solution for example 3 is " +
                (!isValid("(]") ? "***CORRECT***" : "!!! WRONG !!!"));

        System.out.println("Solution for example 4: " + isValid("([])"));
        System.out.println("Solution for example 4 is " +
                (isValid("([])") ? "***CORRECT***" : "!!! WRONG !!!"));

        System.out.println("Solution for example 5: " + isValid("([)]"));
        System.out.println("Solution for example 5 is " +
                (!isValid("([)]") ? "***CORRECT***" : "!!! WRONG !!!"));
    }
/*
    // 2 sets: closing and pairs. O(N) time and space
    public static boolean isValid(String s) {
        Set<Character> closing = Set.of(')', '}', ']');
        Set<String> pairs = Set.of("()", "{}", "[]");
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (closing.contains(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                String pair = stack.pop().toString() + c;
                if (!pairs.contains(pair)) {
                    return false;
                }
                continue;
            }
            stack.push(c);
        }
        return stack.isEmpty();
    }*/

    // map and stack
    /*
    public static boolean isValid(String s) {
        Map<Character, Character> pairs = Map.of(')', '(', '}', '{', ']', '[');
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (pairs.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != (char) pairs.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    } */

    // stack by char[n/2]
    public static boolean isValid(String s) {
        char[] stack = new char[s.length() / 2];
        int top = -1;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                if (++top < stack.length) { // Pre-increment top before checking array bounds
                    stack[top] = c;
                } else {
                    return false;
                }
            } else {
                if (top == -1) {
                    return false;
                }
                char lastOpen = stack[top--]; // Post-decrement top after retrieving the element
                if ((c == ')' && lastOpen != '(') ||
                        (c == '}' && lastOpen != '{') ||
                        (c == ']' && lastOpen != '[')) {
                    return false;
                }
            }
        }
        return top == -1;
    }

}
