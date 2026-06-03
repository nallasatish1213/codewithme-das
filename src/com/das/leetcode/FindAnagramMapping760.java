package com.das.leetcode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FindAnagramMapping760 {

    /**
     * Ex:1
     * int[] a={12,28,46,32,50};
     * int[] b={50,12,32,46,28};
     * op:[ 1 4 3 2 0]
     * Ex:@
     *  int[] a = {84,46}
     *   int[] b = {84,46}
     *
     *   op: [0,1]
     */

    public static void main(String[] args) {

        int[] a={12,28,46,32,50};
        int[] b={50,12,32,46,28};
        List<Integer> list=findAnagramNumbers(a,b);

        System.out.println(list);

    }

    private static List<Integer> findAnagramNumbers(int[] a, int[] b) {

        Map<Integer,Integer> bMap=new LinkedHashMap<>();
        List<Integer> op=new ArrayList<>();
        for (int i = 0; i < b.length; i++) {
            bMap.put(b[i],i);
        }

        for (int i = 0; i < a.length; i++) {
            if(bMap.containsKey(a[i])){
                op.add(bMap.get(a[i]));
            }
        }
        return op;
    }
}
