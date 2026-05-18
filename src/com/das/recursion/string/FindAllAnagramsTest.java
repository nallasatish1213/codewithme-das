package com.das.recursion.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsTest {

    public static void main(String[] args) {
        String p="ab"; String s="abab";
       // result: [0,1,2]

        String p1="abc"; String s1="cbaebabacd";
        // result: [0,6]

        System.out.println("Anagram : "+findAnagrams(s,p));

        // sliding window pattern
        String ss1="ab";
        String sss2="eidbaooo"; //  true
        String sss3= "eidboaoo"; // false

        String s4="adc";
        String ss4="dcda"; //  true


        boolean res=permutationB(ss1,sss3);
        System.out.println("permutationB: "+res);

        // length is not same and should contain like s1 in s2
        System.out.println("String permutationB: "+compering(ss1,sss2));

       /*
         List<Integer> list=findAnagrams(s1,p1);
        System.out.println(list);

       List<String>  permutations=doPermutation("",anagrams);
        System.out.println(permutations);

        for (String perm:permutations){
            if(s.contains(perm)){
                //  System.out.println(perm);
                System.out.println(s.indexOf(perm,0));
            }
        }*/
    }

    static boolean compering(String s1,String s2){
        return s2.contains(s1);
    }
    public static boolean permutationB(String s1,String s2){
        if(s1.length()>s2.length()){
            return false;
        }

        int[] countS1=new int[26];
        int[] countS2=new int[26];

        for (int i = 0; i < s1.length(); i++) {
            countS1[s1.charAt(i)-'a']++;
            countS2[s2.charAt(i)-'a']++;
        }

        for (int j = 0; j <= s2.length(); j++) {

            if (Arrays.equals(countS1, countS2)) {
                return true;
            }

            if(j== s2.length() - s1.length()) {
                break;
            }
            countS2[s2.charAt(j) - 'a']--;
            countS2[s2.charAt(j + s1.length()) - 'a']++;
        }
        return false;
    }

    static boolean matches(int[] a,int[] b){
        for (int i = 0; i < 26; i++) {
            if(a[i] != b[i]){
                return false;
            }
        }
       return true;
    }

   /* public List<Integer> findAnagrams1(String s,String p) {

        List<Integer> list=new ArrayList<>();

        int[] countP=new int[26];
        int[] countS=new int[26];

        for(int i=0; i<p.length();i++){
            countP[p.charAt(i)-'a']++;
        }

        int r=0;
        for (int j = 0; j < s.length(); j++) {
            countP[p.charAt(j)-'a']++;
            if(j-r+1 == p.length()){

                if(Arrays.equals(countS,countP))
                    list.add(r);

                countP[p.charAt(j)-'a']--;
                r++;
            }
        }

        return list;
    }*/

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> list= new ArrayList<>();

        if(s.length()<p.length())
            return list;
        int[] countS= new int[26];
        int[] countP= new int[26];
        for(int i=0;i<p.length();i++){
            countP[p.charAt(i)-'a']++;
        }

        int i=0;
        for(int j=0;j<s.length();j++){
            countS[s.charAt(j)-'a']++;
            if(j-i+1==p.length()){
                if(Arrays.equals(countS,countP))
                    list.add(i);
                countS[s.charAt(i)-'a']--;
                i++;
            }
        }
        return list;

    }

    private static List<String> doPermutation(String p, String np) {

        if(np.isEmpty()){
            List<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch=np.charAt(0);
        List<String>  inner=new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
           String f=p.substring(0,i);
           String l=p.substring(i,p.length());
           inner.addAll(doPermutation(f+ch+l,np.substring(1)));
        }

        return inner;
    }

}
