package com.das.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class FindPath {

    public static void main(String[] args) {


     //   findPath("",3,3);
       // System.out.println("Count of possible way path: "+ countPossiablePath(3,3));

      //  List<String> paths= findPathList("",3,3);

      //  List<String> possible= findPathDiagonal("",3,3);
       // System.out.println(possible);

        boolean[][] boards={{true, true, true},
                            {true, false, true},
                            {true, true, true}};

        mazePath("",boards,0,0);

    }

    static void mazePath(String p, boolean[][] maze, int r, int c) {
        if(r== maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }

        if(!maze[r][c]){
            // !maze[r][c]
            return;
        }

        if(r < maze.length-1){
            mazePath(p+'D',maze,r+1,c);
        }

        if(c < maze[0].length-1){
            mazePath(p+'R',maze,r,c+1);
        }
    }

    static List<String> findPathDiagonal(String p, int r, int c) {
        if(r==1 && c==1){
            List<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> inner=new ArrayList<>();
        // D: Down, R: Right, R:H:Horizontal, D:V: Vertical
        if(r>1){
            inner.addAll(findPathDiagonal(p+'V',r-1,c));
        }

        if(c>1){
            inner.addAll(findPathDiagonal(p+'H',r,c-1));
        }

        if(r>1 && c>1) {
            //D: Diagonal
            inner.addAll(findPathDiagonal(p+'D',r-1,c-1));
        }

        return inner;
    }

    static List<String> findPathList(String p, int r, int c) {
        if(r==1 && c==1){
            List<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> inner=new ArrayList<>();

        if(r>1){
            inner.addAll(findPathList(p+'D',r-1,c));
        }

        if(c>1){
            inner.addAll(findPathList(p+'R',r,c-1));
        }

        return inner;
    }
     static void findPath(String p, int r, int c) {
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }

        if(r>1){
            findPath(p+'D',r-1,c);
        }

         if(c>1){
             findPath(p+'R',r,c-1);
         }
    }

    static int countPossiablePath(int r, int c) {

        if(r==1 || c==1){
            return 1;
        }

        int left=countPossiablePath(r-1,c);
        int right=countPossiablePath(r,c-1);

        return left+right;

    }
}
