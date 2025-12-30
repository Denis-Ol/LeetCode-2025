package leetcode.problems;

public class ProblemN1351CountNegativeNumbersInASortedMatrix {
/* 1351. Count Negative Numbers in a Sorted Matrix
Easy, Topics: Array, Binary Search, Matrix

Given a m x n matrix grid which is sorted in non-increasing order 
both row-wise and column-wise, return the number of negative numbers in grid.

Example 1:
Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.

Example 2:
Input: grid = [[3,2],[1,0]]
Output: 0

Constraints:
    m == grid.length
    n == grid[i].length
    1 <= m, n <= 100
    -100 <= grid[i][j] <= 100

Follow up: Could you find an O(n + m) solution? */

    public static void main(String[] args) {
        System.out.println("Hello LeetCode #1351. Count Negative Numbers in a Sorted Matrix");
        int[][] grid1 = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };
        System.out.println("Solution for example 1: " + countNegatives(grid1));
        System.out.println("Solution for example 1 is " +
                (countNegatives(grid1) == 8 ? "***CORRECT***" : "!!! WRONG !!!"));

        int[][] grid2 = {
                {3, 2},
                {1, 0},
        };
        System.out.println("Solution for example 2: " + countNegatives(grid2));
        System.out.println("Solution for example 2 is " +
                (countNegatives(grid2) == 0 ? "***CORRECT***" : "!!! WRONG !!!"));


    }

    // brute-force (stupid)
    /*public static int countNegatives(int[][] grid) {
        int m = grid.length; //rows
        int n = grid[0].length; // columns
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] < 0) count++;
            }
        }
        return count;
    }*/

    // brute-force smart with break - next raw starts from previous finish - no need to start from edge
    public static int countNegatives(int[][] grid) {
        int n = grid[0].length; // columns
        int count = 0;
        int p = n - 1;
        for (int[] row : grid) {
            while (p >= 0 && row[p] < 0) {
                p--;
            }
            count += n - 1 - p;
        }
        return count;
    }
}
