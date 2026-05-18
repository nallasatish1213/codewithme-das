package com.das.math;

public class FindEvenOddNumber {

    public static void main(String[] args) {
        int value=67;
        findEvenOdd(value);
    }

    private static void findEvenOdd(int value) {
        if((value & 1) == 1){
            System.out.println("Odd Number: "+value);
        } else {
            System.out.println("Even Number: "+value);
        }
    }
}
