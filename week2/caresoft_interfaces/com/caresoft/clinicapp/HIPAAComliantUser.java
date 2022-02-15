package week2.caresoft_interfaces.com.caresoft.clinicapp;

public interface HIPAAComliantUser {
    abstract boolean assignPin(int pin);
    abstract boolean accessAuthorized(Integer confirmedAuthID);
}
