public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffePrice = 1.0;
        double lattePrice = 3.0;
        double cappucinoPrice = 3.25;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = false;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //

        //Cindhuri ordered a coffee. Print to the console the correct status message, based on her order status.
        if (!isReadyOrder1){
            System.out.println(customer1 + pendingMessage);
        } else {
            System.out.println(customer1 + readyMessage);
            System.out.println(displayTotalMessage + dripCoffePrice);
        }
        
        //Noah ordered a cappucino. Use an if statement to check the status of his order and print the correct status message. If it is ready, also print the message to display the total.
        System.out.println(generalGreeting + customer4);
        if (!isReadyOrder4){
            System.out.println(customer4 + pendingMessage);
        } else {
            double totalPrice = 0.0;
            totalPrice += cappucinoPrice;
            totalPrice += mochaPrice;
            System.out.println(customer4 + readyMessage);
            System.out.println(displayTotalMessage + totalPrice);
        }
        
        //Sam just ordered 2 lattes, print the message to display their total. Next, use an if statement to print the appropriate order status message.
        System.out.println(generalGreeting + customer2);
        if (!isReadyOrder2){
            System.out.println(customer2 + pendingMessage);
        } else {
            double totalPrice = 0.0;
            totalPrice += lattePrice;
            totalPrice += lattePrice;
            System.out.println(customer2 + readyMessage);
            System.out.println(displayTotalMessage + totalPrice);
        }

        //Jimmy just realized he was charged for a coffee but had ordered a latte. Print the total message with the new calculated total (what he owes) to make up the difference.
        System.out.println(generalGreeting + customer3);
        if (!isReadyOrder3){
            System.out.println(customer3 + pendingMessage);
        } else {
            double totalPrice = 0.0;
            totalPrice += dripCoffePrice;
            System.out.println(customer3 + readyMessage);
            System.out.println(displayTotalMessage + totalPrice);
            System.out.println();
            System.out.println("Jimmy: I ordered and received a latte but was charged for a drip. I still owe $" + (lattePrice - dripCoffePrice));
        }
    }
}