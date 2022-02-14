package week2.extra_practice.coffeedore_64;

import java.util.ArrayList;

public class OrderKiosk {
    
    protected ArrayList<Item> menu;
    protected ArrayList<Order> orders;

    public OrderKiosk() {
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();
    }

    public void addMenuItem(String name, double price) {
        try {
            int nextIndex = menu.size();
            Item newItem = new Item(name, price);
            newItem.setIndex(nextIndex);
            this.menu.add(newItem);
        } catch (Exception e) {
            System.out.printf("Error: %s for %f was not added to the menu.", name, price);
        }
    }

    public void displayMenu(){
        for (int i = 0; i < menu.size(); i++) {
            System.out.printf("%2d %10s -- $%,.2f%n", i , menu.get(i).getName(), menu.get(i).getPrice());
        }
    }

    public void newOrder() {

        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
        Order myOrder = new Order(name);

        displayMenu();
        System.out.println("Please enter a menu item index or q to quit.");
        String itemNumber = System.console().readLine();
        while (!itemNumber.toLowerCase().equals("q")) {
            try {
                myOrder.addItem(this.menu.get(Integer.parseInt(itemNumber)));
            } catch (Exception e) {
                
            }
            System.out.println("Please enter a menu item index or q to quit.");
            itemNumber = System.console().readLine();
        }
        System.out.println(myOrder.display());
        this.orders.add(myOrder);

    }

    public void displayOrders() {
        for (Order order : this.orders) {
            order.display();
        }
    }

    public static void main(String[] args){
        OrderKiosk testKiosk = new OrderKiosk();

        //Manually load menu
        boolean addingItems = true;
        String input;
        while (addingItems) {
            System.out.println("Please enter a name for the menu item or q to quit.");
            input = System.console().readLine();
            if (input.toLowerCase().equals("q")) {
                addingItems = false;
                break;
            }
            System.out.println("Please enter a price.");
            testKiosk.addMenuItem(input, Double.parseDouble(System.console().readLine()));
            testKiosk.displayMenu();
        }

        //Main opearation loop
        boolean running = true;
        while (running) {
            testKiosk.newOrder();
            testKiosk.displayOrders();
        }
    }
}
