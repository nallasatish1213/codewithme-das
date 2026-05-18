package com.das.binarysearch;

public class SmallestLetterBS {

    public static void main(String[] args) {

        char[] input={'a','d','f','g','j'};
        System.out.println(smallestCharacter(input,'z'));
    }

    static char smallestCharacter(char[] letters,char target){

        int s=0;
        int e=letters.length-1;

        while(s<=e){
            int mid=s+(e-s)/2;
            if(target<letters[mid]){
                e=mid-1;
            }else {
                s=mid+1;
            }
        }
        return letters[s%letters.length];
    }

}
