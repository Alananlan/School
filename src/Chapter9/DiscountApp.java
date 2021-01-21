package Chapter9;
/*
Alan Ly
Prof. Iverson
CS211
18 January 2021
 */
public class DiscountApp extends GroceryBill {

    public boolean discount;

    public DiscountApp(Employee clerk) {
        super(clerk);
        discount = false;
    }

    public DiscountApp() {
        super();
        discount = false;
    }

    public boolean add(Item item, int quantity) {

        super.receipt.removeIf(item::equals); //remove all instance of item

        for (int i = 0; i < quantity; i++) {
            super.add(item);
        }

        return true;
    }

    public double getTotal() {

        double total = 0.0;

        if (discount) {
            for (Item item: super.receipt) {

                total += item.getPrice() - item.getDiscount();

            }
        } else {
            for (Item item : super.receipt) {

                total += item.getPrice();

            }
        }
        return total;
    }

    public void setDiscount(boolean check) {
        this.discount = check;
    }

    public String toString() {
        return super.toString();
    }

}
