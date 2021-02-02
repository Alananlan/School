package Assignments;

import java.util.*;

public class MapsAndSets {

    public static void main(String args[]) {

        Set<Integer> set1 = new HashSet<Integer>();
        set1.add(1);
        set1.add(4);
        set1.add(7);
        set1.add(9);

        Set<Integer> set2 = new HashSet<Integer>();
        set2.add(2);
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);

        System.out.println(symmetricSetDifference(set1, set2));

    }

    public static Set<Integer> symmetricSetDifference(Set<Integer> s1, Set<Integer> s2) {

        Set<Integer> newSet = new TreeSet<>(); // treeset for organization

        for(int i : s1) {

            if (!s2.contains(i)) {
                newSet.add(i);
            }
        }

        for(int i : s2) {

            if (!s1.contains(i)) {
                newSet.add(i);
            }
        }
        return newSet;
    }

    public static boolean contains3 (List<String> list) {

        Map<String, Integer> map = new TreeMap<String, Integer>();
        int value;

        for(String s : list) {

            if (!map.containsKey(s)) {
                map.put(s, 1);

            } else if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);

                if (map.get(s) == 3) return true;
            }
        }
        return false;
    }

    public static boolean isUnique(Map<String, String> map) {

        Set<String> set = new TreeSet<String>();

        for (String key : map.keySet()) { // iterate through keys in map

            //
            if (set.contains(map.get(key))) return false;

            set.add(map.get(key));
        }


        return true;
    }

    public static Map<String, Integer> intersect (Map<String, Integer> map, Map<String, Integer> map2) {

        Map<String, Integer> newMap = new TreeMap<String, Integer>(); // auxillary treemap, returned map

        for(String s : map.keySet()) {

            if (map2.containsKey(s) && map.get(s) == map2.get(s)) { // checks if map2 has key from map AND if values are equal

                newMap.put(s, map2.get(s));

            }

        }
        return newMap;
    }

    public static int maxOccurrences(List<Integer> list) {

        Map<Integer, Integer> map = new TreeMap<>(); // tracks number of iterations per each integer
        int mode = 0;

        for (int i : list) {

            if (!map.containsKey(i)) {  // adds int and its value as 1 iteration into map treemap
                map.put(i, 1);
            } else if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }

            if(map.get(i) > mode) { // for every iteration of integer, check if value of i is greater than previous
                mode = map.get(i);
            }

        }
        return mode;
    }
}


