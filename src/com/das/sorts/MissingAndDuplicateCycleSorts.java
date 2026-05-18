package com.das.sorts;

import java.util.ArrayList;
import java.util.List;



public class MissingAndDuplicateCycleSorts {

    public static void main(String[] args) {

        //find the missing number in given 1 to n numbers using cycle sorts
        int arr[] = {4, 3, 2, 7, 8, 2, 3, 1};
        //   System.out.println("Missing Number in given array: "+ findMissingNumber(arr));

        // way 2
        int arr2[] = {4, 3, 2, 7, 0, 8, 2, 3, 1};
        //       findMissingNumber2(arr2);

        // find the duplicate

        int[] dupArr = {2, 4, 1, 3, 5, 2};
        System.out.println(findDuplicate(dupArr));

        int[] dups = {2, 4, 6, 3, 1,0, 5, 2, 4,3,6};
        System.out.println(findDuplicates(dups));
    }

    private static List<Integer> findDuplicates(int[] dupArr) {
        int i = 0;
        while (i < dupArr.length) {
            int correct = dupArr[i];
            if (dupArr[i] < dupArr.length && dupArr[i] != dupArr[correct]) {
                swap(dupArr, i, correct);
            } else {
                i++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < dupArr.length; j++) {
            if (dupArr[j] != j ) {
                ans.add(dupArr[j]);
            }
        }
        return ans;
    }
    private static int findDuplicate(int[] dupArr) {
        int i=0;
        while(i<dupArr.length){
            if(dupArr[i] != i+1) {
                int correct= dupArr[i]-1;
                if(dupArr[i] != dupArr[correct]){
                    swap(dupArr,i,correct);
                }else {
                    return dupArr[i];
                }
            } else {
                i++;
            }
        }
        return -1;
    }


    static List<Integer> findMissingNumber(int[] arr){

        int i =0;
        while(i<arr.length){
                int correctIndex = arr[i] - 1;
                if (arr[i] != arr[correctIndex]) {
                    swap(arr, i, correctIndex);
                } else {
                        i++;
                }
            }
        // 1 ,2 ,3 ,4 ,3, 2, 7, 8
        List<Integer> ans=new ArrayList<>();
        for (int j = 0; j < arr.length; j++) {
            if(arr[j] != j+1) {
                ans.add(j+1);
            }
        }
        return ans;
    }

    private static void swap(int[] arr, int i, int correctIndex) {

        int temp=arr[i];
        arr[i]=arr[correctIndex];
        arr[correctIndex]=temp;
    }


    static void  findMissingNumber2(int[] arr){
        int n=arr.length-1;
        // Use a boolean array to mark presence
        boolean[] present = new boolean[arr.length]; // size = 9

        for (int num : arr) {
            if (num >= 0 && num <= n) {
                present[num] = true;
            }
        }

        // Collect missing numbers
        List<Integer> missing = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (!present[i]) {
                missing.add(i);
            }
        }
        System.out.println("Missing numbers: " + missing);
    }
}