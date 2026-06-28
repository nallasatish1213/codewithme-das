package com.das.binarysearch;

import java.util.Arrays;

public class FindFirstAndLastIndex {

    public static void main(String[] args) {

        int[] input={3,5,7,7,7,7,7,8,8,9};
        int target=8;
        int[] result={-1,-1};
        result[0]=search(input,target,true);
        if(result[0] != -1){
            result[1]=search(input,target,false);
        }
        System.out.println("Find first and last of index of given target: "+ Arrays.toString(result));
    }

    static int search(int[] input, int target, boolean isStartIndex){

        int start=0;
        int end=input.length-1;

        int ans=-1;
        while(start<=end) {

            int mid=start+(end-start)/2;
            if(target<input[mid]){
                end=mid-1;
            } else if (target>input[mid]) {
                start=mid+1;
            } else {
                ans= mid;
                if(isStartIndex){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
        }
        return ans;
    }
}
