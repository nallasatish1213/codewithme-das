package com.das.leetcode;

import java.util.HashSet;

public class  MaxRepeatingSubstring {





    public static void main(String[] args) {

        String s1 = "kipkipl";
        String s2 = "ghijhijlhi";

        System.out.println(longestRepeatingSubstring(s1));
      //  System.out.println(longestRepeatingSubstring(s2));

     //   System.out.println("LRS DP Solution :"+s2 + ": "+lrsDP(s2));


    }


    /* if you use Dynamic program (DP) then
    TC: O(n2)
    SC: O(n2)
    */

    static int lrsDP(String s){
        int n=s.length();
        int[][] dp=new int[n+1][n+1];
        int countMax=0;
        for (int i = 1; i <= n ; i++) {
            for (int j = i+1; j <= n ; j++) {
               if(s.charAt(i-1) == s.charAt(j-1)){
                   dp[i][j] = 1+dp[i-1][j-1];
                   countMax = Math.max(countMax,dp[i][j]);
               }
            }
        }
        return countMax;
    }

    /* Find the longest repeating substring length
     if you combine binary search with cache. cache might be hashset or map
     then time complexity  would be :  O(n2 log n)
     Space complexity: O(n2)
     */
    static int longestRepeatingSubstring(String s) {

        int low = 1;
        int high = s.length();
        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (hasRepeatingSubstring(s, mid)) {

                ans = mid;
                low = mid + 1;

            } else {

                high = mid - 1;
            }
        }

        return ans;
    }


    // Check whether repeating substring of given length exists
    static boolean hasRepeatingSubstring(String s, int len) {

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i <= s.length() - len; i++) {

            String sub = s.substring(i, i + len);

            if (set.contains(sub)) {
                return true;
            }

            set.add(sub);
        }

        return false;
    }
}