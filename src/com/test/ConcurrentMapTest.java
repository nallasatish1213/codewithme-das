package com.test;

import java.util.HashMap;
import java.util.Map;

public class ConcurrentMapTest extends Thread {

   //  Approach : 1 : it wont  force to implements run method because thread class already implemented it
    static Map<Integer,String> map=new HashMap<>();

    public static void main(String[] args) {
       map.put(2,"satish");
        map.put(4,"satish");
        map.put(5,"satish");
        map.put(3,"satish");
        System.out.println(map);
    }
/*
Approach : 2: it will force to implements run method because it is a abstract method in Runnable interface
    class ConcurrentMapTest2 implements Runnable {

        static Map<Integer,String> map=new HashMap<>();

        public static void main(String[] args) {
            map.put(2,"satish");
            map.put(4,"satish");
            map.put(5,"satish");
            map.put(3,"satish");
            System.out.println(map);
        }*/
}