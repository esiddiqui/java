package com.es.utils;


public class Sorter {


    public static void main (String[] args) {
        int[] source = new int []{7, 5, 2, 1, 11, 9, 6, 3, 8, 4};
        //int[] sorted = new Sorter().quickSort(source);
        int[] sorted = new Sorter().mergeSort(source);

        for (int i=0; i<sorted.length; i++) {
            System.out.print(sorted[i] + ", ");
        }


    }


    public int[] quickSort(int[] array) {
        return quickSort(array,0,array.length-1);
    }


    public int[] mergeSort(int[] array) {
        if (array.length<2)
            return array;

        int mid = array.length/2;  //7/2=3  8/2=4
        int[] left = new int[mid]; //3, 4
        int[] right = new int[array.length-mid]; //7-3=4, 8-4= 4

        fillArray(array,left,0,mid-1);
        fillArray(array,right,mid,array.length-1);

        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
        return array;
    }


    /**
     * Merge the sub-arrays using merge sort algorithm into the main array
     * using overwriting
     * @param target
     * @param left
     * @param right
     */
    private void merge(int[] target, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                target[k] = left[i];
                i++;
            } else {
                target[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            target[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            target[k] = right[j];
            j++;
            k++;
        }
    }








    /*
      private methods
     */


    private int[] quickSort(int[] array, int start, int end ) {
        System.out.println("called at s:" + start + "   e:" + end);
        if (start<end) {
            int partitionIndex = partition(array, start, end);
            System.out.println("Partition Index = "  + partitionIndex);
            quickSort(array,0,partitionIndex-1);
            quickSort(array,partitionIndex+1,end);
        }
        return array;
    }

    private int partition(int[] array, int start, int end ) {
        int pivot = array[end];
        int pIndex = start;
        int temp = 0;
        for (int i=start; i<end; i++) {
            if (array[i]<pivot) {
                swap(array,i,pIndex);
                pIndex++;
            }
        }
        swap(array, pIndex,end);
        return pIndex;
    }


    private void swap(int[] array, int i1, int i2) {
        int temp = array[i1];
        array[i1]=array[i2];
        array[i2] = temp;
    }

    private void fillArray(int[] source, int[] target, int from, int to) {
        for (int i=from; i<=to; i++) {
            target[i-from]=source[i];
        }
    }


}
