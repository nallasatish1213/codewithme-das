package com.test;

import java.util.Arrays;

public class MatrixSearch {
    public static void main(String[] args) {

        int[][] matrixArray = {
                {10, 20, 30, 40},
                {15, 25, 36, 45},
                {28, 29, 37, 49},
                {32, 34, 39, 50}
        };
        int target = 50;
        //System.out.println("2D array and target: " + Arrays.toString(searchTarget(matrixArray, target)));

        /*
        int[][] sortedArray={
                {1,2,3,4,5,6}};
        */

        int[][] sortedArray={
                {1,2,3,4,5,6},
                {7,8,9,10,11,12},
                {13,14,15,16,17,16},
                {17,18,19,20,21,22},
                {23,24,25,26,27,28},
                {29,30,31,32,33,34},
                {35,36,37,38,39,40}
        };

       // searchMatrix(sortedArray,t);
        System.out.println("2D sorted array and target: " + Arrays.toString(searchMatrix(sortedArray, 1)));

    }

    static int[] searchMatrix(int[][] matrixArray, int target) {
        int r=matrixArray.length;
        int col=matrixArray[0].length;
        if(r == 1){
            return binarySearch1(matrixArray,target,0,0,col-1);
        }

        int rStart=0;
        int rEnd=r-1;
        int cMid=col/2;

        while(rStart < (rEnd-1)) {
            int mid = rStart + (rEnd - rStart) / 2;
            if(target == matrixArray[mid][cMid]){
                return new int[]{mid,cMid};
            }

            if(target < matrixArray[mid][cMid]) {
                rEnd=mid;
            } else {
                rStart=mid;
            }
        }

        if(target == matrixArray[rStart][cMid]){
            return new int[]{rStart,cMid};
        }

        if(target == matrixArray[rStart+1][cMid]){
            return new int[]{rStart+1,cMid};
        }

        // suppose we have more the 8 row in this case we have split the matrix and
        // check if target is exist in between rows

        // 1st of row
        if(target <= matrixArray[rStart][cMid-1]) {
            return binarySearch1(matrixArray,target,rStart,0,cMid-1);
        }

        //after mid of rows checking
        if(target>= matrixArray[rStart][cMid+1] && target<= matrixArray[rStart][col-1]) {
            return binarySearch1(matrixArray,target,rStart,cMid+1,col-1);
        }

        if(target <= matrixArray[rStart+1][cMid-1]) {
            return binarySearch1(matrixArray,target,rStart+1,0,cMid-1);
        } else {
            return binarySearch1(matrixArray,target,rStart+1,cMid+1,col-1);
        }

       // return new int[]{-1,-1};
    }

    private static int[] binarySearch1(int[][] matrixArray, int target, int r, int cStart, int cEnd) {

        while(cStart<=cEnd){
            int m=cStart+(cEnd-cStart)/2;

            if(target == matrixArray[r][m]){
                return new int[]{r,m};
            }

            if(target > matrixArray[r][m]) {
                cStart= m+1;
            } else {
                cEnd=m-1;
            }
        }
        return new int[]{-1,-1};
    }

    private static int[] searchTarget(int[][] matrixArray, int target) {
        int r=0;
        int c=matrixArray.length-1;

        while (r<=c && c>=0){

            if(target == matrixArray[r][c]){
                return new int[]{r,c};
            }

            if(target > matrixArray[r][c]){
                r++;
            }else {
                c--;
            }
        }
        return new int[]{-1,-1};
    }
}
