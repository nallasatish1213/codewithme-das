package com.das.recursion;

public class RecursionBeforeTest {

    public static void main(String[] args) {
        // we need to print 1 to 5
        print1(1);
    }

    static void  print1(int i){
       System.out.println(i);
        print2(2);
    }

    static void  print2(int i){
        System.out.println(i);
        print3(3);
    }

    static void  print3(int i){
        System.out.println(i);
        print4(4);
    }

    static void  print4(int i){
        System.out.println(i);
        print5(5);
    }

    static void  print5(int i){
        System.out.println(i);
    }
}
