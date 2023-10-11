package foundation.oop.eshop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer implements Comparable<Customer> {
    static List<Customer> customers = new ArrayList<>();
    private List<Invoice> invoices;
    private String name;

    public Customer(String name) {
        this.name = name;
        this.invoices = new ArrayList<>();
        customers.add(this);
    }

    public String getName() {
        return name;
    }

    public void add(Invoice invoice) {
        this.invoices.add(invoice);
    }

    public int getTotalSpent() {
        int total = 0;
        for (Invoice i : invoices) {
            total += i.totalPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return this.name + ", total spent: " + this.getTotalSpent() + " Kc";
    }

    public static List<Customer> topCustomers() {
        Collections.sort(customers);
        List<Customer> topCustomers = new ArrayList<>();

        int length = Math.min(customers.size(), 3);
        for (int i = 0; i < length; i++) {
            topCustomers.add(customers.get(i));
        }
        return topCustomers;
    }

    @Override
    public int compareTo(Customer other) {
        return other.getTotalSpent() - this.getTotalSpent();
    }
}
