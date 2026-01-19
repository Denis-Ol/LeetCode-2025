package leetcode.problems;

public class ProblemN1266MinimumTimeVisitingAllPoints {
    /*
1266. Minimum Time Visiting All Points
Easy
Topics
premium lock iconCompanies
Hint

On a 2D plane, there are n points with integer coordinates points[i] = [xi, yi]. Return the minimum time in seconds to visit all the points in the order given by points.

You can move according to these rules:

    In 1 second, you can either:
        move vertically by one unit,
        move horizontally by one unit, or
        move diagonally sqrt(2) units (in other words, move one unit vertically then one unit horizontally in 1 second).
    You have to visit the points in the same order as they appear in the array.
    You are allowed to pass through points that appear later in the order, but these do not count as visits.



Example 1:

Input: points = [[1,1],[3,4],[-1,0]]
Output: 7
Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
Time from [1,1] to [3,4] = 3 seconds
Time from [3,4] to [-1,0] = 4 seconds
Total time = 7 seconds

Example 2:

Input: points = [[3,2],[-2,2]]
Output: 5



Constraints:

    points.length == n
    1 <= n <= 100
    points[i].length == 2
    -1000 <= points[i][0], points[i][1] <= 1000


     */
    public static void main(String[] args) {
        System.out.println("Hello LeetCode #1266. Minimum Time Visiting All Points");
        int[][] points1 = {{1, 1}, {3, 4}, {-1, 0}};
        System.out.println("Solution for example 1: " + minTimeToVisitAllPoints(points1));
        System.out.println("Solution for example 1 is " +
                (minTimeToVisitAllPoints(points1) == 7 ? "***CORRECT***" : "!!! WRONG !!!"));

        int[][] points2 = {{3, 2}, {-2, 2}};
        System.out.println("Solution for example 2: " + minTimeToVisitAllPoints(points2));
        System.out.println("Solution for example 2 is " +
                (minTimeToVisitAllPoints(points2) == 5 ? "***CORRECT***" : "!!! WRONG !!!"));
    }

    // 0 ms solution
  /*  public static int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;
        int time = 0;
        for (int i = 0; i < n - 1; i++) {
            time += twoPointsTime(points[i], points[i + 1]);
        }
        return time;
    }

    private static int twoPointsTime(int[] start, int[] finish) {
        int hor = Math.abs(start[0] - finish[0]);
        int vert = Math.abs(start[1] - finish[1]);
        int shortDist = Math.min(hor, vert);
        int maxDist = Math.max(hor, vert);
        int remDist = maxDist - shortDist;
        return shortDist + remDist;
    }*/
// genius geometry solution
    public static int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        for (int i = 0; i < points.length - 1; i++) {
            time += twoPointsTime(points[i], points[i + 1]);

        }
        return time;
    }

    private static int twoPointsTime(int[] start, int[] finish) {
        return Math.max(Math.abs(start[0] - finish[0]), Math.abs(start[1] - finish[1]));
    }

}
