package Abstraction;

public class Square extends Rectangle{

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    private double side;

    public Square (double side){
        setSide(side);
    };

    @Override
    public double area(){
        System.out.println("area of square");
        return side * side;

    }

    @Override
    public double perimeter(){
        System.out.println("Perimeter of square");
        return 4 * side;
    }


    @Override
    public String shape_type() {
        return "Square";
    }
}
