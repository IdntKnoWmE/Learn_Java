package Abstraction;

public abstract class Shape {

    public abstract double area();
    public abstract double perimeter();
    public abstract String shape_type();

    public static void print(){
        System.out.println("Hey Its the abstract class");
    }

}
