package com.das.hackerrank;

public class FizzBizzSolution {

    public static void main(String[] args) {
        int n=300;

        fizzBizzSolution(n);
    }

    private static void fizzBizzSolution(int n) {
        StringBuilder sb=new StringBuilder();
        // divided by 3&5 or 3 or 5
        for (int i = 1; i <= n; i++) {
            if((i%15) == 0){
                sb.append("FizzBizz");
            } else if ((i%3) == 0){
                sb.append("Fizz");
            } else if ((i%5) == 0){
                sb.append("Bizz");
            } else {
                sb.append(i);
            }
            sb.append("\n");
        }
        System.out.printf(sb.toString());
    }
}
