package leetcode.problems;

public class ProblemN2011 {
    /*
    2011. Final Value of Variable After Performing Operations
    There is a programming language with only four operations and one variable X:

    ++X and X++ increments the value of the variable X by 1.
    --X and X-- decrements the value of the variable X by 1.

Initially, the value of X is 0.

Given an array of strings operations containing a list of operations, return the final value of X after performing all the operations.


Example 1:

Input: operations = ["--X","X++","X++"]
Output: 1
Explanation: The operations are performed as follows:
Initially, X = 0.
--X: X is decremented by 1, X =  0 - 1 = -1.
X++: X is incremented by 1, X = -1 + 1 =  0.
X++: X is incremented by 1, X =  0 + 1 =  1.

Example 2:

Input: operations = ["++X","++X","X++"]
Output: 3
Explanation: The operations are performed as follows:
Initially, X = 0.
++X: X is incremented by 1, X = 0 + 1 = 1.
++X: X is incremented by 1, X = 1 + 1 = 2.
X++: X is incremented by 1, X = 2 + 1 = 3.

Example 3:

Input: operations = ["X++","++X","--X","X--"]
Output: 0
Explanation: The operations are performed as follows:
Initially, X = 0.
X++: X is incremented by 1, X = 0 + 1 = 1.
++X: X is incremented by 1, X = 1 + 1 = 2.
--X: X is decremented by 1, X = 2 - 1 = 1.
X--: X is decremented by 1, X = 1 - 1 = 0.



Constraints:

    1 <= operations.length <= 100
    operations[i] will be either "++X", "X++", "--X", or "X--".


        */

    public static void main(String[] args) {
        System.out.println("Hello LeetCode");
        System.out.println("Solution: " + finalValueAfterOperations(new String[]{"X++", "++X", "--X", "X--"}));

    }

    public static int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String operation : operations) {
            if (operation.contains("+")) {
                x++;
            } else {
                x--;
            }
        }
        return x;
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
