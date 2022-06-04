package ro.fasttrackit.code;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Treatment {
    private List<Medication> medicationList;

    public Treatment() {
        this.medicationList = new ArrayList<>();
    }

    public List<Medication> getMedication() {
        return Collections.unmodifiableList(medicationList);
    }

    @Override
    public String toString() {
        return "Treatment{" +
                "medication=" + medicationList +
                '}';
    }

    public void addMedication(Medication medication) {
        //  boolean wasFound = false;
        for (Medication medicaments : medicationList) {
            if (medicaments.getName().equals(medication.getName())) {
                // wasFound = true;
                System.out.println("Medicament is already added");
                return;
            }
        }
        //  if (!wasFound) {
        medicationList.add(medication);
    }

    public void removeMedication(String medication) {
        // boolean wasFound = false;

        for (Medication medicament : medicationList) {
            if (medicament.getName().equals(medication)) {
                //   wasFound = true;
                medicationList.remove(medicament);
                System.out.println("Medicament was removed!");
                return;
            }
        }
        //  if (!wasFound) {
        System.out.println("Medicament cannot be found");
    }

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

    public List<Medication> getMedicamentsForCurrentTime() {
        List<Medication> medicamentsForCurrentTime = new ArrayList<>();
        int currentHour = LocalTime.now().getHour();
        for (Medication medication : medicationList) {
            List<TimeOfDay> timesOfDay = medication.getAdministrationMethod().getTimesOfDay();
            for (TimeOfDay timeOfDay : timesOfDay) {
                if (timeOfDay.getStartHour() <= currentHour && timeOfDay.getEndHour() > currentHour) {
                    medicamentsForCurrentTime.add(medication);
                }
            }
        }
        return medicamentsForCurrentTime;
    }

    public void takeMedicament(String medication) {
        for (Medication medication1 : medicationList) {
            if (medication1.getName().equals(medication)) {
                int remainingQuantity = medication1.consume();
                // remainingQuantity--;
                System.out.println("Medicament taken! The remaining quantity is " + remainingQuantity);
            }
        }
    }

    public String getRemainingQuantity(String medication) {
        int usedQuantity = 0;
        for (Medication medicament : medicationList) {
            if (medicament.getName().equals(medication))
                usedQuantity += medicament.getQuantity();
        }
        return "The number of " + medication + " is " + usedQuantity;
    }
}



