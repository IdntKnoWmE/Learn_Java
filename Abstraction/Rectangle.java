package Abstraction;

public abstract class Rectangle extends Shape{
    private double length;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    private double width;

    public double area(){
        System.out.println("area of rectangle");
        return length*width;

    }
    public double perimeter(){
        System.out.println("Perimeter of rectangle");
        return 2*(length + width);
    }



}
