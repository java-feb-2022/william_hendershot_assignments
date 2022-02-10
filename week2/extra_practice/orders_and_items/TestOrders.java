package week2.extra_practice.orders_and_items;

public class TestOrders {
    
    public static void main(String[] args) {

        // Create 4 item variables of type Item and instantiate each as an Item object. Name them item1, item2 etc.
        // Set the price and the name for each -- "mocha", "latte", "drip coffee" and "capuccino" (price is up to you!)
        Item item1 = new Item("mocha", 1.0);
        Item item2 = new Item("latte", 2.0);
        Item item3 = new Item("drip coffee", 0.5);
        Item item4 = new Item("capuccino", 1.5);
        

        // Create 4 order variables of type Order and instantiate each as an Order object. Name them order1, order2 etc.
        // Set each order's name -- "Cindhuri", "Jimmy", "Noah", "Sam".
        Order order1 = new Order("Cindhuri");
        Order order2 = new Order("Jimmy");
        Order order3 = new Order("Noah");
        Order order4 = new Order("Sam");

        // Print the order1 variable to the console to see what happens.
        System.out.println(order1);

        // Predict what will happen if you print order1.total
        // Should print 0.0.
        System.out.println(order1.getTotal());

        // Add item1 to order2's item list and increment the order's total.
        order2.addItem(item1);
        System.out.println(order2);

        // order3 ordered a cappucino. Add the cappuccino to their order list and to their tab.
        order3.addItem(item4);
        System.out.println(order3);

        // order4 added a latte. Update accordingly.
        order4.addItem(item2);
        System.out.println(order4);

        // Cindhuri’s order is now ready. Update her status.
        //But what did she actually order? I guess the only one not used yet, drip coffee.
        order1.addItem(item3);
        order1.toggleReady();
        System.out.println(order1);

        // Sam ordered more drinks - 2 lattes. Update their order as well.
        order4.addItem(item2);
        order4.addItem(item2);
        System.out.println(order4);

        // Jimmy’s order is now ready. Update his status.
        order2.toggleReady();
        System.out.println(order2);
    }
}
