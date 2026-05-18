package com.das.recursion;

public class FactorialTest {

    public static void main(String[] args) {
    // factorial
        System.out.println(factorial(5));

    // sum
        System.out.println("Sum: "+sum(5));
    // sum of digit
        System.out.println("Sum of digit: "+sumOfDigit(1234));

    // concepts

    // reverse number 1

     // reverse number 2

    // palindrome  mean first and last number are same or not and move over
    // input: 123321 or 123321

   // count the number of zero in input
   //input: n=30204   op: 2

    }

   static int  countDigit(int n){
       return countHelper(n,0);
    }

     static int countHelper(int n, int i) {
        if(n==0){
            return i;
        }

        int rem=n%10;
        if(rem==0){
            return countHelper(n/10,i+1);
        }

        return countHelper(n/10,i);
    }


    static int sum=0;

    static int  reverseNumber2(int n){
        int rem=(int) Math.log10(n)+1;
        return helper(n,rem);
    }

    private static int helper(int n, int digits) {
        if(n%10 ==n){
            return n;
        }

        int rem=n%10;
        return rem*(int)(Math.pow(10,digits-1))+ helper(n/10,digits);

    }

    static void  reverseNumber1(int n){
        if(n==0){
            return;
        }
        int rem=n%10;
        sum=sum*10+rem;
        reverseNumber1(n/10);
   }



    static int concepts(int n){
        if(n==0){
            return 0;
        }

        System.out.println(n);
        return concepts(--n); // you can use like n-1 but dont use like: n--
    }



    static int sumOfDigit(int n){
        if (n==0){
            return 0;
        }
        int rem=n%10;
        int r=n/10;

        return rem+ sumOfDigit(r);

    }

    static int sum(int n){
        if(n<=1){
            return 1;
        }

        return n+sum(n-1);
    }

    static int factorial(int n){
        if(n<=1){
            return 1;
        }

        return n*factorial(n-1);
    }
}
