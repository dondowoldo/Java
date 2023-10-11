package foundation.oop.eshop;

public class Main {
    public static void main(String[] args) {
        Product almonds = new Product("mandle", 60);
        Product cashews = new Product("kesu", 70);
        Product walnuts = new Product("vlaske orechy", 80);
        Product pecans = new Product("pekanove orechy", 80);
        Product macadamia = new Product("makadamove orechy", 90);

        DiscountedProduct discountedAlmonds = new DiscountedProduct("mandle", 60, 10);

        Customer ales = new Customer("ales");
        Customer lukas = new Customer("Lukas");
        Customer david = new Customer("David");
        Customer matej = new Customer("Matej");

        Invoice i1 = new Invoice(ales);
        ales.add(i1);
        i1.add(discountedAlmonds, 5);
        i1.add(walnuts, 10);
        i1.add(macadamia, 150);

        Invoice i2 = new Invoice(lukas);
        lukas.add(i2);
        i2.add(almonds, 50);
        i2.add(cashews, 110);
        i2.add(pecans, 65);

        Invoice i3 = new Invoice(david);
        david.add(i3);
        i3.add(walnuts, 50);
        i3.add(pecans, 120);
        i3.add(almonds, 15);

        Invoice i4 = new Invoice(matej);
        matej.add(i4);
        i4.add(walnuts, 50);
        i4.add(pecans, 10);
        i4.add(almonds, 15);
        i4.add(macadamia, 80);

        // inflation 💩
        almonds.setPrice(9000);

        Invoice i5 = new Invoice(matej);
        matej.add(i5);
        i5.add(walnuts, 5);
        i5.add(pecans, 1);
        i5.add(almonds, 15);
        i5.add(macadamia, 8);

        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);
        System.out.println(i5);

        System.out.println("Top customers:");

        for (Customer c : Customer.topCustomers()) {
            System.out.println(c);
        }
    }
}
