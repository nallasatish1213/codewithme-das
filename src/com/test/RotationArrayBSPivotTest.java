package com.test;

public class RotationArrayBSPivotTest {

    public static void main(String[] args) {

        int[] array = {4, 5, 6, 7, 0, 1, 2, 3};
        int pivotAndTarget = search(array, 4);
        System.out.println("finding pivot and target: " + pivotAndTarget);
    }

    private static int search(int[] array, int target) {

        int pivot=findPivot(array);

        if(pivot == -1) {
            return binarySearch(array,target,0,array.length-1);
        }

        if(target == array[pivot]){
            return pivot;
        }

        if(target>=array[0]) {
            return binarySearch(array,target,0,pivot-1);
        }

        return binarySearch(array, target, pivot + 1, array.length - 1);
    }

    private static int findPivot(int[] array) {
        int s=0; int e=array.length-1;
        while (s<=e){
            int m=s+(e-s)/2;
            if(m<e && array[m]>array[m+1]){
                return m;
            }

            if(m>s && array[m]<array[m+1]){
                return m+1;
            }

            if(array[m]<=array[s]){
                e=m-1;
            } else {
                s=m+1;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] array, int target, int s, int e) {

        while(s<=e){
            int mid=s+(e-s)/2;
            if(target < array[mid]){
                e=mid-1;
            }else if(target > array[mid]) {
                s=mid+1;
            } else {
                return mid;
            }
        }

        return -1;
    }

}
