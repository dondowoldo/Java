package foundation.oop.geoshapes;

import java.util.ArrayList;
import java.util.List;

public class ShapeStorage {
    private List<Shape> shapeList;

    public ShapeStorage() {
        this.shapeList = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        this.shapeList.add(shape);
    }

    public int getTotalArea() {
        int total = 0;
        for (Shape s : this.shapeList) {
            total += s.getArea();
        }
        return total;
    }
}
