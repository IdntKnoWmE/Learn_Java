package Inheritance_shapes;

public class Rectangle {

    protected double length;
    protected double width;


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

    protected double perimeter(){
        return 2*(this.length + this.width);
    }

    protected double area(){
        return this.width*this.length;
    }



}
