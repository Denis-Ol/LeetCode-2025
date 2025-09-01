public class ProblemN7ReverseInteger {
    /* 7. Reverse Integer

Medium, Topics: Math

Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).


Example 1:
Input: x = 123
Output: 321

Example 2:
Input: x = -123
Output: -321

Example 3:
Input: x = 120
Output: 21


Constraints:
    -2^31 <= x <= 2^31 - 1 */

    public static void main(String[] args) {
        System.out.println("Hello LeetCode #7. Reverse Integer");
//        System.out.println("Solution for example 1: " + reverse(123));
//        System.out.println("Solution for example 1 is " +
//                ((reverse(123) == 321) ? "***CORRECT***" : "!!! WRONG !!!"));
//
//        System.out.println("Solution for example 2: " + reverse(-123));
//        System.out.println("Solution for example 2 is " +
//                ((reverse(-123) == -321) ? "***CORRECT***" : "!!! WRONG !!!"));
//
//        System.out.println("Solution for example 3: " + reverse(123));
//        System.out.println("Solution for example 3 is " +
//                ((reverse(120) == 21) ? "***CORRECT***" : "!!! WRONG !!!"));
//
//        System.out.println("Solution for test 4: " + reverse(1534236469));
        System.out.println("Solution for test 4 is " +
                ((reverse(1534236469) == 0) ? "***CORRECT***" : "!!! WRONG !!!"));




    }

//    public static int reverse(int x) {
//        int rev = 0;
//        while (x != 0) {
//            int rem = x % 10;
//            if ((x > 0 && rev > (Integer.MAX_VALUE - rem) / 10) || (x < 0 && rev < (Integer.MIN_VALUE - rem) / 10)) {
//                return 0;
//            }
//            rev = rev * 10 + rem;
//            x /= 10;
//        }
//        return rev;
//    }

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int check = rev * 10 + x % 10;
            if (check / 10 != rev) {
                return 0;
            }
            rev = check;
            x /= 10;
        }
        return rev;
    }


}
