package com.das.core;

public class TestBoolean {

    public static void main(String[] args) {
        System.out.println(inValied(true));
    }

    static boolean inValied(Boolean value){
        if(!value.equals(Boolean.FALSE)){
            return true;
        } else {
            return false;
        }
    }
}
