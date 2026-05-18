package com.das.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MultiTarget {

    public static void main(String[] args) {
        int[] arr={2, 6 , 4, 9, 7};
        int t=24;
        System.out.println("Muliply valus: "+ Arrays.toString(multy(arr,t)));

       /* List<Integer> intnum = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> outPutList = {4, 16, 36, 64, 100, 1, 9, 25, 49, 81}*/
        int[] arr1={1,2,3,4,5,6,7,8,9,10};
       List<Integer> output= printEvenOddGivenNumber(arr1,new LinkedList<>());
        System.out.println(output);
    }

    static int[] multy(int[] nums,int target) {
       if(nums.length<=0) {
           return new int[]{-1,-1};
       }
        Arrays.sort(nums);
       int l=0; int r=nums.length-1;
       while(l<r){
           int res=nums[l]*nums[r];
           if(target == res){
               return new int[]{nums[l], nums[r]};
           } else if (res < target){
               l++;
           } else if (res > target) {
               r--;
           }
       }
        return new int[]{-1,-1};
    }

   static LinkedList<Integer> printEvenOddGivenNumber(int[] nums, LinkedList<Integer> resList){
       List<Integer> even=new LinkedList<>();
       List<Integer> odd=new LinkedList<>();

       for (int num:nums ){
           if(num%2 ==0){
               even.add(num*num);
           } else {
               odd.add(num*num);
           }
       }
       resList.addAll(even);
       resList.addAll(odd);
       return resList;
   }
}
