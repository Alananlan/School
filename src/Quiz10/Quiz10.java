package Quiz10;
/*
Alan Ly
Prof. Iverson
CS211
20 January 2021
 */
import java.util.ArrayList;
public class Quiz10 {

    public Quiz10() {

    }

    public static ArrayList<CalendarDate> doubleMayDates(ArrayList<CalendarDate> list) {

        int fixedsize = list.size(); // sets a fixed size because arraylist is dynamic

        for (int i = 0; i < fixedsize; i++) {

            if (list.get(i).getMonth() == 5) { // comparing if month is 5
                list.add(i+1, list.get(i));
                i++;
            }

        }
        return list;
    }
}
