package Chapter14;

/* February 2017, CS211, W.P. Iverson, instructor and author
 * this is a start at testing code for Chapter 14 assignment
 * other tests can and will happen....
 */
public class Post {
	public static void main(String[] args) {
//		// store some dates so they can be reused
//        CalendarDate[] store = {new CalendarDate(1,2,10), new CalendarDate(1,1,10), new CalendarDate(12,30,10)};
//        Stack<CalendarDate> testAll = new Stack<CalendarDate>();
//		for (CalendarDate i: store) testAll.push(i); // build a Stack
//		System.out.println(Chapter14java.stutter(testAll)); // 6 dates
//		System.out.println(Chapter14java.equals(testAll,testAll)); // true
//		System.out.println(Chapter14java.isSorted(testAll)); // false
//		for (int i=1;i<=9;i++) testAll.push(new CalendarDate(1,1,10));
//		Chapter14java.removeMin(testAll);
//		while (!testAll.empty())
//			System.out.println(testAll.pop().longDate()); // only 2 remain




		CalendarDate[] store = {new CalendarDate(1,2,10), new CalendarDate(1,2,10), new CalendarDate(12,30,11)};
		Stack<CalendarDate> testAll = new Stack<CalendarDate>();
		for (CalendarDate i: store) testAll.push(i);

		CalendarDate[] store2 = {new CalendarDate(1,2,10), new CalendarDate(1,2,10), new CalendarDate(12,30,11)};
		Stack<CalendarDate> testAll2 = new Stack<CalendarDate>();
		for (CalendarDate i: store2) testAll2.push(i);


		System.out.println(Chapter14java.equals(testAll, testAll2));

		System.out.println(testAll2);


		//System.out.println(Chapter14java.isSorted(testAll));
	}
}
