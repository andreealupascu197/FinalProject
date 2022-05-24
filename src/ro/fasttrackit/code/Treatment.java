package ro.fasttrackit.code;

import java.util.ArrayList;
import java.util.List;

public class Treatment {
    private List<Medication> medicationList;

    public Treatment() {
        this.medicationList = new ArrayList<>();
    }

    public List<Medication> getMedication() {
        return medicationList;
    }

    @Override
    public String toString() {
        return "Treatment{" +
                "medication=" + medicationList +
                '}';
    }

    public void addMedication(Medication medication) {
        boolean wasFound = false;
        for (Medication medicaments : medicationList) {
            if (medicaments.getName().equals(medication.getName())) {
                wasFound = true;
                System.out.println("Medicament is already added");
            }
        }
        if(!wasFound) {
            medicationList.add(medication);
        }
    }
}
