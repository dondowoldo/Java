package foundation.FileManipulationWithOOP;

import java.util.ArrayList;
import java.util.List;

public class SalesList {

    private List<Sale> listOfSales;

    public SalesList() {
        this.listOfSales = new ArrayList<>();
    }

    public List<Sale> getListOfSales() {
        return listOfSales;
    }

    public void add(Sale sale) {
        this.listOfSales.add(sale);
    }

}
