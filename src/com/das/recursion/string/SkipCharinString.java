package com.das.recursion.string;

public class SkipCharinString {

    public static void main(String[] args) {

  skipChar("baccdah","");
    }

    static void skipChar(String value,String output){
        if(value.isEmpty()){
            System.out.println(output);
            return;
        }

        char c=value.charAt(0);
        if(c == 'a'){
            skipChar(value.substring(1),output);
        } else {
           skipChar(value.substring(1),output+c);
        }
    }
}
