package foundation.FileManipulationWithOOP;

public class Sale implements Comparable<Sale> {

    private String month;
    private int year;
    private String product;
    private int unitsSold;
    private int revenue;

    public Sale(String month, int year, String product, int unitsSold, int revenue) {
        this.month = month;
        this.year = year;
        this.product = product;
        this.unitsSold = unitsSold;
        this.revenue = revenue;
    }

    public String getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getProduct() {
        return product;
    }

    public int getUnitsSold() {
        return unitsSold;
    }

    public int getRevenue() {
        return revenue;
    }

    @Override
    public int compareTo(Sale other) {
        if (this.revenue == other.revenue) {
            return other.revenue - this.revenue;
        } else {
            return this.revenue - other.revenue;
        }
    }
}
