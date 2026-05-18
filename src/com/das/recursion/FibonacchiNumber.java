package com.das.recursion;

public class FibonacchiNumber {

    public static void main(String[] args) {

        System.out.println(fibo(5));
    }

    static int fibo(int n) {
        if (n<2){
            return n;
        }

        // this not a tail recursion
        return fibo(n-1)+fibo(n-2);

    }
}
