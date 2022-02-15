package week2.caresoft_interfaces.com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAAComliantUser {
    
    public final int PIN_LENGTH = 4;

    private ArrayList<String> patientNotes;

    public Physician(Integer id) {
        super(id);
        this.patientNotes = new ArrayList<String>();
    }

    public ArrayList<String> getPatientNotes() {
        return this.patientNotes;
    }

    public boolean accessAuthorized(Integer id) {
        return id.equals(this.id);
    }

    public boolean assignPin(int pin) throws IllegalArgumentException {
        String testPin = Integer.toString(pin);
        if (testPin.length() == PIN_LENGTH) {
            super.setPin(pin);
            return true;
        }
        return false;
    }

    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
}
