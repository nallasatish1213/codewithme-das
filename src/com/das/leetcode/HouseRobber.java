package com.das.leetcode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

    public static void main(String[] args) {
        int[] robHouse={2,7,9,3,1};
        robTB(robHouse);  // TB: Top to bottom
    }

    int robBT(int[] nums) {
        // dp[i] = dp[i]+dp[i-2], dp[i-1]

        if( nums == null ||nums.length == 0){
            return -1;
        }

        if(nums.length == 1){
            return nums[0];
        }
        int[] dp=new int[nums.length];

        dp[0]=nums[0];
        dp[1]= Math.max(nums[0],nums[1]);

        for (int i = 2; i < nums.length ; i++) {
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[nums.length-1];
    }

  static void  robTB(int[] arr) {
      Map<Integer, Integer> map=new HashMap<>();
     int max= dp(arr.length-1,arr,map);
      System.out.println("Max robber amount: "+max);
  }

     static int dp(int i, int[] arr, Map<Integer, Integer> map) {
        if(i==0) {
            return arr[i];
        }

        if(i==1) {
            return Math.max(arr[0],arr[1]);
        }

        if(map.containsKey(i)){
         return   map.get(i);
        }

        map.put(i,Math.max(dp(i-1,arr,map), arr[i]+dp(i-2,arr,map)));
        return map.get(i);
    }
}
