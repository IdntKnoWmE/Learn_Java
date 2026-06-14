package Objects;

import java.util.Scanner;

public class CarBuilder {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Car 1

        System.out.println("Enter the Car 1 Model");
        String car1_model = scanner.next();

        System.out.println("Enter the Car 1 Make");
        String car1_make = scanner.next();

        System.out.println("Enter the Car 1 Color");
        String car1_color = scanner.next();

        System.out.println("Enter the Car 1 Year");
        int car1_year = scanner.nextInt();

        Car car1 = buildCar(car1_make, car1_model, car1_color, car1_year);

        System.out.println(car1.toString());
        System.out.println(car1.getClass());

        // Car 1

        System.out.println("Enter the Car 2 Model");
        String car2_model = scanner.next();

        System.out.println("Enter the Car 2 Make");
        String car2_make = scanner.next();

        System.out.println("Enter the Car 2 Color");
        String car2_color = scanner.next();

        System.out.println("Enter the Car 2 Year");
        int car2_year = scanner.nextInt();

        Car car2 = buildCar(car2_make, car2_model, car2_color, car2_year);

        System.out.println(car2.toString());
        System.out.println(car2.getClass());

        // Compare Car
        var result = compareCar(car1, car2);
        System.out.println("Cars are same: " + result);
    }

    static Car buildCar(String make, String model, String color, int year) {

        Car car = new Car(make, model);
        car.setColor(color);
        car.setYear(year);

        return car;
    }

    static boolean compareCar(Car car1, Car car2) {

        return car1.equals(car2);

    }

}

class Car {
    private String make;
    private String model;
    private String color;
    private int year;

    // Constructor
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    // Setter
    public void setColor(String color) {
        this.color = color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Getter
    public String getColor() {
        return this.color;
    }

    public String getModel() {
        return this.model;
    }

    public String getMake() {
        return this.make;
    }

    public int getYear() {
        return this.year;
    }

    @Override
    public String toString() {
        return String.format("Car [Make: %s, Model: %s, Color: %s, Year: %d", make, model, color, year);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        return this.make.equals(car.make) && this.model.equals(car.model) && this.color.equals(car.color) && this.year == car.year;
    }

}




