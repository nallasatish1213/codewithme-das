package com.test;

public class BSFindPeakInMoutain {

    public static void main(String[] args) {
        int[] arr= {0,2,4,6,7,8,5,3,1};
        int target=1;

        int index=search(arr,target);
        System.out.println(index);


    }

    static int search(int[] arr, int target) {
        int peak=peak(arr);
        int leftSearch= binarySearch(arr,target,0,peak);
        if (leftSearch != -1){
            return leftSearch;
            //System.out.println(leftSearch);
        }
        return binarySearch(arr,target,peak+1,arr.length-1);
    }

    static int binarySearch(int[] arr, int t, int s, int e) {
        boolean asc = arr[s] < arr[e];
        while (s <= e) {

            int m = s + (e - s) / 2;
             if (t == arr[m]) {
                return m;
            }

            if (asc) {
                if (t < arr[m]) {
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            } else {
                if (t > arr[m]) {
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            }
        }

        return -1;
    }

    static int peak(int[] arr){
        int s=0;
        int e=arr.length-1;
        int countL=0;
        while (s<e){
            countL=countL+1;
            int m=s+(e-s)/2;
            if(arr[m]>arr[m+1]){
                e=m;
            } else{
                s=m+1;
            }
        }
        return s;
    }



}
