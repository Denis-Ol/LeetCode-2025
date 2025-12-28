package leetcode.problems;

import java.nio.charset.StandardCharsets;

public class ProblemN2483MinimumPenaltyForAShop {
/* 2483. Minimum Penalty for a Shop
Medium, Topics: String, Prefix Sum

You are given the customer visit log of a shop represented by a 0-indexed string customers
consisting only of characters 'N' and 'Y':
    * if the ith character is 'Y', it means that customers come at the ith hour
    * whereas 'N' indicates that no customers come at the ith hour.

If the shop closes at the jth hour (0 <= j <= n), the penalty is calculated as follows:
    * For every hour when the shop is open and no customers come, the penalty increases by 1.
    * For every hour when the shop is closed and customers come, the penalty increases by 1.

Return the earliest hour at which the shop must be closed to incur a minimum penalty.

Note that if a shop closes at the jth hour, it means the shop is closed at the hour j.

Example 1:
Input: customers = "YYNY"
Output: 2
Explanation:
- Closing the shop at the 0th hour incurs in 1+1+0+1 = 3 penalty.
- Closing the shop at the 1st hour incurs in 0+1+0+1 = 2 penalty.
- Closing the shop at the 2nd hour incurs in 0+0+0+1 = 1 penalty.
- Closing the shop at the 3rd hour incurs in 0+0+1+1 = 2 penalty.
- Closing the shop at the 4th hour incurs in 0+0+1+0 = 1 penalty.
Closing the shop at 2nd or 4th hour gives a minimum penalty.
Since 2 is earlier, the optimal closing time is 2.

Example 2:
Input: customers = "NNNNN"
Output: 0
Explanation: It is best to close the shop at the 0th hour as no customers arrive.

Example 3:
Input: customers = "YYYY"
Output: 4
Explanation: It is best to close the shop at the 4th hour as customers arrive at each hour.

Constraints:
    1 <= customers.length <= 10^5
    customers consists only of characters 'Y' and 'N'.  */


    public static void main(String[] args) {
        System.out.println("Hello LeetCode #2483. Minimum Penalty for a Shop");
        System.out.println("Solution for example 1: " + bestClosingTime("YYNY"));
        System.out.println("Solution for example 1 is " +
                (bestClosingTime("YYNY") == 2 ? "***CORRECT***" : "!!! WRONG !!!"));

        System.out.println("Solution for example 2: " + bestClosingTime("NNNNN"));
        System.out.println("Solution for example 2 is " +
                (bestClosingTime("NNNNN") == 0 ? "***CORRECT***" : "!!! WRONG !!!"));

        System.out.println("Solution for example 3: " + bestClosingTime("YYYY"));
        System.out.println("Solution for example 3 is " +
                (bestClosingTime("YYYY") == 4 ? "***CORRECT***" : "!!! WRONG !!!"));
    }

    /* brute-force
    public static int bestClosingTime(String customers) {
        int n = customers.length();
        int[] penArray = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            int penalty = 0;

            for (int j = 0; j < i; j++) { // open 0 -> skip, i_max = n -> j_max = n-1
                if (customers.charAt(j) == 'N') penalty++;
            }
            for (int j = i; j < n; j++) { // closed 0 - here
                if (customers.charAt(j) == 'Y') penalty++;
            }
            penArray[i] = penalty;
        }

        int minPen = Integer.MAX_VALUE;
        int minCloseTime = -1;
        for (int i = 0; i < n + 1; i++) {
            if (penArray[i] < minPen) {
                minPen = penArray[i];
                minCloseTime = i;
            }
        }
        return minCloseTime;
    }*/

    // prefix and suffix
    /* public static int bestClosingTime(String customers) {
        int n = customers.length();
        int[] penArray = new int[n + 1], openPenArray = new int[n + 1], closePenArray = new int[n + 1];

        //open, i_min = 1, i is for i-1
        openPenArray[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            openPenArray[i] = openPenArray[i - 1];
            if (customers.charAt(i - 1) == 'N') openPenArray[i]++;
        }

//        max close = n-1
        closePenArray[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            closePenArray[i] = closePenArray[i + 1];
            if (customers.charAt(i) == 'Y') closePenArray[i]++;
        }


        for (int i = 0; i < n + 1; i++) {
            penArray[i] = openPenArray[i] + closePenArray[i];
        }

        int minPen = Integer.MAX_VALUE;
        int minCloseTime = -1;
        for (int i = 0; i < n + 1; i++) {
            if (penArray[i] < minPen) {
                minPen = penArray[i];
                minCloseTime = i;
            }
        }
        return minCloseTime;
    }*/
// function - earn during opening, +1 at end - as closure after that hour that we assess.
// Can't earn if closed - may only lose, so find peak and close after it
 /*   public static int bestClosingTime(String customers) {
        int n = customers.length();
        int currFunc = 0, maxcFunc = 0, closeTime = -1;
        for (int i = 0; i < n; i++) {
            currFunc += (customers.charAt(i) == 'Y') ? 1 : -1;
            if (currFunc > maxcFunc) {
                maxcFunc = currFunc;
                closeTime = i;
            }
        }
        return closeTime + 1;
    }*/
// Tagir's byte trick
    public static int bestClosingTime(String customers) {
        byte[] bytes = customers.getBytes(StandardCharsets.ISO_8859_1);
        int currFunc = 0, maxcFunc = 0, closeTime = -1;
        for (int i = 0; i < bytes.length; i++) {
//            N - ...10, Y - ...01
            currFunc += (1 - (bytes[i] & 2)); // N & 2 = 2, Y & 2 = 0
            if (currFunc > maxcFunc) {
                maxcFunc = currFunc;
                closeTime = i;
            }
        }
        return closeTime + 1;
    }
}