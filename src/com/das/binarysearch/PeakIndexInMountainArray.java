package com.das.binarysearch;

public class PeakIndexInMountainArray {
    // find the peak index or number
    // find the moutain number or index
    public static void main(String[] args) {
        int[] peakArray= {0,2,4,5,6,7,5,3,1};
        int peakArrayTarget=1;
      //  int targetOut=-100;
        //Todo: find the peaks of array
       int index=findMoutainArray(peakArray,peakArrayTarget);
        System.out.println("moutain index of given target: "+ index);

    }

     static int  findMoutainArray(int[] array,int target){
        int peakIndex=findPeaks(array);
       int  targetOut =findIndexByAscDnDesc(array,target,0,peakIndex);
         if(targetOut != -1){
             return targetOut;
         }

         return findIndexByAscDnDesc(array,target,peakIndex+1,array.length-1);
    }

    static int findIndexByAscDnDesc(int[] array, int target, int start, int end){
        boolean  asc=array[start]<array[end];
        while (start<=end){
            int mid=start+(end-start)/2;

            if(target==array[mid]){
                return mid;
            }

            if(asc){
                if(target<array[mid]){
                    end=mid-1;
                }else {
                    start=mid+1;
                }
            }else {
                if(target>array[mid]){
                    end=mid-1;
                }else {
                    start=mid+1;
                }
            }
        }
        return -1;
    }

    static int findPeaks(int[] input){
        int start=0;
        int end=input.length-1;

        while(start<end){
            int mid=start+(end-start)/2;
            if(input[mid]>input[mid+1]){
                // your in desc part of array that's way am not increasing/decreasing to mid
                end=mid;
            }else {
                // your in asc parts of array
                start=mid+1; //because we know that m+1 > m element
            }
        }
        /*
        *in the end, start == end pointing to the largest number because of the 2 checks above
        * and if we are saying that only one item remaining, hence  because of the above line that is the best possible answer
        * */
        return start; // here can be both start/end ing same index
    }
}
