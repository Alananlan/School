package Assignments;

public class ItemOrder {
    private Item item;
    private int quantity;
    private double priceOfTotal;
    
    public ItemOrder (Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
    public double getPrice() {
        if(quantity == 0) {
            priceOfTotal = 0;
        }
        int bulkCount = quantity/item.bulkQuantity;
//        if(quantity > 0 && quantity < item.bulkQuantity) {
//            totalPrice = quantity*item.price;
//        }
//        if(item.bulkQuantity > 0 && quantity > item.bulkQuantity) {
//            totalPrice = item.bulkPrice*bulkCount + (quantity % item.bulkQuantity) * item.price;
//        }
//

        if(quantity < item.bulkQuantity) {
            priceOfTotal = quantity*item.price;
        }
        if(quantity > item.bulkQuantity) {
            priceOfTotal = item.bulkPrice * bulkCount + ((quantity % item.bulkQuantity) * item.price);
        }



//        return item.priceFor(quantity);
        return priceOfTotal;
    }
    public Item getItem() {
        return item;
    }
}
