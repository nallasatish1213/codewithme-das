package com.das.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class FindLongestCongitiveSubsequenceString {

    public static void main(String[] args) {
        // wedding, ababbacaabbbb
        String input="ababbacaabbbbc";
        int k=1;
        List<String> list=getKInterspaceSubstrings(input,k);
        System.out.println(list);
        List<String> list2=longestKInterspaceSubstrings(input,k);
        System.out.println(list2);

        System.out.println(longestKInterspaceSubstring(input,k));
    }

    public static String longestKInterspaceSubstring(String word, int k) {
        if (word == null || word.length() == 0) {
             return "";
        }
        int start = 0;
        int bestStart = 0;
        int maxLen = 1;
        for (int i = 1; i < word.length(); i++) {
            if (Math.abs(word.charAt(i) - word.charAt(i - 1)) > k) {
                start = i;
            }
            int currLen = i - start + 1;
            if (currLen > maxLen) {
                maxLen = currLen;
                bestStart = start;
            }
        }
        return word.substring(bestStart, bestStart + maxLen);
    }

    public static String longestKInterspaceSubstringDP(String word, int k) {

        int n = word.length();

        if (n == 0) {
            return "";
        }

        int[] dp = new int[n];
        dp[0] = 1;

        int maxLen = 1;
        int endIndex = 0;

        for (int i = 1; i < n; i++) {

            if (Math.abs(word.charAt(i) - word.charAt(i - 1)) <= k) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                endIndex = i;
            }
        }
        int startIndex = endIndex - maxLen + 1;

        return word.substring(startIndex, endIndex + 1);
    }

    public static List<String> longestKInterspaceSubstrings(String word, int k) {

        List<String> result = new ArrayList<>();

        if (word == null || word.isEmpty()) {
            return result;
        }

        int start = 0;
        int maxLen = 1;

        for (int i = 1; i < word.length(); i++) {

            if (Math.abs(word.charAt(i) - word.charAt(i - 1)) > k) {
                int len = i - start;

                if (len > maxLen) {
                    maxLen = len;
                    result.clear();
                    result.add(word.substring(start, i));
                } else if (len == maxLen) {
                    result.add(word.substring(start, i));
                }

                start = i;
            }
        }

        int len = word.length() - start;

        if (len > maxLen) {
            result.clear();
            result.add(word.substring(start));
        } else if (len == maxLen) {
            result.add(word.substring(start));
        }

        return result;
    }


    public static List<String> getKInterspaceSubstrings(String word, int k) {

        List<String> result = new ArrayList<>();

        if (word == null || word.isEmpty()) {
            return result;
        }

        int start = 0;

        for (int i = 1; i < word.length(); i++) {

            if (Math.abs(word.charAt(i) - word.charAt(i - 1)) > k) {
                result.add(word.substring(start, i));
                start = i;
            }
        }

        result.add(word.substring(start));

        return result;
    }

}
