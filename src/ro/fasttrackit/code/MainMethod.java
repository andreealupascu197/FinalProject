package ro.fasttrackit.code;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainMethod {
    public static void main(String[] args) {
       Treatment treatment = new Treatment();
       treatment.addMedication(new Medication("Vitamin C",100, 35.5, LocalDate.now().plusYears(1), Usage.VITAMINS, new AdministrationMethod(3, Arrays.asList(TimeOfDay.MORNING,TimeOfDay.AFTERNOON),Boolean.TRUE)));
        System.out.println(treatment);
        treatment.addMedication(new Medication("Magnesium", 60, 24.6, LocalDate.now().plusYears(2), Usage.VITAMINS, new AdministrationMethod(1, Arrays.asList(TimeOfDay.MORNING), Boolean.TRUE)));
        System.out.println(treatment);
    }
}
