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
        if (!wasFound) {
            medicationList.add(medication);
        }
    }

    public void removeMedication(String medication) {
        boolean wasFound = false;

        for (Medication medicament : medicationList) {
            if (medicament.getName().equals(medication)) {
                wasFound = true;
                medicationList.remove(medicament);
                System.out.println("Medicament was removed!");
                break;
            }
        }
        if (!wasFound) {
            System.out.println("Medicament cannot be found");
        }
    }

    public String getRemainingQuantity(String medication) {
        int usedQuantity = 0;
        for (Medication medicament : medicationList) {
            if (medicament.getName().equals(medication))
                usedQuantity += medicament.getQuantity();
        }
        return "The number of " + " is " + usedQuantity;
    } //will review

    public List<Medication> getMedicamentsforUsage(Usage medicationUsage) {
        List<Medication> medicaments = new ArrayList<>();
        for (Medication medicament : medicationList) {
            if (medicament.getUsage().equals(medicationUsage)) {
                medicaments.add(medicament);
            }
        }
        return medicaments;
    }

    public List<Medication> getMedicamentsforType(Type medicationType) {
        List<Medication> medicaments = new ArrayList<>();
        for (Medication medicament : medicationList) {
            if (medicament.getType().equals(medicationType)) {
                medicaments.add(medicament);
            }
        }
        return medicaments;
    }
}
// - metoda care sa printeze ce medicamente trebuie luate based on timpul zile
// - metoda care sa printeze un mesaj atunci cand cantitatea scade sub un anumit nr
//-  generare raport - lista cu urmatoarele medicamente ce trebuie achizionate

