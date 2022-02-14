package week2.extra_practice.coffeedore_64;

import java.util.ArrayList;

public class Order {
    
    private String name;
    private double total;
    private boolean ready;
    private ArrayList<Item> items;

    public Order(){
        this("Guest");
    }
    
    public Order(String name) {
        this.setName(name);
        this.setTotal(0.0);
        this.ready = false;
        this.items = new ArrayList<Item>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void toggleReady() {
        this.ready = !this.ready;
    }

    private void setTotal(double total) {
        this.total = total;
    }

    public void addToTotal(double price) {
        this.total += price;
    }

    public void addItem(String name, double price) {
        this.items.add(new Item(name, price));
        this.addToTotal(price);
    }

    public void addItem(Item item){
        this.items.add(new Item(item.getName(), item.getPrice()));
        this.addToTotal(item.getPrice());
    }

    public void removeItem(String name) {
        for (int i = 0; i < this.items.size(); i++) {
            if (items.get(i).getName().equals(name)) {
                items.remove(i);
                return;
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public double getTotal() {
        return this.total;
    }

    public double getOrderTotal() {
        return this.total;
    }

    public String getStatusMessage() {
        return this.isReady() ? "Your order is ready." : "Thank you for waiting.  Your order will be ready soon.";
    }

    public double recalulateTotal() {
        double subTotal = 0.0;
        if (this.items.size() > 0) {
            for (Item item : this.items) {
                subTotal += item.getPrice();
            }
        }
        this.setTotal(subTotal);
        return subTotal;
    }

    public boolean isReady() {
        return this.ready;
    }

    public String display() {
        return this.toString();
    }

    public String toString() {
        String result = "";
        
        result += String.format("Customer Name: %s%n", this.getName());
        result += String.format("Order is ready: %s%n", this.isReady());
        result += String.format("Items:%n");
        for (Item item : this.items) {
            result += String.format("%-12s |$%,.2f%n", item.getName(), item.getPrice());
        }
        result += String.format("--------------------------------%n");
        result += String.format("Total: $%,.2f%n", this.getTotal());

        return result;
    }
}
