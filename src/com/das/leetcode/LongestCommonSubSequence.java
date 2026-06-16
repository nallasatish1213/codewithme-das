package com.das.leetcode;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubSequence {
    // BF: Brute Force
    // RECURvice
    // sub-sequence: we need to find out common sequence character in s1 by comparing s2
    public static void main(String[] args) {
    String s1="abcdef"; String s2="zcdemf";    //ans: 4
    // S1: abaaba,S2: babbab   ans: 4 (baba,abab)
    // String s3="ABCDE";   String s4="AXBYCZDE";   ans: 5 because: s1 all letters are available
    //     String s1="abcdef"; String s2="zcdemf";

   // Time complexity: O(n*m)
    int conutSubSequence=longestCommonSubSequenceDp(s1,s2,s1.length(),s2.length());
    System.out.println("LC Sub sequence count: "+ conutSubSequence);
        int[][] memo= new int[s1.length()+1][s2.length()+1];
        int conutSubSequenceRec=lcs(s1,s2,s1.length(),s2.length(),memo);
        System.out.println("LC Sub sequence rec count: "+ conutSubSequenceRec);


    //Time complexity: O(n*n*n)
    List<Character> conutSubSequenceBF=longestCommonSubSequence_BruteForce(s1,s2);
    System.out.println("LC Sub sequence BF count: "+ conutSubSequenceBF);
    }

    static  int longestCommonSubSequenceDp(String s1, String s2, int n, int m) {
     //   int count = 0;
        if (n == 0 && m == 0) {
            return -1;
        }
        int[][] dp = new int[n + 1][m + 1];

        if(dp[n][m] !=0) {
            return dp[n][m];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }


    static int lcs(String s1, String s2, int n, int m, int[][] memo ) {

        // Base case
        if (n == 0 || m == 0) {
            return 0;
        }

        // Already computed
        if (memo[n][m] != -1) {
            return memo[n][m];
        }

        // Characters match
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {

            memo[n][m] =
                    1 + lcs(s1, s2, n - 1, m - 1,memo);

        } else {

            memo[n][m] =
                    Math.max(
                            lcs(s1, s2, n - 1, m,memo),
                            lcs(s1, s2, n, m - 1,memo)
                    );
        }

        return memo[n][m];
    }


    static  List<Character>   longestCommonSubSequence_BruteForce(String s1, String s2) {
        List<Character> ans=new ArrayList<>();
       // int i=0;
       for(int i =0; i< s1.length();i++) {
           for(int j =0; j<s2.length();j++) {
               if(s2.charAt(j)==s1.charAt(i)){
                   ans.add(s1.charAt(i));
               }
           }
       }
       return ans;
    }

}
