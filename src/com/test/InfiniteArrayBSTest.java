package com.test;

public class InfiniteArrayBSTest {

    public static void main(String[] args) {
        int[] input={3,5,7,9,10,90,100,130,140,160,200};

        int value=searcht(input,140);
        System.out.println(value);

    }

    private static int searcht(int[] arr, int t) {

        int s=0; int e=1;

        while(t > arr[e]) {
            int nStart=e+1;  // 2
            e=e+(e-s+1)*2;
            s=nStart;
        }
       return binarySearch(arr,t,s,e);
    }

    static int binarySearch(int[] arr,int t, int s, int e) {

        while(s<=e){
            int m=s+(e-s)/2;

            if(t==arr[m]){
                return m;
            }

            if(t < arr[m]){
                e=m-1;
            } else {
                s=m+1;
            }
        }

        return -1;
    }
}
