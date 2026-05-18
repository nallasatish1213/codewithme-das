package com.das.recursion;

public class RecursiveTest {

    public static void main(String[] args) {
        print(1);
    }

    static void print(int i){

        if(i==5){
            System.out.println(i);
            return;
        }

        System.out.println(i);
        // tail recursive
        print(i+1);
    }
}
