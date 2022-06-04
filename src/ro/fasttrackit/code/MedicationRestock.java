package ro.fasttrackit.code;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class MedicationRestock {
    private static Path RESTOCK = Path.of("File","medicationRestock.txt");

    public Treatment read(){
        return null;
    }

    public void write(Treatment tratament) {
        try(BufferedWriter writer =  new BufferedWriter(new FileWriter(RESTOCK.toFile()))) {
            for(Medication i : tratament.getMedication()) {
                writer.write(medicationToLine(i));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("You cannot add medicaments in the file");
        }
    }

    public String medicationToLine(Medication i) {
        return i.getName() +  "|" + i.getType() + "|" + i.getUsage() + "|" + i.getQuantity() + "|" + i.getPrice();
    }

}
