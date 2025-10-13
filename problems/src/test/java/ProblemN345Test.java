import leetcode.problems.ProblemN345ReverseVowelsOfAString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProblemN345Test {

    @Test
    void reverseVowelsTest() {
//        Assertions.assertEquals("test", com.denis.leetcode.problems.ProblemN345.reverseVowels(""));
        Assertions.assertEquals("AceCreIm", ProblemN345ReverseVowelsOfAString.reverseVowels("IceCreAm"), "Example 1 failed");
        Assertions.assertEquals("leotcede", ProblemN345ReverseVowelsOfAString.reverseVowels("leetcode"), "Example 2 failed");
    }
}