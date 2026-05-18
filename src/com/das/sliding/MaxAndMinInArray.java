package com.das.sliding;

import java.util.*;

public class MaxAndMinInArray {

    public static void main(String[] args) {
        int[] arr= {4, 16, 36, 64, 100, 1, 9, 25, 49,81,-2 };

/*        // Max number and index
        System.out.println("Max number: "+findMaxNumber(arr));
        System.out.println("Max number: solution:2:index "+findMaxNumberIndex(arr));

        // Min number and index
        System.out.println("Min number: "+findMinNumber(arr));
        */

      /*  // sum of two integer
        //target=x+y
        int[] arr2= {2,6,5,9,1,4,3};
        int[] arr3= {3,6,5,9,1,4,2};
        int target=7;
       System.out.println("two sum: "+ Arrays.toString(findTwoSum(arr3,target)));

        System.out.println("two sum: "+ Arrays.toString(findTwoSumIndex(arr3,target)));

        System.out.println("List of two sum: "+findNumberOfTwoSum (arr3,target));*/
    }



    static  Map<Integer, List<Integer>> findNumberOfTwoSum(int[] arr2, int t) {

        Map<Integer, Integer> map=new HashMap<>();
        Map<Integer, List<Integer>> mapR=new HashMap<>();
        int count=0;
        for (int i = 0; i < arr2.length; i++) {
            List<Integer> list=new ArrayList<>();
            int compliment=t-arr2[i];
            if(map.containsKey(compliment)) {
                list.add(map.get(compliment));
                list.add(i);
                mapR.put(count++,list);
            }
            map.put(arr2[i],i);
        }
        return mapR;
    }

    static int[] findTwoSumIndex(int[] arr2, int t) {

        Map<Integer, Integer> map=new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            int compliment=t-arr2[i];
            if(map.containsKey(compliment)) {
               return new int[]{map.get(compliment),i};
            }
            map.put(arr2[i],i);
        }
        return new int[]{-1,-1};
    }

    static int[] findTwoSum(int[] arr2, int t) {
        int l = 0;
        int r = l + 1;
        int n = arr2.length;
        while (l < n && r < n) {
            if (t==(arr2[l]+arr2[r])){
                return new int[]{l,r};
            }
            r++;
        }
        return new int[]{-1,-1};
    }

    static int findMinNumber(int[] arr){
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min){
                min=arr[i];
            }
        }
        return min;
    }

    static int findMaxNumber(int[] arr){
        int max=Integer.MIN_VALUE;
        for(int i:arr){
            if(i>max) {
                max=i;
            }
        }
        return max;
    }

    static int findMaxNumberIndex(int[] arr){
        int max=Integer.MIN_VALUE;
        int index=0;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]>max){
                max=arr[i];
               index=i;
            }
        }
        return index;
    }


}
