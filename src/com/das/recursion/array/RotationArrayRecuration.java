package com.das.recursion.array;

public class RotationArrayRecuration {

    public static void main(String[] args) {

        int array[] ={5,6,7,8,9,1,2,3,4};
        System.out.println(rotationSearch(array,3,0,array.length-1));

    }

    static int rotationSearch(int[] arr,int target,int s, int e){
        if (s>e){
            return -1;
        }

        int m =s+(e-s)/2;

        if(target==arr[m]){
            return m;
        }

        // left side array between start to mid
        if(arr[s]<=arr[m]){
            if(target>=arr[s] && target <= arr[m]){
                return rotationSearch(arr,target,s,m-1);
            } else {
                return rotationSearch(arr, target, m + 1, e);
            }
        }

        // right side array between mid to end
        if(target>=arr[m] && target<=arr[e]){
            return rotationSearch(arr, target, m + 1, e);
        }

        return rotationSearch(arr,target,s,m-1);
    }
}
