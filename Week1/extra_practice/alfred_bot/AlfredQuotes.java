package week1.extra_practice.alfred_bot;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        return String.format("Hello, %s. Lovely to see you.", name);
    }
    
    public String guestGreeting(String name, String dayPeriod) {
        return String.format("%s, %s. Lovely to see you.", dayPeriod, name);
    }

    public String dateAnnouncement() {
        String current_datetime = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("E MMM d HH:mm:ss z y"));
        return String.format("It is currently %s", current_datetime);
    }
    
    public String respondBeforeAlexis(String conversation) {
        conversation = conversation.toLowerCase();
        if (conversation.contains("alexis")){
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        } else if (conversation.contains("alfred")){
            return "At your service. As you wish, naturally.";
        } else
            return "Right. And with that I shall retire.";
    }
    
    public String kickBot(){
        return "I have been kicked!";
    }
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}