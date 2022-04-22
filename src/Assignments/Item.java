package Assignments;

public class Item {
    String name;
    double price;
    int bulkQuantity;
    double bulkPrice;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;

    }
    public Item(String name, double price, int bulkQuantity, double bulkPrice) {
        this.name = name;
        this.price = price;
        this.bulkQuantity = bulkQuantity;
        this.bulkPrice = bulkPrice;
    
    }
    public double priceFor(int quantity) {
        double totalPrice = 0;
        if(quantity < 0) {
            throw new IllegalArgumentException("Error this quantity is negative");
        }
//        if(quantity == 0) {
//            price = 0;
//        }
        if(quantity > bulkQuantity) {
            return bulkPrice;
        } else if (quantity != 0 && quantity < bulkQuantity) {
            return price;
        }

//        int bulkCount = quantity/bulkQuantity;
//        if(quantity > 0 && quantity < bulkQuantity) {
//            totalPrice = quantity*price;
//        }
//        if(bulkQuantity > 0 && quantity > bulkQuantity) {
//            totalPrice = bulkPrice*bulkCount + (quantity % bulkQuantity) * price;
//        }
//
        return totalPrice;
    }
    public String toString() {
        String stringItem = name + ", $" + price;
        if(bulkPrice > 0) {
            stringItem = stringItem + " (" + bulkQuantity + " for $" + bulkPrice + ")";
        }
        return stringItem;
    }
}
