/*

Alan Ly
Prof. Iverson
CS211
4 January 2021

Used protected List from GroceryBill in for-each loops to reduce redundancy

 */


import java.util.*;

public class DiscountBill extends GroceryBill {

    private double discountedTotal;
    private Employee name;
    private boolean preferredEmployee;

    public DiscountBill(Employee clerk, boolean preferred) {
        super(clerk);
        preferredEmployee = preferred;
    }

    public DiscountBill(Employee clerk) {
        super(clerk);
        preferredEmployee = false;
    }

    public DiscountBill() {
        this(null);
        preferredEmployee = false;
    }

    // get functions (mutator then accessor)//

    public double getTotal() {
        double discountedTotal = 0;

        if (preferredEmployee == true) {
            for (Item item : super.receipt) {
                discountedTotal += item.getPrice() - item.getDiscount();
            }
            return Math.rint(discountedTotal * 100) / 100.0;
        } else {
            return super.getTotal();
        }
    }

    public int getDiscountCount() {
        int discountCount = 0;
            if (preferredEmployee == true) {
                for (Item item : super.receipt) {
                    if (item.getDiscount() != 0.0) {
                        discountCount++;
                    }
                }
            }
        return discountCount;
    }

    public double getDiscountAmount() {
        return Math.rint((super.getTotal() - getTotal()) * 100) / 100.0; //get the total after discounted each item
    }

    public double getDiscountPercent() {
        return (Math.abs((getTotal() - super.getTotal())/super.getTotal())) * 100);
    }
}