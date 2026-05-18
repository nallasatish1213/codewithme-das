package com.das.sliding;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SequencedCollection;

public class DynamicSlidingWindowArrayTest {

    public static void main(String[] args) {

       int  arr[] = {1, 2, 3, 7, 5};
       int target = 12;

        int arr2[] = {1, 2, 3, 4, 1, 5, 6, 7, 8, 9, 10}; int target2 = 15;
        System.out.println("dyamic sub array sum: "+ Arrays.toString(dynamicSlidingWindowSolution2(arr2,target2)));

      //  SequencedCollection
    }

    static int[] dynamicSlidingWindowSolution2(int[] arr,int target) {
        int sum = 0;
        int s = 0;
        for (int e = 0; e < arr.length; e++) {
            sum += arr[e];

            if (sum > target) {
                sum -= arr[s];
                s++;
            }

            if (sum == target) {
                return new int[]{s + 1, e + 1};
            }
        }
        return new int[]{-1};
    }

    static int[] dynamicSlidingWindowSolution1(int[] arr,int target){
        int start = 0;
        int currentSum = 0;

        for (int end = 0; end < arr.length; end++) {
            // Add current element to the window
            currentSum += arr[end];

            // Shrink the window from the left if sum exceeds target
            while (currentSum > target && start < end) {
                currentSum -= arr[start];
                start++;
            }

            // Check if we found the target sum
            if (currentSum == target) {
                // Return 1-based indices
                return new int[]{start + 1, end + 1};
            }
        }

        // If no subarray found
        return new int[]{-1};
    }
}
