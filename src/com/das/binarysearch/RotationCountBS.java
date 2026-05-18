package com.das.binarysearch;

public class RotationCountBS {

    public static void main(String[] args) {
        int[] array = {4, 5, 6, 7, 0, 1, 2, 3};

        int rotationcount=rotationCount(array);

        System.out.println("Rotation count in given array: " +rotationcount);

    }

    static int rotationCount(int[] array) {
        int pivot = findPivot(array);
        // allways rotation count would be pivot + 1 if it is not sorted array
        // if it is sorted array: then 0
        return pivot + 1;
    }

    static int findPivot(int[] array) {

        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && array[mid] > array[mid + 1]) {
                return mid;
            }

            if (mid > start  && array[mid] < array[mid - 1]) {
                return mid - 1;
            }

            if (array[mid] <= array[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
