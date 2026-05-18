package com.das.recursion.array;

import java.util.ArrayList;
import java.util.List;

public class LinerSearch {

    public static void main(String[] args) {
        int[] arr={3,2,1,18,19};
        int[] arrIndex={3,2,1,18,19,18,20};
        int target=19;
        int target1=18;
        System.out.println(linerSearch(arr,target,0));
        System.out.println(linerSearchByFirstIndex(arrIndex,target1,0));

        int[] arrIndexList={3,2,1,18,19,18,20,18};
       List<Integer> list= findIndexForGivenTarget(arrIndexList,target1,0,new ArrayList<>());
        System.out.println(list);
        System.out.println(list.getFirst()+", "+list.getLast());


        List<Integer> list2= findAllIndex(arrIndexList,target1,0);
        System.out.println(list2);

    }


    // this is not best practice because each time we are crating new array list object i mean local variable
    static List<Integer> findAllIndex(int[] arr, int target, int index) {
       List<Integer> list=new ArrayList<>();
        if(index == arr.length){
            return list;
        }

        if(arr[index] == target) {
            list.add(index);
        }
        List findingIndex=findAllIndex(arr,target,index+1);
        list.addAll(findingIndex);
        return list;
    }

    static List<Integer> findIndexForGivenTarget(int[] arr, int target, int index, List<Integer> list) {
        if(index == arr.length){
            return list;
        }

        if(arr[index] == target) {
            list.add(index);
        }

        return findIndexForGivenTarget(arr,target,index+1,list);
    }

    static int linerSearchByLastIndex(int[] arr, int target, int i) {

        if(i == arr.length){
            return -1;
        }

        if(arr[i] == target){
            return i;
        } else {
            return linerSearchByLastIndex(arr,target, i-1);
        }
    }

    // this will retuen boolean
    private static boolean linerSearch(int[] arr, int target, int i) {

        if(i == arr.length){
            return false;
        }
        return arr[i] ==target || linerSearch(arr,target,i+1);
    }

    static int linerSearchByFirstIndex(int[] arr, int target, int i) {

        if(i == arr.length){
            return -1;
        }

        if(arr[i] == target){
            return i;
        } else {
            return linerSearchByFirstIndex(arr,target, i+1);
        }
    }
}
