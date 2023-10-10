package foundation.oop.fruitstore;

public class Color {
    private String color;
    private int red;
    private int green;
    private int blue;

    public Color(int redValue, int greenValue, int blueValue, String color) {
        this.color = color;
        if (
                redValue < 0 || redValue > 255 ||
                greenValue < 0 || greenValue > 255 ||
                blueValue < 0 || blueValue > 255
        ) {
            throw new IllegalArgumentException("Invalid value(s)");
        }
        this.red = redValue;
        this.green = greenValue;
        this.blue = blueValue;
    }

    public String getColor() {
        return color;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    @Override
    public String toString() {
        return this.color;
    }
}
