package com.es.utils;

/**
 * Created by es230022 on 9/17/2017.
 */
public class Puzzle {


    public static void main (String[] args) {
        new Puzzle().solve(new int[]{1,3,5,7,9,11,13,15});
    }


    public void solve(int[] array) {
        for (int i=0; i<array.length; i++) {
            for (int j=0; j<array.length; j++) {
                for (int k=0; k<array.length; k++) {
                    if (i + j + k == 30)
                        System.out.println("i=" + i + " j=" + j + " k=" + k);
                }
            }
        }
    }

}