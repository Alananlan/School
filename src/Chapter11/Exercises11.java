package Chapter11;
import java.util.*;
/**
 * BC CS211
 * Selected Chapter 11 Exercises
 * 
 * W.P. Iverson, July 2019
 */
public class Exercises11
{
    public static void main(String[] a) {
        // Build Integer array
        Integer[] arrayI = {7,4,-9,4,15,8,27,7,11,-5,32,-9,-9};
        ArrayList<Integer> testListI = new ArrayList<Integer>();
        
        // Build an array of Strings
        String[] arrayS = {"Jane","Logan","Whitaker","Alyssa","Stefanie","Jeff","Kim","Sylvia"};
        ArrayList<String> testListS = new ArrayList<String>();
        
        // Build the Set of Strings:
        for (String s: arrayS) testListS.add(s);
        Set<String> testSetS = new TreeSet<String>(testListS);
        
        // Build the Set of Integers:
         Set<Integer> testSetI = new TreeSet<Integer>();       
        for (int i: arrayI) testSetI.add(i);
        
        // Build a Map of Strings:
        Map<String, String> testMapSS = new HashMap<String, String>();
        Map<String, Integer> testMapSI = new HashMap<String, Integer>();
        String[] array2 = {"Jane2","Logan2","Whitaker2","Alyssa2","Stefanie2","Jeff2","Kim2","Sylvia2"};
        for (int i=0; i<arrayS.length; i++) testMapSS.put(arrayS[i], array2[i]);
        for (int i=0; i<arrayS.length; i++) testMapSI.put(arrayS[i], i);
         
        // Exercise 11.8
        System.out.println(testSetS);
        //System.out.println("maxLength="+maxLength(testSetS));       
        
        // Exercise 11.11
        System.out.println(testSetI);
        //System.out.println("symmetricSetDifference="+symmetricSetDifference(testSetI,testSetI));
        
        // Exercise 11.12
        System.out.println(testListS);
        //System.out.println("contains3="+contains3(testListS));
        
        // Exercise 11.13
        System.out.println(testMapSS);
        //System.out.println("isUnique="+isUnique(testMapSS));
        
        // Exercise 11.14
        System.out.println(testMapSI);
        //System.out.println("intersect="+intersect(testMapSI,testMapSI));
        
        // Exercise 11.15
        System.out.println(testListI);
        //System.out.println("maxOccurrences="+maxOccurrences(testListI));
    }
    public static Set<Integer> symmetricSetDifference(Set<Integer> s1, Set<Integer> s2) {

        Set<Integer> newSet = new TreeSet<>(); // treeset for organization

        // adds integer to set if s2 doesn't contain
        for(int i : s1) {

            if (!s2.contains(i)) {
                newSet.add(i);
            }
        }

        // adds integer to set2 if s1 doesn't contain
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

            // if string s is new, then add 1 instance, else increment preexisting string AND check if current string has value == 3
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

        // iterate through keys in map
        for (String key : map.keySet()) {


            if (set.contains(map.get(key))) return false;

            set.add(map.get(key));
        }


        return true;
    }

    public static Map<String, Integer> intersect (Map<String, Integer> map, Map<String, Integer> map2) {

        // auxillary treemap, later returned
        Map<String, Integer> newMap = new TreeMap<String, Integer>();

        for(String s : map.keySet()) {

            // adds value if map2 has key from map AND if values are equal
            if (map2.containsKey(s) && map.get(s) == map2.get(s)) {

                newMap.put(s, map2.get(s));

            }

        }
        return newMap;
    }

    public static int maxOccurrences(List<Integer> list) {

        // tracks number of iterations per each integer
        Map<Integer, Integer> map = new TreeMap<>();
        int mode = 0;

        for (int i : list) {

            // adds int and its value as 1 iteration into map treemap
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }

            // for every iteration of integer, check if value of i is greater than previous
            if(map.get(i) > mode) {
                mode = map.get(i);
            }

        }
        return mode;
    }
}