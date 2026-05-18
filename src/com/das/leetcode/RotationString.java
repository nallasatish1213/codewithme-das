package com.das.leetcode;

public class RotationString {

    public static void main(String[] args) {
        System.out.println(rotatedString("abcde","deabc"));
    }

    static boolean rotatedString(String s, String goal) {
        if(s.length() !=goal.length()){
            return false;
        }

        String join=s+s;
        if(join.contains(goal)){
            return true;
        }

        return false;
    }
}
