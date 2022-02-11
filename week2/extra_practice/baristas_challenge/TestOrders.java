package week2.extra_practice.baristas_challenge;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class TestOrders {
    
    public static void main(String[] args) {

        final int SEED = 42;

        Random myRands = new Random(SEED);

        HashMap<String, Item> items = new HashMap<String, Item>();
        items.put("mocha", new Item("mocha", 1.0));
        items.put("latte", new Item("latte", 2.0));
        items.put("drip coffee", new Item("drip coffee", 0.5));
        items.put("cappuccino", new Item("capuccino", 1.5));

        // Create 2 orders for unspecified guests (without specifying a name);
        ArrayList<Order> orders = new ArrayList<Order>();
        orders.add(new Order());
        orders.add(new Order());

        // Create 3 orders using the overloaded constructor to give each a name for the order.
        orders.add(new Order("William"));
        orders.add(new Order("Saki"));
        orders.add(new Order("Kazuki"));

        // Add at least 2 items to each of the orders using the addItem method you wrote, for example, to add item1 to order3 you would need to call the addItem method from the order3 instance like so: order3.addItem(item1);
        for (int i = 0; i < orders.size(); i++) {
            Object[] availableItems = items.keySet().toArray();
            int size = availableItems.length;
            orders.get(i).addItem(items.get(availableItems[myRands.nextInt(size)]));
            orders.get(i).addItem(items.get(availableItems[myRands.nextInt(size)]));
            // Test the results and the display method by calling the display method on all of your orders, like so: order3.display();
            System.out.println(orders.get(i).display());
        }


        // Test your getStatusMessage functionality by setting some orders to ready and printing the messages for each order. For example: order2.setReady(true); System.out.println(order2.getStatusMessage());
        orders.get(1).toggleReady();
        System.out.println(orders.get(1).getStatusMessage());
        orders.get(3).toggleReady();
        System.out.println(orders.get(3).getStatusMessage());

        // Test the total by printing the return value like so: System.out.println(order1.getOrderTotal());
        System.out.println(orders.get(1).getOrderTotal());
        System.out.println(orders.get(3).getOrderTotal());


        // Finally, call the display method on all of your orders, like so: order3.display();
        for (Order order: orders){
            System.out.println(order.display());
        }
    }
}
