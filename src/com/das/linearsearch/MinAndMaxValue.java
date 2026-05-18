package com.das.linearsearch;

public class MinAndMaxValue {

    public static void main(String[] args) {

        int array[]= {18,7,22,34,2,45};

       int min= minSearch(array);
        System.out.println("Minimum value: "+min);
        int max= maxSearch(array);
        System.out.println("Maximum value: "+max);

    }

    private static int  minSearch(int[] array) {
        int min=array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min){
                min=array[i];
            }
        }
        return min;
    }

    private static int  maxSearch(int[] array) {
        int max=array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max){
                max=array[i];
            }
        }
        return max;
    }
}
