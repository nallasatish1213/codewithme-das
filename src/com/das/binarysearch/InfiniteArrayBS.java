package com.das.binarysearch;

public class InfiniteArrayBS {

    /*
    * The interviewer is testing whether you understand:
        1: Expand the window exponentially.
        2: Binary search within the window.

    * In a real Java array I'd need length or bounds checking. In the infinite-array problem,
    * we assume an API that can access arbitrary indices, so exponential window expansion followed
    * by binary search is sufficient
    *
    * */
    public static void main(String[] args) {

        int[] input={3,5,7,9,10,90,100,130,140,160,200};
        System.out.println(findTargetWithoutusingLenght(input,140));

    }

 static int   findTargetWithoutusingLenght(int[] array, int target){
        int start=0;
        int end=1;

        while(target>array[end]){
            int newStart=end+1;
            end=end+(end-start+1)*2;
            start=newStart;
        }
    return  search(array,target,start,end);
    }

    static int search(int[] infinite, int target, int s, int e) {
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (target < infinite[mid]) {
                e = mid - 1;
            } else if (target > infinite[mid]) {
                s = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}