package foundation.oop.eshop;

public class DiscountedProduct extends Product {
    private int amountDiscount;

    public DiscountedProduct(String name, int price, int amountDiscount) {
        super(name, price);
        this.amountDiscount = amountDiscount;
    }

    @Override
    public int getPrice() {
        return this.price - amountDiscount;
    }
}
