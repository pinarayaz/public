package ch.epfl.sweng.exercises.exercise3_solutions;

public class Main {

    public static void main(String[] args) {

        Circle c = new Circle();
        Rectangle r = new Rectangle();
        Triangle t = new Triangle();

        c.color("blue");
        r.color("red");
        t.color("pink");

        Shape innerShape = new ShapeComposite();
        innerShape.add(new Triangle());
        innerShape.add(new Triangle());

        Shape shape = new ShapeComposite();
        shape.add(new Circle());
        shape.add(new Rectangle());
        shape.add(innerShape);

        shape.color("black");
    }
}
