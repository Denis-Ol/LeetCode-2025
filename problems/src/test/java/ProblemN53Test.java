import leetcode.problems.ProblemN53;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProblemN53Test {

    @Test
    void maxSubArrayTest() {
//        Assertions.assertEquals(53,
//                com.denis.leetcode.problems.ProblemN53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}),
//                "Example 0-test failed");
        Assertions.assertEquals(6,
                ProblemN53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}),
                "Example 1 failed");
        Assertions.assertEquals(1,
                ProblemN53.maxSubArray(new int[]{1}),
                "Example 2 failed");
        Assertions.assertEquals(23,
                ProblemN53.maxSubArray(new int[]{5, 4, -1, 7, 8}),
                "Example 3 failed");
        Assertions.assertEquals(-1,
                ProblemN53.maxSubArray(new int[]{-1, -1, -5}),
                "Example 4 failed");
        Assertions.assertEquals(1,
                ProblemN53.maxSubArray(new int[]{-2, 1,}),
                "Example 5 failed");
        Assertions.assertEquals(1,
                ProblemN53.maxSubArray(new int[]{1, -3,}),
                "Example 6 failed");
    }
}