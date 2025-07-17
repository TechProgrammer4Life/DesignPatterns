package factoryMethod;

// Factory Method Design Pattern - Object Creation loosely coupled to the factory
interface Shape { void draw(); }
class Circle implements Shape { public void draw() {
        System.out.println("Drawing a Circle");
    } }
class Rectangle implements Shape { public void draw() {
        System.out.println("Drawing a Rectangle");
    } }


// Factory Method Design Pattern - Object Creation loosely coupled to the factory
abstract class ShapeFactory { public abstract Shape createShape(); }
class CircleFactory extends ShapeFactory { public Shape createShape() {
        return new Circle();
    } }
class RectangleFactory extends ShapeFactory { public Shape createShape() {
        return new Rectangle();
    } }


//Main Class to demonstrate Factory Method Design Pattern
public class factoryMethodDesign {
    public static void main(String[] args) {
        ShapeFactory factory1 = new CircleFactory();
        Shape shape1 = factory1.createShape();
        shape1.draw();  // Output: Drawing a Circle

        ShapeFactory factory2 = new RectangleFactory();
        Shape shape2 = factory2.createShape();
        shape2.draw();  // Output: Drawing a Rectangle
    }
}
