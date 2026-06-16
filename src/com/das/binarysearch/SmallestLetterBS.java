package com.das.binarysearch;

public class SmallestLetterBS {

    public static void main(String[] args) {

        //finding  next greater characters in the array
        // in --> out: a:d,b:d,c:d,z:a,j:a
        char[] input={'a','d','f','g','j'};
        System.out.println(smallestCharacter(input,'k'));
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
        //solution one
        //return letters[s%letters.length];

        //solution:2
        if (s == letters.length) {
            return letters[0];
        }
        return letters[s];
    }

}
