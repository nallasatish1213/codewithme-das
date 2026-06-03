package com.das.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubString {
    // BF: Brute Force
    // RECURvice
    public static void main(String[] args) {
    String s1="abaaba"; String s2="babbab";
    // S1: abaaba,S2: babbab /   String s1="abcdef"; String s2="zcdemf";
   /* int conutSubString=longestCommonSubStringDp(s1,s2,s1.length(),s2.length());
    System.out.println("LC Substring count: "+ conutSubString);

    int conutSubSequence=longestCommonSubSequenceDp(s1,s2,s1.length(),s2.length());
    System.out.println("LC Sub sequence count: "+ conutSubSequence);

        int conutSubSequenceRec=lcs(s1,s2);
        System.out.println("LC Recursive Sub sequence count: "+ conutSubSequenceRec);
        String s3="AGGTAB";   String s4="GXTXAYB";  // ans: either A or G T A B  len:1
        S1 = ABCDE
        S2 = AXBYCZDE   ans: DE len:2

        String s1 = "abcdef";
        String s2 = "zcdemf";

        */


        String s3="abcdef";   String s4="zcdemf";
       /* List<String> subString =  longestCommonSubstringBF(s3,s4);
       // String subString =  longestCommonSubstringBF(s3,s4);
        System.out.println("LC Sub String  Value: "+ subString);

        */

        String subString =  longestCommonSubstringBF(s3,s4);
        System.out.println("LC Sub String  Value: "+ subString);

        int subStringCountDP =  longestCommonSubStringDp(s3,s4,s3.length(),s4.length());
        System.out.println("LC Sub dp  count: "+ subStringCountDP);

        // need to fix this method not correct
        int subStringCount =  longestCommonSubstringRec(s3,s4);
      //  System.out.println("LC Sub recursive  count: "+ subStringCount);
    }


    static  int longestCommonSubStringDp(String s1, String s2, int n, int m) {
        int count = 0;
        if (n < 0 && m < 0) {
            return count;
        }

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    count = Math.max(count, dp[i][j]);
                }
            }
        }
        return count;
    }

    static  String longestCommonSubstringBF(String s1, String s2) {
      // List<String> longest = new ArrayList<>();
        String longest="";
        for (int i = 0; i < s1.length(); i++) {
            for (int j = i + 1; j <= s1.length(); j++) {
                String sub = s1.substring(i, j);
                if (s2.contains(sub) &&
                        sub.length() > longest.length()) {
                    longest=sub;
                 //   longest.add(sub) ;
                }
            }
        }
        return longest;
    }

    static  int longestCommonSubstringRec(String s1, String s2) {
        return recursionLCS(s1,s2,s1.length(),s2.length(),0);
    }

    private static int recursionLCS(String s1, String s2, int i, int j, int ans) {
        if(i== 0 ||j==0){
            return ans;
        }
        //  int count=0;
        if(s1.charAt(i-1)== s2.charAt(j-1)) {
            return  ans = 1+recursionLCS(s1,s2,i-1,j-1,ans);
        }
        return Math.max(recursionLCS(s1,s2,i-1,j,ans), recursionLCS(s1,s2,i,j-1,ans));
    }

}
