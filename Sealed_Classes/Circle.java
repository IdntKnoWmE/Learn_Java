package Sealed_Classes;

public final class Circle extends Shape{


    @Override
    protected double area(){
        return Math.PI * getRadius() * getRadius();
    }

    @Override
    protected double perimeter(){
        return 2 * getRadius() * Math.PI;
    }
}
