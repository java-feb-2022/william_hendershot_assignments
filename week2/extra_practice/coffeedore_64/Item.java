package week2.extra_practice.coffeedore_64;

public class Item {
    
    private String name;
    private double price;
    private int index;

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

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getIndex() {
        return this.index;
    }

}
