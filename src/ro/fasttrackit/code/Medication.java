package ro.fasttrackit.code;

import java.time.LocalDate;

public class Medication {
    private final String name;
    private Integer quantity;
    private final Double price;
    private final LocalDate expiryDate;
    private final Usage usage;
    private final AdministrationMethod administrationMethod;

    public Medication(String name, Integer quantity, Double price, LocalDate expiryDate, Usage usage, AdministrationMethod administrationMethod) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;
        this.usage = usage;
        this.administrationMethod = administrationMethod;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    public Usage getUsage() {
        return usage;
    }

    public AdministrationMethod getAdministrationMethod() {
        return administrationMethod;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", expiryDate=" + expiryDate +
                ", description='" + usage + '\'' +
                '}';
    }

}


