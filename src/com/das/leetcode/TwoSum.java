package com.das.leetcode;

import java.util.*;

public class TwoSum {
    /*

    Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
    * */

    public static void main(String[] args) {

        int[] arr={2,7,15,11,5,4};  int target=18;
        int[] arr1= {2, 5, -4, 8, 11, 1, -1, 6, 7};  int target1=10;

        System.out.println("twoSum : Find sum of two number: "+ Arrays.toString(twoSum(arr1,target1)));

        System.out.println("twoSum2 : Find sum of two number: "+ Arrays.toString(twoSum2(arr1,target1)));

        int[] arr2={2,10,7,1,4,11,14,5};
        int target2=15;
        Map<Integer,List<Integer>> result=twoSumList(arr1,target1);
        for (Map.Entry<Integer, List<Integer>> l:result.entrySet()){
            System.out.println(l.getValue());
        }

        System.out.println("twoSumDP : Find sum of two number: "+ Arrays.toString(twoSumDP(arr,target)));

    }

    public static  Map<Integer,List<Integer>> twoSumList(int[] nums, int target) {

        //2,7,4,11,14,5,1
        Map<Integer,List<Integer>> result=new LinkedHashMap();
        Map ans=new HashMap();
        for (int i = 0; i < nums.length ; i++) {
          /* math solution
           target= i+j;
                 j=target-i
            */
            int complement=target - nums[i];
            if(ans.containsKey(complement)){
                List<Integer> current=new ArrayList<>();
                current.add( (Integer) ans.get(complement));
                current.add(i);
               result.put(i,current);
            }
        ans.put(nums[i],i);
        }
        return result;
    }

    public static  int[] twoSum(int[] nums, int target) {

        Map ans=new HashMap();
        for (int i = 0; i < nums.length ; i++) {
          /* math solution
           target= i+j;
                 j=target-i
            */
            int complement=target - nums[i];
            if(ans.containsKey(complement)){
               return new int[]{(Integer) ans.get(complement),i};  // add index of two sum numbers
            }
            ans.put(nums[i],i);
        }
          return new int[]{-1,-1};
    }


    public static int[] twoSum2(int[] array, int targetSum) {
        //2,7,15,11

          Arrays.sort(array);

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int s = array[left] + array[right];

            if (s == targetSum) {
                return new int[]{array[left], array[right]};
            } else if (s < targetSum) {
                left++;
            } else if (s > targetSum) {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] twoSumWhile(int[] nums, int target) {
        int i=0;
        Map<Integer,Integer> map=new HashMap();
        while(i < nums.length) {
            int complement=target-nums[i];
            if(map.containsKey(complement)) {
                return new int[]{(Integer)map.get(complement),i};
            }
            map.put(nums[i],i);
            i++;
        }
        return new int[]{-1,-1};
    }


    public static  int[] twoSumDP(int[] nums, int target) {
       int l=0;
       int r=1;
       int sum=0;
       while(l>=0 && r<=nums.length-1){
           sum= nums[l]+nums[r];
           if(sum==target){
               return new int[]{l,r};
           }
           l++;
           r++;
       }
        return new int[]{-1,-1};
    }
}

