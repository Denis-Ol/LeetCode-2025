package leetcode.problems;

public class ProblemN840MagicSquaresInGrid {
/* 840. Magic Squares In Grid
Medium, Topics: Array, Hash Table, Math, Matrix

A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9
such that each row, column, and both diagonals all have the same sum.

Given a row x col grid of integers, how many 3 x 3 magic square subgrids are there?

Note: while a magic square can only contain numbers from 1 to 9, grid may contain numbers up to 15.

Example 1:
Input: grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]]
Output: 1
In total, there is only one magic square inside the given grid.

Example 2:
Input: grid = [[8]]
Output: 0

Constraints:
    row == grid.length
    col == grid[i].length
    1 <= row, col <= 10
    0 <= grid[i][j] <= 15 */

    public static void main(String[] args) {
        System.out.println("Hello LeetCode #840. Magic Squares In Grid");
        int[][] grid1 = {
                {4, 3, 8, 4},
                {9, 5, 1, 9},
                {2, 7, 6, 2}
        };
        System.out.println("Solution for example 1: " + numMagicSquaresInside(grid1));
        System.out.println("Solution for example 1 is " +
                (numMagicSquaresInside(grid1) == 1 ? "***CORRECT***" : "!!! WRONG !!!"));

        int[][] grid2 = {
                {8}
        };
        System.out.println("Solution for example 2: " + numMagicSquaresInside(grid2));
        System.out.println("Solution for example 2 is " +
                (numMagicSquaresInside(grid2) == 0 ? "***CORRECT***" : "!!! WRONG !!!"));

        int[][] grid3 = {{4, 7, 8}, {9, 5, 1}, {2, 3, 6}};
        System.out.println("Solution for test 48: " + numMagicSquaresInside(grid3));
        System.out.println("Solution for test 48 is " +
                (numMagicSquaresInside(grid3) == 0 ? "***CORRECT***" : "!!! WRONG !!!"));
    }

    public static int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        if (row >= 3 && col >= 3) {
            for (int i = 1; i < row - 1; i++) {
                for (int j = 1; j < col - 1; j++) {
                    if (isMagic(i, j, grid)) count++;
                }
            }
        }
        return count;
    }

    private static boolean isMagic(int i, int j, int[][] grid) {
        // takes [i][j] of grid - center of 3x3 grid and check it's magic properties
        if (!isDistinctAnd1to9(i, j, grid)) {
            return false;
        }
        if (!areSumsEqual(i, j, grid)) {
            return false;
        }
        return true;
    }

    //hashset approach
    /*private static boolean isDistinctAnd1to9(int i, int j, int[][] grid) {
        // takes [i][j] of grid - center of 3x3 grid and check it's magic properties:
        // distinct 1 to 9
        Set<Integer> set = new HashSet<>();
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                int num = grid[k][l];
                if (num < 1 || num > 9 || !set.add(num)) {
                    return false;
                }
            }
        }
        return set.size() == 9;
    }*/

    // boolean[] seen approach
    private static boolean isDistinctAnd1to9(int i, int j, int[][] grid) {
        boolean[] seen = new boolean[10];
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                int num = grid[k][l];
                if (1 <= num && num <= 9 && !seen[num]) {
                    seen[num] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean areSumsEqual(int i, int j, int[][] grid) {
        // takes [i][j] of grid - center of 3x3 grid and check it's magic properties:
        // checking sums: row1 = row2 = row3 = col1 = col2 = col3 = diag1 = diag2
        int sum = grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1];

        return grid[i][j - 1] + grid[i][j] + grid[i][j + 1] == sum &&
                grid[i + 1][j - 1] + grid[i + 1][j] + grid[i + 1][j + 1] == sum &&
                grid[i - 1][j - 1] + grid[i][j - 1] + grid[i + 1][j - 1] == sum &&
                grid[i - 1][j] + grid[i][j] + grid[i + 1][j] == sum &&
                grid[i - 1][j + 1] + grid[i][j + 1] + grid[i + 1][j + 1] == sum &&
                grid[i - 1][j - 1] + grid[i][j] + grid[i + 1][j + 1] == sum &&
                grid[i - 1][j + 1] + grid[i][j] + grid[i + 1][j - 1] == sum;
    }


}
