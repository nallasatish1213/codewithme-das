package com.das.recursion.string;

import java.util.ArrayList;
import java.util.List;

public class LongestSubStringWIthoutRepatingCount {

  //  https://leetcode.com/problems/maximum-repeating-substring/
  //  https://algo.monster/liteproblems/1668
    // need to fix this problems
    /*
    * "kipkipl" → repeating substring "kip" → output 3
    *  "ghijhil" → repeating substring "hi" → output 2
    * */
    public static void main(String[] args) {
        repatedChar("kipkipl");
    }

 static  int repatedChar(String s){

        if(s.isEmpty()){
            return -1;
        }

         String resL="";
        String res="";
        // kipkipl, jhighiasd
        String[] str=s.split("");
     for (int i = 0; i <s.length() ; i++) {
            String ch=str[i];
         if(!res.contains(ch)) {
             resL="";
            res=res+ch;
        } else {

         }

         if(s.contains(res)){
             resL=res;
         }
     }


     return res.length();
 }
}
