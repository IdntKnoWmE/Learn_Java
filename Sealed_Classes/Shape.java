package Sealed_Classes;

public sealed class Shape permits Rectangle, Circle{

    private double length;

    public double getBreadth() {
        return breadth;
    }

    public void setBreadth(double breadth) {
        this.breadth = breadth;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    private double breadth;
    private double radius;

    protected double area(){
        return length;
    }

    protected double perimeter(){
        return length;
    }



}
