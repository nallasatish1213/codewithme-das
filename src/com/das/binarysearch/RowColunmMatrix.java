package com.das.binarysearch;

import java.util.Arrays;

public class RowColunmMatrix {

    public static void main(String[] args) {
        int[][] matrixArray = {
                {10, 20, 30, 40},
                {15, 25, 36, 45},
                {28, 29, 37, 49},
                {32, 34, 39, 50}
        };
        int target = 25;
   //    System.out.println("2D array and target: " + Arrays.toString(searchTarget(matrixArray, target)));

        int[][] sortedArray={
                {1,2,3,4,5,6},
                {7,8,9,10,11,12},
                {13,14,15,16,17,16},
                {17,18,19,20,21,22},
                {23,24,25,26,27,28},
                {29,30,31,32,33,34},
                {35,36,37,38,39,40}
        };


        System.out.println("2D sorted array and target: " + Arrays.toString(sortedMatrix(sortedArray, 22)));
    }







    private static int[] sortedMatrix(int[][] matrixArray, int target) {

        int row = matrixArray.length;
        int col = matrixArray[0].length;

        if (row == 1) {
            return binarySearch(matrixArray,0,0,col-1,target);
        }

        // run the loop till two rows are remaining

        int rStart=0;
        int rEnd= row-1;
        int cMid= col/2;


        while(rStart < (rEnd-1)) {
            int mid = rStart + (rEnd - rStart) / 2;
            if (matrixArray[mid][cMid] == target) {
                return new int[]{mid, cMid};
            }

            if (matrixArray[mid][cMid] < target) {
                rStart = mid;
            } else {
                rEnd = mid;
            }
        }

            // now we have two rows
           // check whether the target is in the col of the 2 row

            if(matrixArray[rStart][cMid] == target) {
                return new int[] {rStart, cMid};
            }

            if(matrixArray[rStart+1][cMid] == target) {
                return new int[] {rStart+1, cMid};
            }

        //    other wise search in

            // search in 1st half
            if (target <= matrixArray[rStart][cMid-1]){
                return binarySearch(matrixArray,rStart,0,cMid-1,target);
            }

            // search in 2st half

            if (target >= matrixArray[rStart][cMid+1] && target <= matrixArray[rStart][col-1]  ){
                return binarySearch(matrixArray,rStart,cMid+1,col-1,target);
            }

            // search in 3st half
            if (target <= matrixArray[rStart+1][cMid-1]){
                return binarySearch(matrixArray,rStart+1,0,cMid-1,target);
            } else {
                return binarySearch(matrixArray,rStart+1,cMid+1,col-1,target);
            }
        }

    // search in row between column provided
    static int[] binarySearch(int[][] matrix, int r, int cStart, int cEnd, int target){
        int m=cStart+(cEnd-cStart)/2;

        while (cStart <= cEnd){

            if( matrix[r][m] == target ){
                return new int[] {r,m};
            }
            // 4 5 6 8 9   8
            if(target > matrix[r][m]) {
                cStart=m+1;
            } else {
                cEnd=m-1;
            }
        }
        return new int[] {-1,-1};
    }

    private static int[] searchTarget(int[][] matrixArray, int target) {
       int r=0;
       int c=matrixArray.length-1;

       while (r < matrixArray.length && c >= 0){

           if(matrixArray[r][c] == target) {
               return new int[] {r,c};
           }

           if(matrixArray[r][c] < target) {
               r++;
           } else {
               c--;
           }
       }
        return new int[]{-1,-1};
    }

}
