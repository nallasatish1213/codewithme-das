package com.das.sorts;

public class SSTest {

    public static void main(String[] args) {
        int[] arr = {24, 14, 1, 47, 5, 34, 56, 4, 19};

        System.out.print("Original array: ");
        printArray(arr);
        sort(arr);
        System.out.print("Sorted  array: ");
        printArray(arr);
    }

    public static void sort(int[] array) {
        int n=array.length ;

        for (int i = 0; i < n-1 ; i++) {
            int min =i;

            for (int j = i+1; j<n; j++) {
                if(array[j] < array[min]){
                    min=j;
                }
            }
            int temp=array[i];
            array[i]=array[min];
            array[min]=temp;
        }
    }

    public static void printArray(int[] arr) {
        for (int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
