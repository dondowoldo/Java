package foundation.oop.fruitstore;

import java.util.ArrayList;
import java.util.List;

public class FruitStore {
    //function getFruits() that doesn't take any parameters and returns every fruit in the store
    //function getFruits(colorName) that takes name of the color as parameter and returns all fruits with that color name
    //function getFruits(color), that takes class color and returns all fruits that have the same color name and RGB values
    //function buyFruits(list of fruits) that removes the fruit from the store and returns a price.
    //function addFruit(fruit) that adds a fruit to the store.

    private List<Fruit> fruits;

    public FruitStore() {
        this.fruits = new ArrayList<>();
    }

    public List<Fruit> getFruits() {
        return this.fruits;
    }

    public List<Fruit> getFruits(String colorName) {
        List<Fruit> specificColorFruits = new ArrayList<>();
        for (Fruit f : fruits) {
            if (f.getColor().getColor().equals(colorName)) {
                specificColorFruits.add(f);
            }
        }
        return specificColorFruits;
    }

    public List<Fruit> getFruits(Color color) {
        List<Fruit> specificColorFruits = new ArrayList<>();
        for (Fruit f : fruits) {
            if (
                    f.getColor().getColor().equals(color.getColor()) &&
                    f.getColor().getRed() == color.getRed() &&
                    f.getColor().getBlue() == color.getBlue() &&
                    f.getColor().getGreen() == color.getGreen()
            ) {
                specificColorFruits.add(f);
            }
        }
        return specificColorFruits;
    }

    public int buyFruits(List<Fruit> fruitList) {
        int price = 0;
        for (Fruit f : fruitList) {
            if (fruits.contains(f)) {
                fruits.remove(f);
                price += f.getPrice();
            }
        }
        return price;
    }

    public void addFruit(Fruit fruit) {
        this.fruits.add(fruit);
    }
}
