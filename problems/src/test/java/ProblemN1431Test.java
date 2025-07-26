import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class ProblemN1431Test {

    @Test
    void kidsWithCandiesTest() {
//        Assertions.assertEquals(new ArrayList<>(Arrays.asList(new Boolean[]{true, false})),
//                ProblemN1431.kidsWithCandies(new int[]{}, 3), "Example 0-test failed");

        Assertions.assertEquals(new ArrayList<>(Arrays.asList(new Boolean[]{true, true, true, false, true})),
                ProblemN1431.kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3), "Example 1 failed");

        Assertions.assertEquals(new ArrayList<>(Arrays.asList(new Boolean[]{true, false, false, false, false})),
                ProblemN1431.kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1), "Example 2 failed");

        Assertions.assertEquals(new ArrayList<>(Arrays.asList(new Boolean[]{true, false, true})),
                ProblemN1431.kidsWithCandies(new int[]{12, 1, 12}, 10), "Example 3 failed");
    }
}