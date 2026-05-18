package com.das.recursion;

public class Nto1 {

    public static void main(String[] args) {

        // print 5, 4, 3, 2, 1
        funDec(5);
        funAsc(5);
    }

    static void funDec(int n){

        if(n==0){
            return;
        }
        System.out.print(n+" ");

        funDec(n-1);
    }

    static void funAsc(int n){

        if(n==0){
            return;
        }
        funAsc(n-1);
        System.out.print(n+" ");


    }
}
