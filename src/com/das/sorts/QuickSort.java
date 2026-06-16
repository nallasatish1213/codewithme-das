package com.das.sorts;

import java.util.Arrays;

public class QuickSort {

    // Approve

    // this is approach and try another approach
    public static void main(String[] args) {

        int[] unSorted={6,3,1,7,9,4,8,2,5,11,12,6,13};
        // int[] sorted= mergeSorts(unSorted);
        // System.out.println(Arrays.toString(sorted));

        quickSortRecev(unSorted,0,unSorted.length-1);
        System.out.println(Arrays.toString(unSorted));

       // Arrays.sort(unSorted);

    }

    static void quickSortRecev(int[] arr, int low, int high){

        if(low>=high){
            return;
        }

        int s=low;
        int e=high;
        int m=s+(e-s)/2;
        int pivot=arr[m];  // like target

        while(s<=e){
            while(arr[s] < pivot){
                s++;
            }

            while(arr[e]>pivot){
                e--;
            }

            if(s<=e){
                int temp=arr[s];
                arr[s]=arr[e];
                arr[e]=temp;
                s++;
                e--;
            }

            // now  my pivot is correct index please sort remaining element
            quickSortRecev(arr,s,high);
            quickSortRecev(arr,low, e);
        }

    }
}
