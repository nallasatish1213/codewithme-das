package com.test;

public class BSFindPeakInMoutain {

    public static void main(String[] args) {
        int[] arr= {0,2,4,6,7,8,5,3,1};
        int target=3;
       int peak= findPeak(arr);

       int checkLeft=findNumberBS(arr,target,0, peak);
       if(checkLeft != -1) {
           System.out.printf("peaks: " + peak+": target: "+ checkLeft);
       } else {
        int checkRight  = findNumberBS(arr, target, peak + 1, arr.length-1);
           System.out.printf("peaks: " + peak+": target: "+ checkRight);
       }
    }

    private static int findNumberBS(int[] arr, int target, int s, int e) {
    // {0,2,4,6,7,8,5,3,1};
        boolean asc=arr[s]<arr[e];

        while(s<=e){
            int m=s+(e-s)/2;
            if(target == arr[m]){
                return m;
            }

            if(asc){
                if(target<arr[m]){
                    e=m-1;
                } else {
                    s=m+1;
                }
            } else{
                if(target>arr[m]){
                    e=m-1;
                } else {
                    s=m+1;
                }
            }
        }
        return -1;
    }

    private static int findPeak(int[] arr) {
        int s=0;
        int e=arr.length-1;

        while(s<e){

            int m=s+(e-s)/2;
            if(arr[m]>arr[m+1]){
                e=m;
            }else {
                s=m+1;
            }
        }
        return s;
    }


}
