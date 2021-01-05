package Chapter9;
/*
 * W.P. Iverson, January 2021
 * copied from https://practiceit.cs.washington.edu/problems/bjp5/chapter9/GroceryBill.java
 * so we can work Exercise BJP4 Exercise 9.10: DiscountBill
 * 
 * for Bellevue College, CS211
 */
public class Exercise9_10 {

	public static void main(String[] args221) {
		// a portion of test #1 in Practice-IT
		DiscountBill test1 = new DiscountBill(new Employee("clerk-1"), false);
		System.out.println("test #1 DiscountBill(clerk, preferred)");
		System.out.println("preferred: false");
		System.out.println("clerk: clerk-1");
		System.out.println("clerk: "+test1.getClerk());
		
		// a portion of test #2 in Practice-IT
		DiscountBill test2 = new DiscountBill(new Employee("clerk"), true);
		System.out.println("\ntest #2  getTotal()");
		System.out.println("preferred: true");
		test2.add(new Item("candy bar", 1.35, 0.25));
		test2.add(new Item("toy car", 3.25, 0.5));
		test2.add(new Item("apple", 0.3, 0.05));
		test2.add(new Item("orange", 0.3, 0.05));
		test2.add(new Item("newspaper", 0.99, 0.0));
		//System.out.println(test2.discountToString());
		System.out.println(test2); // .toString() is THE JAVA standard
		System.out.println("getTotal(): "+test2.getTotal());
		System.out.println("getDiscountCount(): "+test2.getDiscountCount());
		System.out.println("getDiscountAmount(): "+test2.getDiscountAmount());
		System.out.println("getDiscountPercent(): "+test2.getDiscountPercent());

		System.out.println();
		System.out.println();
		System.out.println();
		DiscountBill test3 = new DiscountBill();
		test3.add(new Item("candy bar", 1.35, 0.25));
		test3.add(new Item("toy car", 3.25, 0.5));
		test3.add(new Item("apple", 0.3, 0.05));
		test3.add(new Item("orange", 0.3, 0.05));
		test3.add(new Item("newspaper", 0.99, 0.0));
		System.out.println("getTotal(): "+test3.getTotal());
		System.out.println("getDiscountCount(): "+test3.getDiscountCount());
		System.out.println("getDiscountAmount(): "+test3.getDiscountAmount());
		System.out.println("getDiscountPercent(): "+test3.getDiscountPercent());

	}

}
