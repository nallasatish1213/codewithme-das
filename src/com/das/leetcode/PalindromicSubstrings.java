package com.das.leetcode;

public class PalindromicSubstrings {

//  https://github.com/nikoo28/java-solutions/blob/master/src/main/java/leetcode/medium/PalindromicSubstrings.java
  public static void main(String[] args) {
    String ip1="bb";
    String ip2="bab";
    String ip3="aaccb";  // acbca
    int count= countSubstrings(ip3);

    System.out.println("PalindromicSubstrings:  "+ count);
  }

 static  int countSubstrings(String s) {

    int count = 0;

    for (int i = 0; i < s.length(); i++) {

      // Count palindromes with odd length
      count += countPalindromes(s, i, i);

      // Count palindromes with even length
      count += countPalindromes(s, i, i + 1);
    }

    return count;

  }

  private static int countPalindromes(String s, int left, int right) {
    int count = 0;

    // Check for palindromes
    while (left >= 0 && right < s.length()
            && s.charAt(left) == s.charAt(right)) {
      count++;
      left--;
      right++;
    }

    return count;
  }

}