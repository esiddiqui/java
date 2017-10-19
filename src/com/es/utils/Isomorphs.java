package com.es.utils;


import java.util.HashMap;

public class Isomorphs {


    public void Isomorphs() {}


    public boolean isIsomorph(String s, String t) {

        if (s==null || t==null) {
            System.out.println(s + " and " + t + " are NOT isomorphs");
            return false;
        }

        if (s.length() != t.length()) {
            System.out.println(s + " and " + t + " are NOT isomorphs");
            return false;
        }

        if (s.equalsIgnoreCase(t)) {
            System.out.println(s + " and " + t + " are isomorphs");
            return true;
        }

        HashMap<Character, Character> sMap = new HashMap<>(), tMap = new HashMap<>();
        char[] sArr = s.toCharArray(), tArr = t.toCharArray();

        for (int i=0; i<sArr.length; i++) {
            // s character already seen...
            if (!sMap.containsKey(sArr[i])) {
                //t character already mapped to something, quit!!
                if (tMap.containsKey(tArr[i])) {
                    System.out.println(s + " and " + t + " are NOT isomorphs");
                    return false;
                }
                //add both s,t characters to map...
                sMap.put(sArr[i],tArr[i]);
                tMap.put(tArr[i],sArr[i]);

            } else {  //s character seen
                if ( tArr[i] != sMap.get(sArr[i])) { //null is forgiven
                    System.out.println(s + " and " + t + " are NOT isomorphs");
                    return false;
                }
            }
        }
        System.out.println(s + " and " + t + " are isomorphs");
        return true;
    }


    public static void main (String... args) {

        new Isomorphs().isIsomorph("","");
        new Isomorphs().isIsomorph("abcc","abcc");
        new Isomorphs().isIsomorph("abcc","xyzz");
        new Isomorphs().isIsomorph("abcde","12345");
        new Isomorphs().isIsomorph("abcde","A");
        new Isomorphs().isIsomorph("A","");
        new Isomorphs().isIsomorph("ehtesham","fiuftibn");
        new Isomorphs().isIsomorph("ehtesham","fiuftkbn");


    }


}
