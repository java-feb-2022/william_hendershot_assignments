package week1.cafe_business_logic;

import java.util.ArrayList;

public class CafeUtil {
    
    public int getStreakGoal(int numWeeks){
        int drinkGoal = 0;
        for (int i = 1; i <= numWeeks; i++){
            drinkGoal += i;
        }
        return drinkGoal;
    }
    
    public int getStreakGoal(){
        return getStreakGoal(10);
    }

    public double getOrderTotal(double[] prices){
        double grandTotal = 0.00;
        for (int i = 0; i < prices.length; i++){
            grandTotal += prices[i];
        }
        return grandTotal;
    }

    public void displayMenu(ArrayList<String> menuItems){
        for (int i = 0; i < menuItems.size(); i++){
            System.out.printf("%d %s%n", i, menuItems.get(i));
        }
    }

    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices){
        if (menuItems.size() != prices.size()){
            return false;
        }

        for (int i = 0; i < menuItems.size(); i++){
            System.out.printf("%d %s -- $%,.2f%n", i, menuItems.get(i), prices.get(i));
        }
        return true;
    }

    public void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.printf("Hello, %s%n", userName);
        System.out.printf("There are %d people in front of you.%n", customers.size());
        customers.add(userName);
        System.out.println(customers.toString());
    }

    public void addCustomers(ArrayList<String> customers){
        System.out.println("Please enter each customer's name on a single line.  Quit by entering 'q' into the line.");
        String input = "";
        while (true){
            input = System.console().readLine();
            if (input.toLowerCase().equals("q")){
                return;
            }
            System.out.printf("Adding %s%n", input);
            customers.add(input);
        }
    }

    public void printPriceChart(String product, double price, int maxQuantity){
        System.out.println(product);
        for (int i = 1; i <= maxQuantity; i++){
            System.out.printf("%d - $%,.2f%n", i, price * i - (0.5 * (i - 1)));
        }
    }
}
