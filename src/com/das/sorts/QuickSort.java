package com.das.sorts;

import java.util.Arrays;

public class QuickSort {

    // this is approach and try another approach
    public static void main(String[] args) {

        int[] unSorted={6,3,1,7,9,4,8,2,5,11,12,6,13};
        // int[] sorted= mergeSorts(unSorted);
        // System.out.println(Arrays.toString(sorted));

        quickSort(unSorted,0,unSorted.length-1);
        System.out.println(Arrays.toString(unSorted));

        Arrays.sort(unSorted);

    }

    static void quickSort(int[] arr, int low, int high){

        if(low>=high){
            return;
        }

        int s=low;
        int e=high;
        int m=s+(e-s)/2;
        int pivot=arr[m];

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

            quickSort(arr,low, e);
            quickSort(arr,s,high);

        }


    }
}
