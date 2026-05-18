package com.das.binarysearch;

public class SplitArraySumBS {

    public static void main(String[] args) {
        int[]  array={7,2,5,10,8};

      int sum=  splitArraySum(array,2);

        System.out.println("Sum of the split array: "+sum);
    }

    private static int splitArraySum(int[] array,int m) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < array.length; i++) {
            //in the end of the loop you can get max value
            start = Math.max(start, array[i]);
            end += array[i];
        }

        // apply binary search between s,e
        while (start < end) {
            int count=0;
            int mid = start + (end - start) / 2;
            count++;
            // calculate how many pieces you can divide this in with max sum
            System.out.println("while loop IN: count: "+count+" : start: "+ start+",end: "+end+",mid:  "+ mid);
            int sum = 0;
            int pieces = 1;
            for (int num : array) {
                System.out.println("For  into loop: : sum: "+ sum+",pieces: "+pieces+",mid:  "+ mid);
                if (sum + num > mid) {
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
                System.out.println("For loop out : : sum: "+ sum+",pieces: "+pieces+",mid:  "+ mid);
            }

            if (pieces > m) {
                start = mid + 1;
            } else {
                end = mid;
            }
            System.out.println("while loop OUT  count:"+ count +" start: "+ start+",end: "+end+",mid:  "+ mid);
        }
        return end;
    }
}
