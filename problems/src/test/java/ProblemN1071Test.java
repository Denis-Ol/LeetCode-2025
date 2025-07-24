import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProblemN1071Test {

    @Test
    void gcdOfStringsTest() {
//        Assertions.assertEquals("test", ProblemN1071.gcdOfStrings("ABCABC", "ABC"), "Example 0-test failed");
        Assertions.assertEquals("ABC", ProblemN1071.gcdOfStrings("ABCABC", "ABC"), "Example 1 failed");
        Assertions.assertEquals("AB", ProblemN1071.gcdOfStrings("ABABAB", "ABAB"), "Example 2 failed");
        Assertions.assertEquals("", ProblemN1071.gcdOfStrings("LEET", "CODE"), "Example 3 failed");
    }
}