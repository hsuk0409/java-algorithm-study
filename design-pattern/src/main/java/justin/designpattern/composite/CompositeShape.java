package justin.designpattern.composite;

import java.util.Vector;

public class CompositeShape implements Shape {

    private final Vector<Shape> shapes = new Vector<>();

    public void add(Shape shape) {
        shapes.add(shape);
    }

    public void draw() {
        for (int i = 0; i < shapes.size(); ++i) {
            Shape shape = shapes.elementAt(i);
            shape.draw();
        }
    }
}
