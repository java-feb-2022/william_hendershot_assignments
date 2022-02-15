package week2.caresoft_interfaces.com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAAComliantUser, HIPAACompliantAdmin {
    
    public final int PIN_LENGTH = 6;

    private String role;
    private ArrayList<String> securityIncidents;


    public AdminUser(Integer id, String role) {
        super(id);
        this.setRole(role);
        this.securityIncidents = new ArrayList<String>();
    }


    public ArrayList<String> reportSecurityIncidents () {
        return this.securityIncidents;
    }

    public boolean assignPin(int pin) {
        String testPin = Integer.toString(pin);
        if (testPin.length() == PIN_LENGTH) {
            super.setPin(pin);
            return true;
        }
        return false;
    }

    public boolean accessAuthorized(Integer id) {
        if (id.equals(this.id)){
            return true;
        }
        this.authIncident();
        return false;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }

    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
}
