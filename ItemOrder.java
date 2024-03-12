public class ItemOrder {
    private Item item;
    private int quantity;
    private double total;

// initialize item and quantity
    public ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        totalCost();
    }

    //calculate total cost based on quantity and discounts
    private void totalCost() {
        double price = item.getPrice();
        int discountmin = 3; // minimum quantity for discount
        float discount = 0.90F; // discount rate
        if (quantity >= discountmin) {
            total = (price * discount ) * quantity;
        }
        else {
            total = price * quantity;
        }
    }
// using the get method to retrieve the total
    public double getTotal(){
        return total;
    }
// using the get method to retrieve the item
    public Item getItem() {
        return item;
    }
//using the get method to retrieve the quantity
    public int getQuantity() {
        return quantity;
    }
}



