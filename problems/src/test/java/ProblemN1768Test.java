import leetcode.problems.ProblemN1768;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProblemN1768Test {

    @Test
    void mergeAlternatelyTest() {
        Assertions.assertEquals("test", "te" + "st");
//        Assertions.assertEquals("test", com.denis.leetcode.problems.ProblemN1768.mergeAlternately("abc", "pqr"));
        Assertions.assertEquals("apbqcr", ProblemN1768.mergeAlternately("abc", "pqr"), "Example 1 failed");
        Assertions.assertEquals("apbqrs", ProblemN1768.mergeAlternately("ab", "pqrs"), "Example 2 failed");
        Assertions.assertEquals("apbqcd", ProblemN1768.mergeAlternately("abcd", "pq"), "Example 3 failed");
    }
}