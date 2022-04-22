package Quiz18b;

public class driver {
    public static void main(String[] args) {
        HeapPriorityQueue<CalendarDate> test60 = new HeapPriorityQueue<CalendarDate>();
       // test60.removeDuplicates();
        test60.add(new CalendarDate()); test60.add(new CalendarDate());
        test60.add(new CalendarDate(12,23,1234)); test60.add(new CalendarDate(12,23,1234));
        System.out.println(test60);  //[12/23/1234, 12/23/1234, 1/1/1970, 1/1/1970]
       // test60.removeDuplicates();
        System.out.println(test60);  //[12/23/1234, 1/1/1970]
    }
}
