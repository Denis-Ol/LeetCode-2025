import leetcode.problems.ProblemN1071GreatestCommonDivisorOfStrings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProblemN1071Test {

    @Test
    void gcdOfStringsTest() {
//        Assertions.assertEquals("test", com.denis.leetcode.problems.ProblemN1071.gcdOfStrings("ABCABC", "ABC"), "Example 0-test failed");
        Assertions.assertEquals("ABC", ProblemN1071GreatestCommonDivisorOfStrings.gcdOfStrings("ABCABC", "ABC"), "Example 1 failed");
        Assertions.assertEquals("AB", ProblemN1071GreatestCommonDivisorOfStrings.gcdOfStrings("ABABAB", "ABAB"), "Example 2 failed");
        Assertions.assertEquals("", ProblemN1071GreatestCommonDivisorOfStrings.gcdOfStrings("LEET", "CODE"), "Example 3 failed");
    }
}