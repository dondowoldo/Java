package foundation.oop.eshop;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private Customer customer;
    private List<InvoiceItem> invoiceItemList;

    public Invoice(Customer customer) {
        this.invoiceItemList = new ArrayList<>();
        this.customer = customer;
    }

    public int totalPrice() {
        int total = 0;
        for (InvoiceItem i : invoiceItemList) {
            total += i.totalPrice();
        }
        return total;
    }

    public void add(Product product, int amount) {
        this.invoiceItemList.add(new InvoiceItem(product, amount, product.getPrice()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice for: " + this.customer.getName() + "\n");
        for (InvoiceItem item : this.invoiceItemList) {
            sb.append(item.getAmount() + " x " + item.getProduct().getName() + " " + item.totalPrice() + " Kc\n");
        }
        sb.append("---\n");
        sb.append("Total: " + this.totalPrice() + " Kc\n");
        return sb.toString();
    }
}
