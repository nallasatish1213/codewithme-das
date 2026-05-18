package com.das.recursion.array;

public class CheckSorted {

    public static void main(String[] args) {
        int arrays[]= {1,4,6,5,7,9,14,16};
        System.out.println(sorted(arrays,0));
    }

    static boolean sorted(int[] arr,int i){

        if(i == arr.length-1){
            return true;
        }

        return arr[i]<arr[i+1] && sorted(arr,i+1);
    }
}
