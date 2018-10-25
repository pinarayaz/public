package ch.epfl.sweng.exercises.exercise3_solutions;

public abstract class Shape {
    public abstract void color(String color);
    public void add(Shape shape) {
        throw new UnsupportedOperationException("This operation is not supported!");
    }
}
