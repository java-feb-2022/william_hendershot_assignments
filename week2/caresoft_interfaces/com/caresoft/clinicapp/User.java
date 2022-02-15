package week2.caresoft_interfaces.com.caresoft.clinicapp;

public class User {
    protected Integer id;
    protected int pin;
    
    // TO DO: Getters and setters
    // Implement a constructor that takes an ID
    public User(Integer id) {
        this.setId(Integer.valueOf(id));
    }

    public void setId(Integer id) {
        if (!(id.intValue() > 0)) {
            throw new IllegalArgumentException("Please enter a valid ID");
        }
        this.id = Integer.valueOf(id);
    }
    
    public void setPin(int pin) {
        if (!(pin > 0)) {
            throw new IllegalArgumentException("Please enter a valid Pin");
        }
        this.pin = pin;
    }

    public Integer getId() {
        return this.id;
    }

    public int getPin() {
        return this.pin;
    }
}
