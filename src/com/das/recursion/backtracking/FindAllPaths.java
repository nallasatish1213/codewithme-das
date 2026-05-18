package com.das.recursion.backtracking;

import java.util.Arrays;

public class FindAllPaths {

    public static void main(String[] args) {
        boolean[][] boards={{true, true, true},
                {true, true, true},
                {true, true, true}};

       // paths("",0,0,boards);

        int[][] path=new int[boards.length][boards[0].length];
        printArrayMatricWithPath("",0,0,boards,path,1);
    }


    static void printArrayMatricWithPath(String p, int r, int c, boolean[][] maze, int[][] path,int step) {

        if(r == maze.length-1 && c == maze[0].length-1){
            path[r][c]=step;
            for (int[] i:path) {
                System.out.println(Arrays.toString(i));
            }
            System.out.println(p);
            System.out.println();
            return;
        }


        if(maze[r][c] == false){
            return;
        }

        maze[r][c]=false;
        path[r][c]=step;

        if(r < maze.length-1) {
            printArrayMatricWithPath(p+'D',r+1,c,maze,path,step+1);
        }

        if(c < maze[0].length-1){
            printArrayMatricWithPath(p+'R',r,c+1,maze,path,step+1);
        }

        if(r>0){
            printArrayMatricWithPath(p+'U',r-1,c,maze,path,step+1);
        }

        if(c>0){
            printArrayMatricWithPath(p+'L',r,c-1,maze,path,step+1);
        }

        maze[r][c]=true;
        path[r][c]=0;
    }

     static void paths(String p, int r, int c, boolean[][] maze) {

        if(r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }


        if(maze[r][c] == false){
            return;
        }

         maze[r][c]=false;

        if(r < maze.length-1) {
            paths(p+'D',r+1,c,maze);
        }

        if(c < maze[0].length-1){
            paths(p+'R',r,c+1,maze);
        }

        if(r>0){
            paths(p+'U',r-1,c,maze);
        }

        if(c>0){
            paths(p+'L',r,c-1,maze);
        }

        maze[r][c]=true;
    }

}
