
class Item {
    private String name;
    private double price;
// initialize name and price
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
//using the get method to retrieve the name
    public String getName() {
        return name;
    }
//using the get method to retrieve the price
    public double getPrice() {
        return price;
    }
}