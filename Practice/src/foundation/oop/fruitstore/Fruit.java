package foundation.oop.fruitstore;

public class Fruit {

    private Color color;
    private String name;
    private int price;

    public Fruit(Color color, String name, int price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }

    public Color getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return  this.color + " " + this.name;
    }
}
