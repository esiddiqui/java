package com.es.utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 * Created by es230022 on 9/7/2017.
 */
public class ArrayOperations {

    private static Comparator<Integer> desc = (a,b) -> {
        return a.compareTo(b)*-1;
    };


    public static void main (String[] args) {
        Integer[] a= {14,19,57,1,9,8,7,9,10};
        printArray(a);
        orderUsingComparator(a, desc);
        printArray(a);


        some(Arrays.asList(a));

    }


    public static void some(List<Integer> list) {
        list.stream().sorted(desc).forEach(System.out::println);
        System.out.println("");
        list.stream().filter(a->a%2==0).forEach(System.out::println);
    }


    public static Integer[] orderUsingComparator(Integer[] array, Comparator<Integer> c) {
       Arrays.sort(array,c);
       return array;
    }


    public static void printArray(Integer[] array) {
        Arrays.stream(array).forEach(a->System.out.print(a + ", "));
        System.out.println();
    }

}
