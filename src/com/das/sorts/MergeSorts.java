package com.das.sorts;

import java.util.Arrays;

public class MergeSorts {

    public static void main(String[] args) {
      //  int[] unSorted={5,4,3,2,1};

        int[] unSorted={6,3,1,7,9,4,8,2,5,11,12,13};
       // int[] sorted= mergeSorts(unSorted);
       // System.out.println(Arrays.toString(sorted));

        mergeSortInPlace(unSorted,0,unSorted.length);
        System.out.println(Arrays.toString(unSorted));

    }

    static void mergeSortInPlace(int[] unSortedArr,int s, int e) {

        if(e-s == 1){
            return;
        }

        int mid=s+(e-s)/2;

        mergeSortInPlace(unSortedArr,s,mid);
        mergeSortInPlace(unSortedArr,mid,e);

        mergeInPlace(unSortedArr,s,mid,e);

    }

    private static void mergeInPlace(int[] arr, int s, int mid, int e) {

        int mix[]=new int[e-s];
        int i=s;
        int j=mid;
        int k = 0 ;

        while(i < mid && j < e){
            if(arr[i] < arr[j]){
                mix[k]= arr[i];
                i++;
            } else {
                mix[k]= arr[j];
                j++;
            }
            k++;
        }

        while(i<mid){
            mix[k]=arr[i];
            i++;
            k++;
        }

        while(j<e){
            mix[k]=arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length; l++) {
            arr[s + l] = mix[l];
        }

    }

    static int[] mergeSorts(int[] unSortedArr) {
        if(unSortedArr.length == 1){
            return unSortedArr;
        }

        int mid=unSortedArr.length/2;

        int[] left=mergeSorts(Arrays.copyOfRange(unSortedArr,0,mid));
        int[] right=mergeSorts(Arrays.copyOfRange(unSortedArr,mid,unSortedArr.length));
        return merge(left,right);
    }

    private static int[] merge(int[] left, int[] right) {
        // if you want to merge both left and right then you should be known about length
        // create merge array
        int[] mergeArray=new int[left.length+right.length];
        int i=0;  int j=0;  int m=0;
        while(i<left.length && j<right.length) {
            if(left[i]<right[j]){
                mergeArray[m]=left[i];
                i++;
            } else {
                mergeArray[m]=right[j];
                j++;
            }
            m++;
        }

        // it may be possible that one of the array is not completed
        // cope the remaining elements
        while(i< left.length){
            mergeArray[m] =left[i];
            i++;
            m++;
        }

        while(j< right.length){
            mergeArray[m] =right[j];
            j++;
            m++;
        }

        return mergeArray;

    }
}
