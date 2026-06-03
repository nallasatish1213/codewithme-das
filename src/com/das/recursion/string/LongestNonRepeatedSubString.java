package com.das.recursion.string;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class LongestNonRepeatedSubString {

  //  https://leetcode.com/problems/maximum-repeating-substring/
  //  https://algo.monster/liteproblems/1668
    // need to fix this problems
    /*
    * "kipkipl" → repeating substring "kip" → output 3
    *  "ghijhil" → repeating substring "hi" → output 2
    * */
    public static void main(String[] args) {
        String s1="kipkipl";
        String s2="pwwkewxpw";
        int count =nonRepatedChar(s2);
        System.out.println("Count: "+count);
    }

 static  int nonRepatedChar(String s){
   //     int npLen=0;
        if(s.isEmpty()){
            return -1;
        }
        Set<Character> map=new LinkedHashSet<>();

        int l=0;
        int r=0;
        while (l<s.length() && r < s.length()){

            if(r!=0 && map.contains(s.charAt(r))) {
                map.remove(s.charAt(l));
                l++;
           //     npLen--;
            }
            map.add(s.charAt(r));
            r++;
          //  npLen++;
        }


      return map.size();
     }

}
