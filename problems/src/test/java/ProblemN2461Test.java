import leetcode.problems.ProblemN2461;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ProblemN2461Test {
    public static int[] readIntArrayFromFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            scanner.useDelimiter(","); // Set the delimiter to comma
            while (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found at path: " + filePath);
            return new int[0]; // Return an empty array if the file is not found
        }
        // Convert the ArrayList to an int array
        int[] intArray = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            intArray[i] = numbers.get(i);
        }
        return intArray;
    }

    @Test
    void maximumSubarraySumTest() {
//        Assertions.assertEquals(Integer.MIN_VALUE,
//                com.denis.leetcode.problems.ProblemN2461.maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3), "Example 0-test failed");
        Assertions.assertEquals(15,
                ProblemN2461.maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3), "Example 1 failed");
        Assertions.assertEquals(0,
                ProblemN2461.maximumSubarraySum(new int[]{4, 4, 4}, 3), "Example 2 failed");
        Assertions.assertEquals(3,
                ProblemN2461.maximumSubarraySum(new int[]{1, 2, 2}, 2), "Example 3 failed");
        Assertions.assertEquals(24,
                ProblemN2461.maximumSubarraySum(new int[]{1, 1, 1, 7, 8, 9}, 3), "Example 4 failed");
        Assertions.assertEquals(5000050000L,
                ProblemN2461.maximumSubarraySum(
                        readIntArrayFromFile("src/main/resources/100000int.txt"), 100000),
                "Example 5 failed");
    }
}