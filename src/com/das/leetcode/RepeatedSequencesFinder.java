package com.das.leetcode;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class RepeatedSequencesFinder {

    /**
     * Finds all consecutive repeated character sequences in a string.
     * Example: "aaabbaaacccbb" -> ["aaa", "bb", "aaa", "ccc", "bb"]
     */
    public static List<String> findRepeatedSequences(String input) {
        if (input == null || input.isEmpty()) {
            return Collections.emptyList();
        }

        // Regex: (.)\1+ means "capture a char, then match it again one or more times"
        Pattern pattern = Pattern.compile("(.)\\1+");
        Matcher matcher = pattern.matcher(input);

        List<String> results = new ArrayList<>();
        while (matcher.find()) {
            results.add(matcher.group());
        }
        return results;
    }

    public static void main(String[] args) {
        List<String> examples = Arrays.asList(
            "aaabbaaacccbb",
            "Hello faaantastic worlddd",
            "This is an example",
            "Another  example ..."
        );

        for (String example : examples) {
            List<String> repeats = findRepeatedSequences(example);
            System.out.println("Input: " + example);
            System.out.println("Repeated sequences: " + repeats);
            System.out.println();
        }
    }
}
