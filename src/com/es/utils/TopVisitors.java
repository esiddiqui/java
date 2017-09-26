package com.es.utils;

import java.util.*;

/**
 * Maintain's a track of top K visitors to a server
 */
public class TopVisitors {


    public static void main(String... args) {
         TopVisitors tracker = new TopVisitors(3);
         Arrays.stream(new String [] {"ehtesham","fatima","ehtesham","spiderman","superman","superman","ehtesham","spiderman","superman","ehtesham",
                 "ehtesham","salman","ehtesham","salman","spiderman","spiderman","ehtesham","prime","prime","ehtesham",
                 "ehtesham","superman","ehtesham","spiderman","spiderman","spiderman","ehtesham","fatima","superman","ehtesham",
                 "ehtesham","spiderman","ehtesham","prime","spiderman","spiderman","ehtesham","spiderman","spiderman","ehtesham",
                 "ehtesham","fatima","ehtesham","prime","salman","prime","ehtesham","spiderman","spiderman","ehtesham",
                 "ehtesham","superman","ehtesham","spiderman","spiderman","spiderman","ehtesham","spiderman","spiderman","ehtesham",
                 "ehtesham","spiderman","ehtesham","spiderman","fatima","spiderman","ehtesham","prime","salman","ehtesham",
                 "ehtesham","spiderman","ehtesham","superman","superman","prime","ehtesham","spiderman","spiderman","ehtesham",
                 "ehtesham","spiderman","ehtesham","spiderman","salman","spiderman","ehtesham","superman","fatima","ehtesham",
                 "ehtesham","salman","ehtesham","spiderman","spiderman","fatima","ehtesham","prime","superman","ehtesham","salman",
                 "salman","salman","salman","salman","salman","salman","salman","salman",
         }).forEach(tracker::log);




         System.out.println("");
         FrequencyRecord[] topK = tracker.getTopVisitors();
         for (int i =0; i< topK.length; i++) {
             System.out.println(topK[i].toString());
         }
    }


    private Hashtable<String,Integer> frequencyTable =  new Hashtable<>();

    private PriorityQueue<FrequencyRecord> top = null; //new PriorityQueue<>(3);

    private int k = 0;

    public TopVisitors(int k) {
        this.k = k;
        this.top= new PriorityQueue<>(k);
    }


    public void log(String ipaddress) {
        int freq = 1;
        if (this.frequencyTable.containsKey(ipaddress)) {
            freq = this.frequencyTable.get(ipaddress) + 1;
        }
        this.frequencyTable.put(ipaddress,freq);
    }


    public FrequencyRecord[] getTopVisitors( )  {

        Enumeration<String> keys = this.frequencyTable.keys();
        while (keys.hasMoreElements()) {
             String key = keys.nextElement();
             int freq = this.frequencyTable.get(key);
             System.out.println(key + "," + this.frequencyTable.get(key).toString());

            if (this.top.size() < k) {
                this.top.add(new FrequencyRecord(key, freq));
                System.out.println("adding " + key + " " + freq );
            } else if (this.top.peek().frequency < freq) {
                FrequencyRecord  removed =  this.top.poll();
                System.out.println("removing " + removed.ipAddress + " " + removed.frequency );

                System.out.println("adding " + key + " " + freq );
                this.top.add(new FrequencyRecord(key, freq));
            }
        }




        Integer[] intArray = new Integer[this.k];
        FrequencyRecord[] freqs = this.top.toArray(new FrequencyRecord[0]);
        Arrays.sort(new FrequencyRecord[0], (f1,f2) -> new Integer(f1.frequency).compareTo(new Integer(f2.frequency)));
        return freqs;
    }



    private class FrequencyRecord implements Comparable<FrequencyRecord> {
        String ipAddress;
        int frequency;
        public FrequencyRecord(String ip, int freq) {
            this.ipAddress = ip;
            this.frequency = freq;
        }

        @Override
        public int compareTo(FrequencyRecord other) {
            return this.frequency-other.frequency;
        }

        @Override
        public String toString() {
            return "IP Address: "  + this.ipAddress + " Frequency: " + this.frequency;
        }

    }


}
