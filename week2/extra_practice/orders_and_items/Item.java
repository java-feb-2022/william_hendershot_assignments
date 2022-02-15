package week2.extra_practice.orders_and_items;

public class Item {
    
    private String name;
    private double price;

    public Item(String name, double price) {
        setName(name);
        setPrice(price);
    }

    public Item() {
        setName("Well...");
        setPrice(50.00);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public String toString() {
        return String.format("%s: $%,.2f", this.name, this.price);
    }
}
