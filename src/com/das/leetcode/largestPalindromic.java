package com.das.leetcode;

public class largestPalindromic {

    public static void main(String[] args) {
        // 444947137, 444847137, 00009
        System.out.println("largestPalindromic: "+largestPalindromic("00000909"));
    }

    public static String largestPalindromic(String num) {

        String zeroNum=num.replaceFirst("^0+(?!$)","");
        int[] freq = new int[10];

        for(char ch : zeroNum.toCharArray()) {
            freq[ch - '0']++;
        }

        // for(int f : freq) System.out.print(f + " ");

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 10; i++) {
            if(freq[i] > 0) {
                int half = freq[i] / 2;
                char ch = (char) (i + '0');
                sb.append(String.valueOf(ch).repeat(half));
                sb.insert(0, String.valueOf(ch).repeat(half));
                freq[i] -= 2 * half;
            }
        }

        for(int i = 9; i >= 0; i--) {
            if(freq[i] > 0) {
                sb.insert(sb.length() / 2, i);
                break;
            }
        }

        // leading zeros

        if(sb.charAt(0) != '0') {
            return sb.toString();
        }

        int i = 0;
        int n = sb.length();

        for(; i < sb.length(); i++) {
            if(sb.charAt(i) != '0') break;
        }

        if(i == n) return "0";

        return sb.toString().substring(i, n - i);

    }


    public static String largestPalindromic2(String num) {
        String zeroNum=num.replaceFirst("^0+(?!$)","");
        int[] freq = new int[10];

        // Count frequency
        for (char c : zeroNum.toCharArray()) {
            freq[c - '0']++;
        }

        StringBuilder left = new StringBuilder();

        // Build left half
        for (int i = 9; i >= 0; i--) {

            // Avoid leading zero
            if (i == 0 && left.length() == 0)
                break;

            while (freq[i] >= 2) {
                left.append(i);
                freq[i] -= 2;
            }
        }

        // Choose middle digit
        StringBuilder middle = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (freq[i] > 0) {
                middle.append(i);
                break;
            }
        }

        // Edge case: only zeros
        if (left.length() == 0 && middle.length() == 0)
            return "0";

        String right = new StringBuilder(left).reverse().toString();

        return left.toString() + middle + right;
    }
}
