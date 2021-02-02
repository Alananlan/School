package Quiz11;

import Quiz10.CalendarDate;

/*Alan Ly
Prof. Iverson
CS211
27 January 2021 */

import java.util.*;
// Iverson's starter code:
// copyright Bellevue College
public class Quiz11 {
    public static void main(String[] args272) {
        ArrayList<CalendarDate> list1 = new ArrayList<CalendarDate>(500);
        System.out.println(maxYearOccurrences(list1)); //   0 is returned when list is empty
        list1.add(new CalendarDate(5, 5, 1550));
        list1.add(new CalendarDate(5, 5, 2000));
        list1.add(new CalendarDate(5, 5, 1550));
        list1.add(new CalendarDate(5, 5, 1550));
        list1.add(new CalendarDate(5, 5, 1550));
        list1.add(new CalendarDate(5, 5, 1550));
        list1.add(new CalendarDate(5, 5, 1550));

        System.out.println(maxYearOccurrences(list1)); //   4 times we have the year 2018
    }

    // solutions go below here:
    public static int maxYearOccurrences(List<CalendarDate> list) {

        Map<Integer, Integer> map = new HashMap<>();
        int mode = 0; // for the return 0 as per request

        for (CalendarDate date : list) {

            // initializes when map doesn't contain year
            if (!map.containsKey(date.getYear())) {
                map.put(date.getYear(), 1);
            } else if (map.containsKey(date.getYear())) { // if year exists, increment by 1
                map.put(date.getYear(), map.get(date.getYear()) + 1);
            }

            if (map.get(date.getYear()) > mode) { // updates mode
                mode = map.get(date.getYear());
            }

        }

        return mode;

    }
}