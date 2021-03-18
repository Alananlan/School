package Chapter17;

// Basic tests for Chapter 17 Exercises
// upgraded into generic Search Tree use
// CS211, January 2021, W.P. Iverson, instructor
public class Post {

	public static void main(String[] args) {

//		SearchTree<Double> empty = new SearchTree<Double>();
//		SearchTree<CalendarDate> test = new SearchTree<CalendarDate>();
//		test.add(new CalendarDate(1,1,2021));  test.add(new CalendarDate(12,12,2016));
//		// just 2 nodes for now, many more needed for rigorous testing
//
////		A.  Exercise #7   isFull();
//		System.out.println(test.isFull());	// false
//		System.out.println(empty.isFull());	// true
//		System.out.println(test);	// 2 nodes using toString()
//
////		B.  Exercise #9   equals(t2);
//		System.out.println(test.equals(test));	// true
//		System.out.println(test.equals(empty)); // false
//
////		D.  Exercise #12    removeLeaves();
//		empty.removeLeaves();	empty.print();	// nothing to print
//		test.removeLeaves();	test.print();// [1/1/2021]
//
////		C.  remove process explained in detail via PowerPoint at BJP site
//		empty.remove(42.0);  empty.print();	// nothing to print
//		test.remove(new CalendarDate(1,1,2017));  test.print(); // all gone


		SearchTree<Double> test = new SearchTree<>();

		test.add(3.14); test.add(-42.); test.add(34.1);

		SearchTree<Double> test2 = new SearchTree<>();
		test2.add(-42.); test2.add(3.14); test2.add(34.1);
		System.out.println(test.toString());
		System.out.println(test.isFull());

		System.out.println("EQUALS " + test.equals(test2));
//		test.removeLeaves();
//		System.out.println(test.toString());

		test.add(33.3);
		System.out.println(test.toString());

		test.remove(33.3);
		System.out.println(test.toString());
		System.out.println(test.isFull());


	}
}
