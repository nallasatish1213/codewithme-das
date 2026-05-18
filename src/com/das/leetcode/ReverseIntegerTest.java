package com.das.leetcode;

public class ReverseIntegerTest {

    public static void main(String[] args) {

      //  int revNumber=reverseInteger(121);

        int revNumber=reverseInteger2(1211);
        System.out.println("Reverse number: "+ revNumber);

        System.out.println("String rev: "+reverseString("abcd"));
    }

    static String reverseString(String value){
       String rev="";
       char[] ch=value.toCharArray();
        for (int i = ch.length-1; i >=0 ; i--) {
            rev=rev+ch[i];
        }
       return rev;
    }
    static int reverseInteger(Integer value){

        int reverse=0;
        while(value !=0){
            int digit=value %10;
            reverse=reverse*10+digit;
            value=value/10;
        }
        return reverse;
    }

    static int reverseInteger2(Integer value){
        // this below line of code will be return length of integer value
        // but first index number should not start with zero
        return (int)Math.log10(value)+1;
    }
}
