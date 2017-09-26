package com.es.utils;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class StreamMax {


    public Comparator<Integer> comp = (o1, o2) -> {
        int op2 = o1.intValue();
        int op1 = o1.intValue();
        return (op2 - op1);
    };



    public void printTopK(int k) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter stream items 1/line:");
        PriorityQueue<Integer> queue = new PriorityQueue<>(this.comp);
        boolean done = false;
        int number = 0;
        try {
            while (!done) {
                String input = reader.readLine();
                try {
                    number = Integer.parseInt(input);
                    System.out.println("You entered " + number);
                    queue.add(number);
                    queue.stream().forEach(e->System.out.print(e + " , "));
                    System.out.println("");
                } catch(Exception e) {
                    System.out.println("Not a number, ignored!");
                }

                if ("exit".equalsIgnoreCase(input))
                    done=true;
            }

            System.out.println("Printing all items in pq: "  +  queue.size());
            while (!queue.isEmpty())
                System.out.print(queue.poll()+ ",  ");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StreamMax().printTopK(3);
    }




}
