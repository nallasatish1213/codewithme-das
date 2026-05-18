package com.das.recursion;

public class RBinarySearch {

    public static void main(String[] args) {
        int[] arr={2,5,8,12,19,24,34,53,67,84,97};
        int target= 3;

        System.out.println(search(arr,target,0,arr.length));
    }

    private static int search(int[] arr, int target, int s, int e) {

        if(s>e){
            return -1;
        }

        int m=s+(e-s)/2;

        if(target ==arr[m]){
            return m;
        }

        if(target <arr[m]){
            return search(arr,target,s,m-1);
        }
        return search(arr,target,m+1,e);
    }
}
