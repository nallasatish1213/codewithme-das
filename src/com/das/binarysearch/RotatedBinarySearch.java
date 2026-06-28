package com.das.binarysearch;

public class RotatedBinarySearch {

    public static void main(String[] args) {
        int[] array = {4, 5, 6, 7, 8, 9, 0, 1, 2, 3};
        int pivotAndTarget = search(array, 2);
        System.out.println("finding pivot: " + pivotAndTarget);
    }

    static int search(int[] array, int target) {
        int pivot = findPivot(array);
        System.out.println("pivot: " + pivot);
        // if you do not find pivot it mean the array is not rotated array
        if (pivot == -1) {
            return binarySearch(array, target, 0, array.length - 1);
        }

        // if you found pivot then you have 2 ascending order array
        if (target == array[pivot]) {
            return pivot;
        }

        if (target >= array[0]) {
            return binarySearch(array, target, 0, pivot - 1);
        }

        return binarySearch(array, target, pivot + 1, array.length - 1);
    }

    static int binarySearch(int[] a, int t, int s, int e) {

        while (s <= e) {
            int m = s + (e - s) / 2;
            if (t < a[m]) {
                e = m - 1;
            } else if (t > a[m]) {
                s = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    // if array having duplicate element then it won't work
    static int findPivot(int[] array) {
        // 4,5,6,7,8,9,0,1,2,3
        // 1st iterating time: s:0, e=9, m= 4
        //2nd: s=4+1=5, e=9, m=5+3/2=5+1.5= 6
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (mid < end && array[mid] > array[mid + 1]) {
                return mid;
            }

            if (mid > start && array[mid] < array[mid - 1]) {
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

    //for duplicate
    static int findPivotForDuplicate(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (mid < end && array[mid] > array[mid + 1]) {
                return mid;
            }

            if (mid > start && array[mid] < array[mid - 1]) {
                return mid - 1;
            }

            if (array[mid] == array[start] && array[mid] == array[end]) {

                //     what if start and end are pivot
                // check start/end

                if (array[start] > array[start + 1]) {
                    return start;
                }
                start++;
                if (array[end] < array[end - 1]) {
                    return end - 1;
                }
                end--;
            } //left side is sorted then pivot should be right side
            else if (array[start] < array[mid] || ((array[start] < array[mid]) && array[mid] > array[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
