package week2.extra_practice.baristas_challenge;

public class Item {
    
    private String name;
    private double price;

    public Item(String name, double price) {
        setName(name);
        setPrice(price);
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

}
