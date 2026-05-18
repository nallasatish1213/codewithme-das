package com.das.recursion.string;

import java.util.ArrayList;
import java.util.List;

public class PhonePad {

    public static void main(String[] args) {

      //  pad("","12");

        System.out.println(padList("","12"));

    }

    static List<String> padList(String p, String up){
        if(up.isEmpty()){
            List<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }

        // this will convert to '2' to 2==> '2'-'0'
        int digit=up.charAt(0)-'0';
        List<String> list=new ArrayList<>();
        for (int i =(digit-1)*3 ; i < digit*3; i++) {
            char ch=(char) ('a'+i);
          list.addAll(padList(p+ch,up.substring(1)));
        }
        return list;
    }

    static void pad(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        // this will convert to '2' to 2==> '2'-'0'
        int digit=up.charAt(0)-'0';

        for (int i =(digit-1)*3 ; i < digit*3; i++) {
            char ch=(char) ('a'+i);
            pad(p+ch,up.substring(1));
        }
    }
}
