package Assignments;

import java.util.*;

public class ShoppingCart {
    boolean discount = false;
    ArrayList<ItemOrder> cart;
    private double totalShoppingPrice;
    public ShoppingCart() {
        cart = new ArrayList<>();
    }
    public void add(ItemOrder itemorder) {
        cart.add(itemorder);
    }
    public void setDiscount(boolean value) {
        this.discount = value;
    }
    public double getTotal() {
//        for(ItemOrder itemorder: cart) {
//            this.totalPrice += itemorder.getPrice();
//        }

        for(int i = 0; i < cart.size(); i++) {
            totalShoppingPrice += cart.get(i).getPrice();
        }
        return totalShoppingPrice;
    }
}
