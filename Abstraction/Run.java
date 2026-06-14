package Abstraction;

public class Run {

    public void main(String[] args){

        // Rectangle rectangle = new Rectangle(); Cannot instantiate the abstract class.
        // Since rectangle is an abstract class we can't use anything of it here just we can have a
        // object type as rectangle that's it and this object type can be of shape also.
        Rectangle square1 = new Square(4.4);
        Shape square2 = new Square(5.5);

        System.out.println(square1.area());
        System.out.println(square2.area());

        Shape.print();

    }

}
