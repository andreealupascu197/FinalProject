package ro.fasttrackit.code;

import java.time.LocalDate;

import java.util.Arrays;


public class MainMethod {
    public static void main(String[] args) {
       Treatment treatment = new Treatment();
       treatment.addMedication(new Medication("Vitamin C",100, 35.5, LocalDate.now().plusYears(1), Usage.VITAMINS, Type.DROPS, new AdministrationMethod(3, Arrays.asList(TimeOfDay.MORNING,TimeOfDay.AFTERNOON),Boolean.TRUE)));
        System.out.println(treatment);
        treatment.addMedication(new Medication("Magnesium", 60, 24.6, LocalDate.now().plusYears(2), Usage.VITAMINS, Type.CAPSULES, new AdministrationMethod(1, Arrays.asList(TimeOfDay.MORNING), Boolean.TRUE)));
        System.out.println(treatment);
        treatment.removeMedication("Magnesium");
        System.out.println(treatment);
        System.out.println(treatment.getRemainingQuantity("Vitamin C"));
        treatment.addMedication(new Medication("Vitamin D",50, 35.5, LocalDate.now().plusYears(1), Usage.VITAMINS, Type.DROPS, new AdministrationMethod(3, Arrays.asList(TimeOfDay.MORNING,TimeOfDay.AFTERNOON, TimeOfDay.EVENING),Boolean.FALSE)));
        System.out.println(treatment.getMedicamentsforUsage(Usage.VITAMINS));
        System.out.println(treatment.getMedicamentsforType(Type.DROPS));
       treatment.takeMedicament("Vitamin C");
        treatment.takeMedicament("Vitamin C");
        System.out.println(treatment.getRemainingQuantity("Vitamin C"));
        MedicationRestock restock = new MedicationRestock();
        restock.write(treatment);
        treatment.takeMedicament("Vitamin C");
        treatment.takeMedicament("Vitamin C");
        restock.write(treatment);
        System.out.println(treatment.getMedicamentsForCurrentTime());


    }
}
