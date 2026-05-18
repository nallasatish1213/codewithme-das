package com.das.sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CycleSorts {

    /* cycle sort if any question saying like ( o to n lenght)
     you should use cycle sort for that program
    * (0 to n) n also find in the question like: 5
    * there is un sored order for that we can sort it by using cycle sort
    * Example:   int[] arrays={3,5,2,1,4}; here n=5
    *
    * Q: cycleSort technics  and swap
    * Q:  Find Missing Number &&  Find Missing Numbers
    * Q: find Missing Positive Number
    * */

    public static void main(String[] args) {

        //google: find the missing numbers in array

        int arrM[]= {4,1,-3, 3,-1,-2,};
        int arrM1[]= {2,0,1};
        System.out.println("Missing Positive Number: "+getMissingPositiveNumber(arrM1));

        int arr[]= {4,3,2,7,8,2,3,1};
        System.out.println(gMissingNumbers(arr));

       //missing number
        int[] missingArr={4,0,2,1};
        System.out.println(missingNumber(missingArr,4));

        int[] arrays={3,5,2,1,4};
        cycleSort(arrays);
        System.out.println(Arrays.toString(arrays));
    }

    static int getMissingPositiveNumber(int[] arr) {

        // 4,-1,3,1
        int i=0;
        int n=arr.length;
        while(i < n) {
            int correct= arr[i]-1;
            if( correct>=0 &&  arr[i] <=n  && arr[i] != arr[correct]) {
                swap(arr,i,correct);
            } else {
                i++;
            }
        }
        // 1, -1, 3, 4
        for (int j = 0; j < arr.length ; j++) {
            if(arr[j] != j+1) {
                return j+1;
            }
        }

        return arr.length+1;
    }

     static List<Integer> gMissingNumbers(int[] arr) {

         int i = 0;
        // int arr[]= {4,3,2,7,8,2,3,1};
         while (i<arr.length) {
         int correct = arr[i] - 1;
         if (arr[i] != arr[correct]) {
             swap(arr, i, correct);
         } else {
             i++;
         }
     }
    // after sorting: 1,2,3,4,3,2,7,8
         List<Integer> ans=new ArrayList<>();
         for (int j = 0; j < arr.length; j++) {
             if(arr[j] != j+1){
                 ans.add(j+1);
             }
         }
         return ans;
    }

    static int missingNumber(int[] arr,int n) {
        //  int[] missingArr={4,0,2,1};
        int i=0;
        while (i<n) {
            int correct= arr[i];
            if(arr[i]< arr.length && arr[i] != arr[correct]){
                swap(arr,i,correct);
            }else {
                i++;
            }
        }

       // int[] missingArr={0,1,2,4};
        for (int j = 0; j < arr.length; j++) {
           if(arr[j] != j){
               return j;
           }
        }
        return n;
    }

    static void cycleSort(int[] array){
        int start=0;
        while(start < array.length){
            int activalIndex= array[start]-1;

            if(array[start] != array[activalIndex]){
                swap(array,start,activalIndex);
            }else {
                start++;
            }
        }
    }

    public static void swap(int[] array,int a, int b) {
        int temp =array[a] ;
        array[a] = array[b];
        array[b] = temp;
    }
}
