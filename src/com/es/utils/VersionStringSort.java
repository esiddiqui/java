package com.es.utils;


import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class VersionStringSort {



    public void sort(String[] versionStrings) {

        Arrays.sort(versionStrings,this.versionComparators);

    }


    private static Comparator<String> versionComparators = (v1, v2) -> {

        Integer[] v1Array= Arrays.stream(v1.split("\\.")).map(s-> Integer.parseInt(s)).collect(Collectors.toList()).toArray(new Integer[0]);
        Integer[] v2Array= Arrays.stream(v2.split("\\.")).map(s-> Integer.parseInt(s)).collect(Collectors.toList()).toArray(new Integer[0]);
        boolean done=false;
        int index=0;
        int diff=0;
        while (index<v1Array.length) {
            diff = v1Array[index]-v2Array[index];
            if (diff!=0)
                return diff;
            index++;
        }
        return diff;
    };


    public static void main (String... args) {
        String[] version = {"4.32.41", "4.32.5", "3.0.1","3.5.2","3.78.0","3.42.0","4.9.1"};
        new VersionStringSort().sort(version);
        Arrays.stream(version).forEach(System.out::println);
    }




}
