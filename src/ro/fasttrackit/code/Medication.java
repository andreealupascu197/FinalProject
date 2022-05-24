package ro.fasttrackit.code;

import java.time.LocalDate;

public class Medication {
    private final String name;
    private int quantity;
    private final Double price;
    private final LocalDate expiryDate;
    private final Usage usage;
    private final Type type;
    private final AdministrationMethod administrationMethod;

    public Medication(String name, int quantity, Double price, LocalDate expiryDate, Usage usage, Type type, AdministrationMethod administrationMethod) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;
        this.usage = usage;
        this.administrationMethod = administrationMethod;
        this.type = type;
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
    public Type getType() {
        return type;
    }

    public void consume() {
        quantity--;
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


