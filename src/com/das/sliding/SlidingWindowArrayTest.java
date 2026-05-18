package com.das.sliding;

public class SlidingWindowArrayTest {

    public static void main(String[] args) {
        int[] arr= {13,9,-4,38,6,20,1};
        int k=3;
        int max=findMaxNumberBetweenGivenSize(arr,k);
        System.out.println("findMaxNumberBetweenGivenSize: O(n*n): "+max);
        int slidMax=findMaxNumberUsingSlidingWindow(arr,k);
        System.out.println("findMaxNumberUsingSlidingWindow: O(n): "+slidMax);

    }

    static int findMaxNumberUsingSlidingWindow(int[] arr,int k){
        int sMax=0; int mMax=Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            sMax+=arr[i];
        }

        for (int j = k; j < arr.length; j++) {
            // here first sub tracking to first element of array and adding next possible element
            sMax=sMax-arr[j-k]+arr[j];
            if(sMax>mMax){
                mMax=sMax;
            }
        }
        return mMax;
    }

    static int findMaxNumberBetweenGivenSize(int[] arr,int k){
        int mMax=Integer.MIN_VALUE;

       int i=0;
       while(i < arr.length-k+1){
           int j=i;
           int sMax=0;
           while(j<k+i){
               sMax+=arr[j];
               j++;
           }

           if(sMax>mMax) {
               mMax=sMax;
           }
           i++;
       }
       return mMax;
    }
}
