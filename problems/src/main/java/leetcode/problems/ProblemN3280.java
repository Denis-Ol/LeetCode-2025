package leetcode.problems;

public class ProblemN3280 {
    /* 3280. Convert Date to Binary

    You are given a string date representing a Gregorian calendar date in the yyyy-mm-dd format.
date can be written in its binary representation obtained by converting year, month, and day to their binary representations without any leading zeroes and writing them down in year-month-day format.
Return the binary representation of date.

Example 1:
Input: date = "2080-02-29"
Output: "100000100000-10-11101"

Explanation:
100000100000, 10, and 11101 are the binary representations of 2080, 02, and 29 respectively.

Example 2:
Input: date = "1900-01-01"
Output: "11101101100-1-1"

Explanation:
11101101100, 1, and 1 are the binary representations of 1900, 1, and 1 respectively.

Constraints:
    date.length == 10
    date[4] == date[7] == '-', and all other date[i]'s are digits.
    The input is generated such that date represents a valid Gregorian calendar date between Jan 1st, 1900 and Dec 31st, 2100 (both inclusive).


            */

    public static void main(String[] args) {
        System.out.println("Hello LeetCode #3280. Convert Date to Binary");
        System.out.println("Solution: " + convertDateToBinary("2080-02-29"));

    }

    //    public static String convertDateToBinary(String date) {
//        String[] dates = date.split("-");
//        int[] datesInt = Arrays.stream(dates).mapToInt(Integer::parseInt).toArray();
//        String[] binDates = Arrays.stream(datesInt).mapToObj(Integer::toBinaryString).toArray(String[]::new);
//        return String.join("-", binDates);
//    }
//    public static String convertDateToBinary(String date) {
//        String[] dates = date.split("-");
//        String year = Integer.toBinaryString(Integer.parseInt(dates[0]));
//        String month = Integer.toBinaryString(Integer.parseInt(dates[1]));
//        String day = Integer.toBinaryString(Integer.parseInt(dates[2]));
//        return year+"-"+month+"-"+day;
//    }
//    public static String convertDateToBinary(String date) {
//        return Integer.toBinaryString(Integer.parseInt(date.substring(0,4))) +"-"+ Integer.toBinaryString(Integer.parseInt(date.substring(5,7))) +"-"+ Integer.toBinaryString(Integer.parseInt(date.substring(8,10)));
//    }

    public static String convertDateToBinary(String date) {
        StringBuilder res = new StringBuilder();
        int num = 0;
        for (int i = 0; i < date.length(); i++) {
            char c = date.charAt(i);
            if (c == '-') {
                String bin = Integer.toBinaryString(num);
                res.append(bin);
                res.append("-");
                num = 0;
            } else {
                int dig = c - '0';
                num = (num * 10) + dig;
            }
        }
        String bin = Integer.toBinaryString(num);
        res.append(bin);
        return res.toString();
    }
}
