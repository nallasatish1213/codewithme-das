package com.das.linearsearch;

import java.util.Arrays;

public class FindNumber {

    public static void main(String[] args) {
        int array[] = {18, 7, 22, 34, 2, 45, -7, 47, 15, 26};
        int number = 2;
     /*
      int index=  findNumber(array,number);
        System.out.println("Find Number: "+index);
          System.out.println(searchCharacter("kunal",'l'));

        Integer rangeNumber=findNumberBetweenRange(array,2,9,2);
       System.out.println("Range number: "+ rangeNumber);

         int minNumber= minNumber(array);
        System.out.println("Min number: "+ minNumber);

         int maxNumber= maxNumber(array);
        System.out.println("Max number: "+ maxNumber);

         int[][] array2d = {{21, 14},
                {32, 8, 44, 12},
                {14, 57, 36},
                {1, 29, 60}};
        System.out.println(Arrays.toString(findNumberIndArray(array2d, 1)));
*/

        System.out.println("digit length: "+ findDigit(2));
        int[] arrayDigEven = {345, 23, 31232, 5, 534223, 8675};
        findEvenNumbers(arrayDigEven);

        int[][] personWealthdeatil1={{2,3,4},{4,2,3}};
        int[][] personWealthdeatil2={{2,3,4},{7,2,3}};

        System.out.println("Max wealth in 2d array: "+maxWealth(personWealthdeatil2));

    }


    static int  maxWealth(int[][] wealth){
        int maxWealth=0;
        for (int row = 0; row < wealth.length ; row++) {
            int total=0;
            for (int col = 0; col <wealth[row].length ; col++) {
                total=total+wealth[row][col];
                if(total>maxWealth){
                    maxWealth=total;
                }
            }
        }
        return maxWealth;
    }

    static void findEvenNumbers(int[] array) {
        int count=0;
        for (int i = 0; i < array.length; i++) {
            int digNum = findDigit(array[i]);
            if (digNum % 2 == 0) {
                count++;
                System.out.println(array[i]);
            }
        }
        System.out.println("Count of even number: "+count);
    }

    private static int findDigit(int n) {
       /* if (n < 0) {
            return -1;
        }
        int count = 0;
        while (n > 0) {
            count++;
            n = n / 10;
        }
        return count;
        */

        return (int)Math.log10(n)+1;
    }

    static int[] findNumberIndArray(int[][] arrays, int target) {
        for (int row = 0; row < arrays.length; row++) {
            for (int col = 0; col < arrays[row].length; col++) {
                if (arrays[row][col] == target) {
                    return new int[]{row, col};
                }
            }

        }
        return new int[]{-1, -1};
    }

    static int maxNumber(int[] array) {
        if (array.length == 0) {
            return -100;
        }

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }


    static int minNumber(int[] array) {
        if (array.length == 0) {
            return -100;
        }

        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    static int findNumberBetweenRange(int[] array, int start, int end, int target) {
        if (array.length == 0) {
            return Integer.MAX_VALUE;
        }
        if (end >= array.length) {
            return Integer.MIN_VALUE;
        }

        for (int i = start; i <= end; i++) {
            if (target == array[i]) {
                return i;
            }
        }

        return Integer.MAX_VALUE;
    }

    static int findNumber(int[] array, int number) {
        if (array.length == 0) {
            return -1;
        }
        for (int i = 0; i < array.length; i++) {
            if (number == array[i]) {
                return i;
            }
        }
        return -1;
    }

    static boolean searchCharacter(String value, char c) {
        if (value.length() == 0) {
            return false;
        }

        for (int i = 0; i < value.length(); i++) {
            if (c == value.charAt(i))
                return true;
        }

        return false;

    }
}
