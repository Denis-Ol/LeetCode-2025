package leetcode.util;

import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {
    public static int[] readToIntArray(String filePath) throws IOException {
        String line = null;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            line = br.readLine();
        }

        if (line == null) {
            return new int[0]; // File is empty
        }

        // Use a stream to split and parse the numbers
        return Stream.of(line.split("\\s*,\\s*"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static int[] readCommaSeparatedInts(String filePath) throws IOException {
        // Use the classpath to find the resource file
        InputStream inputStream = Utils.class.getResourceAsStream(filePath);
        if (inputStream == null) {
            throw new IOException("Resource not found: " + filePath);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String content = reader.lines().collect(Collectors.joining());
            // Split the content by comma and trim whitespace
            String[] stringNumbers = content.split("\\s*,\\s*");

            return Stream.of(stringNumbers)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    public static String readFileToString(String filePath) throws IOException {
        InputStream inputStream = Utils.class.getResourceAsStream(filePath);
        if (inputStream == null) {
            throw new IOException("Resource not found: " + filePath);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }

}
