package com.das.sorts;

import java.util.concurrent.Executors;

public class SelectionSorts {

    public static void main(String[] args) {
        int[] array = {24, 14, 1, 47, 5, 34, 56, 4, 19};
        System.out.println("Given input array: ");
        printArray(array);
        selectionSortsByDesc(array, array.length);
     //   bubbleSort(array);
        printArray(array);

    }


//Executors
    static void bubbleSort(int[] array){
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
        for (int i = 0; i < n - 1; i++) {
            int max = i;
            for (int j = i+1; j < n; j++) {
                if (array[j] > array[max]) {
                    max = j;
                }
            }
            // swapIt( array[i], array[min]);
            int temp = array[i];
            array[i] = array[max];
            array[max] = temp;
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
                // swapIt( array[i], array[min]);
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
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
