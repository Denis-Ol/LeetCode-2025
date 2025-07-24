import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProblemN345Test {

    @Test
    void reverseVowelsTest() {
//        Assertions.assertEquals("test", ProblemN345.reverseVowels(""));
        Assertions.assertEquals("AceCreIm", ProblemN345.reverseVowels("IceCreAm"), "Example 1 failed");
        Assertions.assertEquals("leotcede", ProblemN345.reverseVowels("leetcode"), "Example 2 failed");
    }
}