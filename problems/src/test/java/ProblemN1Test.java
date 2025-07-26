import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProblemN1Test {

    @Test
    void twoSumTest() {
        int[] result = ProblemN1.twoSum(new int[]{2, 7, 11, 15}, 9);
        Assertions.assertEquals(53,
                ProblemN53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}),
                "Example 0-test failed");
    }
}