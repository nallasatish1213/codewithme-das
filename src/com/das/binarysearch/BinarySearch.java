package com.das.binarysearch;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arrayAsc={4,7,14,20,26,31,38,45,55,59,67,88,97};
        int[] arrayDesc= {52,48,43,37,30,27,19};
    //    System.out.println(binarySearchAsc(arrayAsc,97));
   //     System.out.println(binarySearchDesc(arrayDesc,48));

        int[] arrayfloor= {2,4,7,9,11,14,16,19};

      //  System.out.println(cellingNumberinArray(arrayfloor,19));
        System.out.println(flooringNumberinArray(arrayfloor,6));
    }

    // flooring mean <= tearget if target= 15 then output would be 15 or <= nearest number in array(14)
    static int flooringNumberinArray(int[] array,int target){

        int start=0;
        int end=array.length-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            if(target>array[mid]){
                start=mid+1;
            } else if(target<array[mid]){
                end=mid-1;
            } else {
                return mid;
            }
            System.out.println("start: "+array[start]);
            System.out.println("end: "+array[end]);
            System.out.println("mid: "+mid);
        }

        return end;
    }

    // Celling mean >= tearget if target= 15 then output would be 15 or >= nearest number in array(16)
    static int cellingNumberinArray(int[] array,int target){
        int start=0;
        int end=array.length-1;

        if(target>array[array.length-1]){
            return -1;
        }

        while (start<=end){
            int mid=start+ (end-start)/2;

            if(target>array[mid]){
                start=mid+1;
            } else if (target<array[mid]) {
                end=mid-1;
            } else {
                return mid;
            }
        }
        return start;
    }

    static int binarySearchAsc(int[] array, int target) {
        int start=0;
        int end=array.length-1;

        if(array.length<0){
            return -1;
        }

        while(start<=end){
            int  mid= start+(end-start)/2;

            if(target<array[mid]){
                end=mid-1;
            } else if(target> array[mid]){
                start=mid+1;
            }else{
                return mid;
            }
        }

        return -1;
    }

    static int binarySearchDesc(int[] array, int target) {
        int start=0;
        int end=array.length-1;
        boolean  asc=array[start]<array[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (asc) {
                if (target < array[mid]) {
                    end = mid - 1;
                } else if (target > array[mid]) {
                    start = mid + 1;
                }
            } else {
                if (target > array[mid]) {
                    end = mid - 1;
                } else if (target < array[mid]) {
                    start = mid + 1;
                }
            }
            return mid;
        }
        return -1;
    }

}
