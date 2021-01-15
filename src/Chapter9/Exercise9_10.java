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
		DiscountBill test2 = new DiscountBill(new Employee("clerk"), false);
		System.out.println("\ntest #2  getTotal()");
		System.out.println("preferred: true");
		test2.add(new Item("candy bar", 50, 32));

		//System.out.println(test2.discountToString());
		System.out.println(test2); // .toString() is THE JAVA standard
		System.out.println("getTotal(): "+test2.getTotal());
	}

}
