package Sealed_Classes;

public sealed class Rectangle extends Shape permits Square{

    @Override
    protected double area(){
        return getLength()*getBreadth();
    }

    @Override
    protected double perimeter(){
        return 2*(getLength()+getBreadth());
    }
}
