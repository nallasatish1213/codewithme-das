package com.das.recursion.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSequenceArray {

    public static void main(String[] args) {

        int[] arr={1,2,3};

        // with out duplicate element in integer array
      /*  List<List<Integer>> out=subSeq(arr);
        for (List<Integer> list:out) {
            System.out.println(list);
        }*/

        // with  duplicate element in integer array

        int[] dup={2,1,2};
        List<List<Integer>> out2=subSeqWithDuplicate(dup);
        for (List<Integer> list:out2) {
            System.out.println(list);
        }

    }


    // with out duplicate element in integer array
    static List<List<Integer>>  subSeqWithDuplicate(int[] arr){
        // sort the actival array
        // create outer
        Arrays.sort(arr);
        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());

        int start=0; int end=0;
        for (int i = 0; i < arr.length; i++) {
            start=0;

            if(i>0 && arr[i] == arr[i-1]){
                start=end+1;
            }
            end=outer.size()-1;
            int n=outer.size();
            for (int j = 0; j < n; j++) {
               List<Integer> inner=new ArrayList<>(outer.get(j));
               inner.add(arr[i]);
                 outer.add(inner);
            }
        }

        return outer;
    }

    // with out duplicate element in integer array

    static List<List<Integer>>  subSeq(int[] arr){
        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());

        for (Integer num:arr){
            int n=outer.size();
            for (int i = 0; i <n ; i++) {
                List<Integer> inner=new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        return outer;
    }
}
