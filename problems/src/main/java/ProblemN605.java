public class ProblemN605 {
    /*
    605. Can Place Flowers
Easy, Topics: Array, Greedy

You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.


Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: true

Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: false

Constraints:
    1 <= flowerbed.length <= 2 * 10^4
    flowerbed[i] is 0 or 1.
    There are no two adjacent flowers in flowerbed.
    0 <= n <= flowerbed.length

*/
    public static void main(String[] args) {
        System.out.println("Hello LeetCode #605");
        System.out.println("Solution for example 1: " + canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println("Solution for example 2: " + canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        System.out.println("Solution for test 1: " + canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 0));
        System.out.println("Solution for test 2: " + canPlaceFlowers(new int[]{0}, 1));
        System.out.println("Solution for test 3: " + canPlaceFlowers(new int[]{1}, 1));
        System.out.println("Solution for test 4: " + canPlaceFlowers(new int[]{0, 0}, 1));
        System.out.println("Solution for test 5: " + canPlaceFlowers(new int[]{0, 0}, 2));
        System.out.println("Solution for test 6: " + canPlaceFlowers(new int[]{0, 0, 0}, 2));
        System.out.println("Solution for test 7: " + canPlaceFlowers(new int[]{0, 0, 0}, 3));
        System.out.println("Solution for test 8: " + canPlaceFlowers(new int[]{0, 0, 0, 0, 0, 0}, 4));
    }

    /**
     * public static boolean canPlaceFlowers(int[] flowerbed, int n) {
     * if (n == 0) {
     * return true;
     * }
     * <p>
     * int size = flowerbed.length;
     * <p>
     * if (size == 1) {
     * return flowerbed[0] == 0;
     * }
     * if (size < 2 * n - 1) {
     * return false;
     * }
     * <p>
     * if (size == 2) {
     * return flowerbed[0] + flowerbed[1] == 0; //probably could be included below
     * }
     * <p>
     * //size >= 3 - search for place, plant, reduce n by 1 and call reduced.
     * //        left edge case: 0 and 0 -> plant in [0]
     * if (flowerbed[0] + flowerbed[1] == 0) {
     * flowerbed[0] = 1;
     * return canPlaceFlowers(flowerbed, n - 1);
     * }
     * <p>
     * int i = 1;
     * while (i < size - 1) {
     * if (flowerbed[i - 1] + flowerbed[i] + flowerbed[i + 1] == 0) {
     * flowerbed[i] = 1;
     * return canPlaceFlowers(flowerbed, n - 1);
     * } else {
     * i++;
     * }
     * }
     * <p>
     * //right edge case
     * if (flowerbed[size - 2] + flowerbed[size - 1] == 0) {
     * flowerbed[size - 1] = 1;
     * return canPlaceFlowers(flowerbed, n - 1);
     * }
     * <p>
     * return false;
     * }
     */

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }

        int size = flowerbed.length;

        if (size == 1) {
            return flowerbed[0] == 0;
        }

        if (size < 2 * n - 1) {
            return false;
        }

        if (size == 2) {
            return flowerbed[0] + flowerbed[1] == 0; //probably could be included below
        }

        //size >= 3 - search for place, plant, reduce n by 1

//        left edge case: 0 and 0 -> plant in [0]
        if (flowerbed[0] + flowerbed[1] == 0) {
            flowerbed[0] = 1;
            --n;
        }
        int i = 1;
        while (n > 0 && i < size - 1) {
            if (flowerbed[i - 1] + flowerbed[i] + flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                --n;
            } else {
                i++;
            }
        }

//right edge case
        if (n > 0 && flowerbed[size - 2] + flowerbed[size - 1] == 0) {
            flowerbed[size - 1] = 1;
            --n;
        }
        return n <= 0;
    }
}
