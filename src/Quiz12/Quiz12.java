package Quiz12;

/*
Alan Ly
Prof. Iverson
CS211
3 February 2021
 */

public class Quiz12 {

    public Quiz12(){
        super(); // zero-parameter constructor
    }

    public static void main(String[] args) {

        System.out.println(removeDupChars("bookkkkkeeper"));

        System.out.println(removeDupChars("String"));

        System.out.println(removeDupChars("bbbbaaaannnananannnaaa"));

        System.out.println(removeDupChars(""));

    }

    private static String removeDupChars(String s) {

        if (s.length() < 2) return s; // if string is just itself, return S, stop case
        else if (s.charAt(0) != s.charAt(1)) return s.substring(0, 1) + removeDupChars(s.substring(1)); // if indexes 0 and 1 are different, return index 0, continue with next indexes
        else return removeDupChars(s.substring(1)); // skips onto next if consecutives are similar
    }
}

