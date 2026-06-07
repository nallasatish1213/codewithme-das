package com.test;

public class RotationArrayBSPivotTest {

    public static void main(String[] args) {

    }

    static int search(int[] arr, int target){
        int result=-100;
        int pivot=findPivotinArray(arr);

        if(pivot == -1){
           return  binarySearch(arr,target,0,arr.length-1);
        }

        if(target == arr[pivot]){
            return pivot;
        }

        if(target>=arr[0]){
            return binarySearch(arr,target,0,pivot-1);
        }
        return binarySearch(arr,target,pivot+1,arr.length-1);
    }

    private static int findPivotinArray(int[] arr) {
        int s=0;  int e=arr.length;
        while (s<=e){
            int m=s+(e-s)/2;

            if (m<e && arr[m]>arr[m+1]){
                return m;
            }

            if (m>s && arr[m]<arr[m-1]){
                return m-1;
            }

            if(arr[m]<=arr[s]){
                e=m-1;
            }else {
                s=m+1;
            }
        }
        return -1;
    }

    static int binarySearch(int[] arr, int target,int s, int e){

        while(s<=e){
            int m=s+(e-s)/2;
            if(target == arr[m]){
                return m;
            }

            if(target<arr[m]){
                e=m-1;
            }else{
                s=m+1;
            }
        }
        return -1;
    }
}
