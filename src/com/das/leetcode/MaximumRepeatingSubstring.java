package com.das.leetcode;

public class MaximumRepeatingSubstring {

    public static void main(String[] args) {
        int countMaxSubSequence=maxRepeating("ababacababab","ab");
        System.out.println(countMaxSubSequence);
    }

    public static int maxRepeating(String sequence, String word) {

        String findWord=word;
        int count=0, began=0;
        while(true) {
        int idx=sequence.substring(began).indexOf(findWord);
        if(idx == -1){
            return count;
        } else{
            count++;
            findWord+=word;
            began=idx;
        }
        }
    }
}
