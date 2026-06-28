package com.das.sorts;

import java.util.Arrays;
import java.util.concurrent.Executors;

public class SelectionSorts {

    public static void main(String[] args) {
        int[] array = {24, 19, 14, 1, 47, 5, 34, 56, 4, 19};
        selectionSortsByDesc(array, array.length);
        System.out.println("Selection Sort By Desc: "+ Arrays.toString(array));

        int[] array2 = {24, 14, 1, 47, 5, 34, 56, 4, 19, 1};
        bubbleSort(array2);
        System.out.println("bubbleSort: "+ Arrays.toString(array2));

        /* i=0
        1st: j=0: 14, 24, 1,  47, 5, 34, 56, 4, 19
         2st: j=1: 14, 1, 24,  47, 5, 34, 56, 4, 19
         3st: j=2: 14, 1, 24,  47, 5, 34, 56, 4, 19
          4st: j=3: 14, 1, 24,  5, 47, 34, 56, 4, 19
           5st: j=4: 14, 1, 24,  5, 34, 47, 56, 4, 19
            6st: j=5: 14, 1, 24,  5, 34, 47, 56, 4, 19
             7st: j=6: 14, 1, 24,  5, 34, 47, 4, 56, 19
             8st: j=7: 14, 1, 24,  5, 34, 47, 4, 19, 56

            i=1
            j=0 :  1, 14, 24,  5, 34, 47, 4, 19, 56
            j=1 :  1, 14, 24,  5, 34, 47, 4, 19, 56
            j=2 :  1, 14, 5,  24, 34, 47, 4, 19, 56
            j=3 :  1, 14, 5,  24, 34, 47, 4, 19, 56
            j=4 :  1, 14, 5,  24, 34, 47, 4, 19, 56
            j=5 :  1, 14, 5,  24, 34, 4, 47, 19, 56
            j=6 :  1, 14, 5,  24, 34, 4, 19, 47, 56

            i=2

            j=0 :  1, 14, 5,  24, 34, 4, 19, 47, 56
            j=1 :   1, 5, 14,  24, 34, 4, 19, 47, 56
            j=2 :   1, 5, 14,  24, 34, 4, 19, 47, 56
            j=3 :  1, 5, 14,  24, 34, 4, 19, 47, 56
            j=4 :  1, 5, 14,  24, 4, 34, 19, 47, 56
            j=5 :    1, 5, 14,  24, 4, 19, 34, 47, 56

             i=3
              j=0 :    1, 5, 14,  24, 4, 19, 34, 47, 56
              j=1 :    1, 5, 14,  24, 4, 19, 34, 47, 56
              j=2 :    1, 5, 14,  24, 4, 19, 34, 47, 56
              j=3 :    1, 5, 14,  4, 24, 19, 34, 47, 56
               j=4 :    1, 5, 14,  4, 19, 24, 34, 47, 56

                 i=4
               j=0 :    1, 5, 14,  4, 19, 24, 34, 47, 56
                j=1 :    1, 5, 14,  4, 19, 24, 34, 47, 56
                 j=2 :    1, 5, 4,  14, 19, 24, 34, 47, 56

                   i=5
               j=0 :    1, 5, 4, 14, 19, 24, 34, 47, 56
                j=1 :    1, 4, 5,  14, 19, 24, 34, 47, 56

        */

    }


//Executors
    static void bubbleSort(int[] array){
        //24, 14, 1, 47, 5, 34, 56, 4, 19, 1
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <array.length-i-1 ; j++) {
                if(array[j+1]<array[j]){
                    swap(array,j,j+1);
                }
            }
        }
    }

  //  int[] array = {24, 14, 1, 47, 5, 34, 56, 4, 19};
    private static void selectionSortsByDesc(int[] array, int n) {
        // finding the max/min value and keeping right place
        for (int i = 0; i < n - 1; i++) {
            int max = i;
            for (int j = i+1; j < n; j++) {
                if (array[j] > array[max]) { // j+1 > j
                    max = j;
                }
            }
             swap( array, i, max);
            /*int temp = array[i];
            array[i] = array[max];
            array[max] = temp;*/
        }
    }

    private static void selectionSortsByAsc(int[] array, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
                 swap( array, i, min);
                /*int temp = array[i];
                array[i] = array[min];
                array[min] = temp;*/
        }
    }

    private static void swap(int[] array,int a, int b) {
        int temp =array[a] ;
        array[a] = array[b];
        array[b] = temp;
    }

    static void printArray(int[] arr){
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
