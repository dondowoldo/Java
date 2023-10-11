package foundation.oop.eshop;

public class InvoiceItem {
    private Product product;
    private int amount;
    private int unitPrice;

    public InvoiceItem(Product product, int amount, int unitPrice) {
        this.product = product;
        this.amount = amount;
        this.unitPrice = unitPrice;
    }

    public int totalPrice() {
        return this.unitPrice * this.amount;
    }

    public int getAmount() {
        return amount;
    }

    public Product getProduct() {
        return product;
    }
}
