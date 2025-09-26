package others;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        String myString = " Hello    World    from    Java   ";

        Pattern wordPattern = Pattern.compile("\\S+");
        Matcher matcher = wordPattern.matcher(myString);

        List<String> wordsList = new ArrayList<>();

        // Find all matches and add them to the list
        while (matcher.find()) {
            wordsList.add(matcher.group());
        }

        String[] words = wordsList.toArray(new String[0]);

        System.out.println(java.util.Arrays.toString(words));

        System.out.println("\nWords:");
        for (String word : words) {
            System.out.println(word);
        }
        System.out.println("words[0] = " + words[0]);
    }
}