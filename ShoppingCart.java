import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    public List<ItemOrder> itemOrders;

    // using the constructor to initialize the list of item orders
    public ShoppingCart() {
        itemOrders = new ArrayList<>();
    }

    // add item order to the shopping cart
    public void addItemOrder(ItemOrder order) {
        itemOrders.add(order);
    }

    // remove item order from the shopping cart
    public boolean removeItemOrder(ItemOrder order) {
        return itemOrders.remove(order);
    }

    // search for an item order based on the name
    public ItemOrder searchItemOrder(String itemName) {
        for (ItemOrder order : itemOrders) {
            if (order.getItem().getName().equals(itemName)) {
            }
        }
        return null;
    }
    public double getTotalPrice() {
        double total = 0;
        for (ItemOrder order : itemOrders) {
        }
        return total;
    }
}