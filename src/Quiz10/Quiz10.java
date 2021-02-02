package Quiz10;
/*
Alan Ly
Prof. Iverson
CS211
20 January 2021
 */
import java.util.ArrayList;
public class Quiz10 {
    public static void main(String[] a408) {
        ArrayList<CalendarDate> dates = new ArrayList<CalendarDate>(764);
        dates.add(new CalendarDate(5, 5, 2018));
        dates.add(new CalendarDate(10, 5, 2018));
        dates.add(new CalendarDate(5, 7, 2017));
        dates.add(new CalendarDate(10, 5, 2020));
        dates.add(new CalendarDate(5, 3, 2020));
        System.out.println("Before: " + dates); // 4 items in list
        doubleMayDates(dates);
        System.out.println(" After: " + dates); // now 6 items in list
    }
    public Quiz10() {

    }

    public static ArrayList<CalendarDate> doubleMayDates(ArrayList<CalendarDate> list) {

        int fixedsize = list.size(); // sets a fixed size because arraylist is dynamic

        for (int i = 0; i < fixedsize; i++) {

            if (list.get(i).getMonth() == 5) { // comparing if month is 5
                list.add(i+1, list.get(i));
                i++;
                fixedsize++;
            }

        }
        return list;
    }
}
