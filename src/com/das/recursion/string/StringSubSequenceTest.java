package com.das.recursion.string;

import java.util.ArrayList;

public class StringSubSequenceTest {

    public static void main(String[] args) {

        String input="kipkipl";
        subSeq("",input);

        ArrayList<String> output= subSeqALReturn("",input);
      //  System.out.println(output);

        ArrayList<String> output2=subSequenceWithAscii("",input);
      //  System.out.println(output2);

    }

    static ArrayList<String> subSequenceWithAscii(String p, String np) {

        if(np.isEmpty()){
            ArrayList<String> list=new  ArrayList<String>();
            list.add(p);
            return list;
        }

        char ch=np.charAt(0);
        ArrayList<String> left= subSequenceWithAscii(p+ch,np.substring(1));
        ArrayList<String> right= subSequenceWithAscii(p,np.substring(1));
        ArrayList<String> asciiList= subSequenceWithAscii(p+(ch+0),np.substring(1));

        left.addAll(right);
        left.addAll(asciiList);
        return left;

    }

    // without using collection like array list in outside param

    static ArrayList<String> subSeqALReturn(String p, String np) {
        if (np.isEmpty()) {
            ArrayList<String> mix = new ArrayList<String>();
            mix.add(p);
            return mix;
        }

        char ch = np.charAt(0);
        ArrayList<String> left = subSeqALReturn(p + ch, np.substring(1));
        ArrayList<String> right = subSeqALReturn(p, np.substring(1));
        left.addAll(right);
        return left;
    }

    static void subSeq(String p,String np){
        if(np.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch=np.charAt(0);
        subSeq(p+ch,np.substring(1));
        subSeq(p,np.substring(1));
    }
}
