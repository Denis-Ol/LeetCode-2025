import leetcode.problems.ProblemN283;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProblemN283Test {

    @Test
    void moveZeroesTest() {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        int[] expected = new int[]{1, 3, 12, 0, 0};
        ProblemN283.moveZeroes(nums);
        Assertions.assertArrayEquals(expected, nums);

        nums = expected = new int[]{0};
        ProblemN283.moveZeroes(nums);
        Assertions.assertArrayEquals(expected, nums);

        nums = expected = new int[]{1};
        ProblemN283.moveZeroes(nums);
        Assertions.assertArrayEquals(expected, nums);

        nums = expected = new int[]{1, 0};
        ProblemN283.moveZeroes(nums);
        Assertions.assertArrayEquals(expected, nums);

        nums = new int[]{0, 1};
        expected = new int[]{1, 0};
        ProblemN283.moveZeroes(nums);
        Assertions.assertArrayEquals(expected, nums);

        nums = new int[]{1, 0, 1};
        expected = new int[]{1, 1, 0};
        ProblemN283.moveZeroes(nums);
        Assertions.assertArrayEquals(expected, nums);

        nums = expected = new int[]{1, 2, 3};
        ProblemN283.moveZeroes(nums);
        Assertions.assertArrayEquals(expected, nums);
    }
}