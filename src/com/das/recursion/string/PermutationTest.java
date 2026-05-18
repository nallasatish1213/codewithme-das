package com.das.recursion.string;

import java.util.ArrayList;
import java.util.List;

public class PermutationTest {

    public static void main(String[] args) {
        String input="abcd";
        String input1="eidbaooo";
       // permutations("",input);
        List<String> strList= permutationAddingInList("",input);
        System.out.println(strList);
        System.out.println("List size: "+strList.size());

       Integer perCount= permutationCount("",input);
        System.out.println("Per Count: "+perCount);

    }

    // just printing values
    static int permutationCount(String p, String np){
        if(np.isEmpty()){
            return 1;
        }

        int count=0;

        char ch=np.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f=p.substring(0,i);
            String s=p.substring(i,p.length());
           count=count+ permutationCount(f+ch+s,np.substring(1));
        }

        return count;
    }

    static List<String> permutationAddingInList(String p, String np){
        if(np.isEmpty()){
            List<String> out=new ArrayList<>();
            out.add(p);
            return out;
        }

        char ch=np.charAt(0);
        List<String> ans=new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            String f=p.substring(0,i);
            String s=p.substring(i,p.length());
           ans.addAll(permutationAddingInList(f+ch+s,np.substring(1)));
        }
        return ans;
    }

    // just printing values
    static void permutations(String p, String np){
        if(np.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch=np.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
        String f=p.substring(0,i);
        String s=p.substring(i,p.length());
        permutations(f+ch+s,np.substring(1));
        }
    }
}
