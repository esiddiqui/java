package com.es.transit;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.es.transit.domain.Station;

public class Transit {

    public static void main (String[] args) {
        System.out.println("Boot straping a new transit node");
        new Transit().init();
    }


    public  void init() {
        List<Station> stations = readStations();
        stations.stream().forEach(System.out::println);
    }


    public List<Station> readStations() {

        List<Station> stations= new ArrayList<>();
        String line="";
        try {
            File file = new File("C:\\Users\\ES230022\\Desktop\\go_transit_data\\google_transit\\stops.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            boolean skipHeader=true;
            while ( (line = reader.readLine()) != null) {
                System.out.println(line);
                 if (!skipHeader)
                  stations.add(new Station(line.split(",")));
                 skipHeader=false;
            }
        } catch (IOException e) {
            System.err.println("Error reading stations files " + e.getMessage() + "  "  + line);
        }
        return stations;
    }






}
