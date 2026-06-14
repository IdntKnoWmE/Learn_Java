package Inheritance_shapes;

import java.util.Scanner;

public class Run {

    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Shape type");
        String shape = scanner.next();

        switch (shape) {
            case "square" -> calc_square();
            case "rectangle" -> calc_rectangle();
            default -> System.out.println("No such exist right now");
        }

        scanner.close();

    }


    public static void calc_rectangle(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Rectangle length");
        double length = scanner.nextDouble();

        System.out.println("Enter the Rectangle width");
        double width = scanner.nextDouble();

        Rectangle rectangle = new Rectangle();
        rectangle.setLength(length);
        rectangle.setWidth(width);

        System.out.println("The area of rectangle is: " + rectangle.area());
        System.out.println("The perimeter of rectangle is: " + rectangle.perimeter());

    }

    public static void calc_square(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Square side");
        double side = scanner.nextDouble();

        Square square = new Square();
        square.setLength(side);

        System.out.println("The area of square is: " + square.area());
        System.out.println("The perimeter of square is: " + square.perimeter());

    }
}
